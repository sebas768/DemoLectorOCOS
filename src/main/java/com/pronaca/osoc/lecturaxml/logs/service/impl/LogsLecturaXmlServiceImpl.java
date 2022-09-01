package com.pronaca.osoc.lecturaxml.logs.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pronaca.integracion.conector.wmq.Conector;
import com.pronaca.osoc.lecturaxml.util.ConstantesLogs;
import com.pronaca.osoc.lecturaxml.model.entities.LecIdMensajesLogs;
import com.pronaca.osoc.lecturaxml.model.entities.LecLogsELK;
import com.pronaca.osoc.lecturaxml.exceptions.DAOException;
import com.pronaca.osoc.lecturaxml.logs.dto.MensajeriaLogsColaDTO;
import com.pronaca.osoc.lecturaxml.logs.model.json.Evento;
import com.pronaca.osoc.lecturaxml.logs.service.LogsLecturaXmlService;
import com.pronaca.osoc.lecturaxml.util.ConstantesBv;
import com.pronaca.osoc.lecturaxml.view.dao.ParametroGeneralDAO;
import com.pronaca.osoc.lecturaxml.view.repositories.LecIdMensajesLogsRepository;
import com.pronaca.osoc.lecturaxml.view.repositories.LecLogsELKRepository;

@Service
public class LogsLecturaXmlServiceImpl implements LogsLecturaXmlService {

	private static final Logger log = LoggerFactory.getLogger(LogsLecturaXmlServiceImpl.class);

	@Autowired
	private ParametroGeneralDAO parametroGeneralDao;

	@Autowired
	private LecIdMensajesLogsRepository lecIdMensajesLogsRepository;
	
	@Autowired
	private LecLogsELKRepository lecLogsELKRepository;

	
	@Override
	public boolean registrarLogELK(String codigoPromocion, String UUID, String prefijo,String mensaje, String exitoError, String tipo,
			String paso, String capa, String nivel, String cia, String proceso,Long codigoDetalle,boolean registroObligatorio) {
		String envio="";
		String eventoBDD ="";
		String msgELK = "";
		try {
			//Si el registro es Obligatorio, no dependemos del parametro
			if(registroObligatorio)
				envio = ConstantesBv.VALOR_SI;
			else {
				//Consultamos parametro para envio a logs de Exitos
				if(exitoError!= null && exitoError.equalsIgnoreCase(ConstantesBv.ESTADO_EXITO)) {
					envio = parametroGeneralDao.getString(ConstantesBv.PRM_ENVIO_LOGS_EXITO);
				}else {
				//Consultamos parametro para envio a logs de errores(excepciones)
					envio = parametroGeneralDao.getString(ConstantesBv.PRM_ENVIO_LOGS_ERROR);
				}
			}
			//Procesamiento de logs si aplica envio
			if(envio.equalsIgnoreCase(ConstantesBv.VALOR_SI)) {
				//Obtenemos clase y metodo que llamo al registro
				StackTraceElement[] elements = Thread.currentThread().getStackTrace();
				String nombreMetodo = this.obtenerMetodoReferencia(elements);
				String nombreClase=this.obtenerClaseReferencia(elements);
				//Obtener datos de EVENTOBDD
				eventoBDD = prefijo + " - " + nombreMetodo + " - " + nombreClase;
				//Obtenemos el mensaje a enviar al ELK y a la BDD
				if(mensaje!=null && !mensaje.isEmpty()) {
					msgELK = mensaje;
				}else {
					msgELK = prefijo;
				}
				//Armamos el objeto para envio a MQ
				Evento eventoEnv = new Evento();
				eventoEnv = armarEvento(codigoPromocion,codigoDetalle,UUID,msgELK,exitoError,tipo, paso, capa , nivel, cia, nombreClase, nombreMetodo, proceso);
				
				MensajeriaLogsColaDTO mqCons = consultarParametrosConexionMQ();
				//Obtener JSON para enviar a MQ
				Gson gson = new Gson();
				String JSON = gson.toJson(eventoEnv);
				//Proceso de envio a MQ
				Conector conn = new Conector(mqCons.getTimeOutBaan());
				Integer intentosEnvio = 2;
				Integer intentoEnvio = 1;
				log.info("*****   INICIA ENVIO A SISTEMA DE LOGS PARA: " + eventoEnv.getEventoReferenceId() + " *****");
				while (intentoEnvio <= intentosEnvio) {
					//enviamos el xml al ERP
					if (conn.enviarMensaje(mqCons.getNombreQueueManager(), mqCons.getCanalQueueManager(), mqCons.getIpQueueManager(), mqCons.getPuertoQueueManager(), mqCons.getColaReq(), JSON)) {
						//Guardamos MessageID y referenceID en BDD
						this.guardarMessegeIDEnBDD(javax.xml.bind.DatatypeConverter.printHexBinary(conn.getMessageId()),eventoEnv.getEventoReferenceId());
						//Guardamos log ELK en BDD
						this.guardarLogELKEnBDD(cia,codigoPromocion, codigoDetalle, UUID,eventoBDD,exitoError, mensaje,eventoEnv.getEventoReferenceId() );
						log.info("intentos de envio del xml: " + intentoEnvio + " , para: " + eventoEnv.getEventoReferenceId() );
						break;
					}
					intentoEnvio++;
				}
				log.info("*****   FINALIZA ENVIO A SISTEMA DE LOGS PARA: " + eventoEnv.getEventoReferenceId() + " *****");
			}
		} catch (Exception e) {
			log.error("Error en el metodo registrarLogELK", e); 
			return false;
		}
		
		return true;
	}


	//@Override
	public boolean procesarEnvioLog(String mensaje, String exitoError, String tipo, String paso, String capa, String referenciIde, String nivel, String cia, String proceso) {
		
		String envio="";
			
		try {
			
			/*logica para activar o desactivar el envio a logs ya sea error o exito */
			//Consultamos parametro para envio a logs de Exitos
			if(exitoError!= null && exitoError.equalsIgnoreCase(ConstantesBv.ESTADO_EXITO)) {
				envio = parametroGeneralDao.getString(ConstantesBv.PRM_ENVIO_LOGS_EXITO);
			}else {
			//Consultamos parametro para envio a logs de errores(excepciones)
				envio = parametroGeneralDao.getString(ConstantesBv.PRM_ENVIO_LOGS_ERROR);
			}
       if(envio.equalsIgnoreCase(ConstantesBv.VALOR_SI)) {	
			/*obtiene los datos de la calse y el metodo que se llamo a este meotod princila*/
			StackTraceElement[] elements = Thread.currentThread().getStackTrace();
			String clasePck = elements[2].getClassName();
			String method = elements[2].getMethodName();
			String[] clase = clasePck.split("\\.");
			int cant = clase.length;
			int cont=0;
			String claseReference="";
			for (String string : clase) {
				cont++;
				if (cont==cant) {
					claseReference =string;
				}
			}
			
			
	     
			/*armamos el objeto del evento */
			Evento eventoEnv = new Evento();
			
			//eventoEnv = armarEvento(mensaje,exitoError,tipo, paso, capa, referenciIde, nivel, cia, claseReference, method, proceso);
			
			MensajeriaLogsColaDTO mqCons = consultarParametrosConexionMQ();
			/*
			 * LLAMAR AL SERVICIO
			 */
			Gson gson = new Gson();
			String JSON = gson.toJson(eventoEnv);
			System.out.println("STRING IMP: "+ JSON);
			// establezco la conexión con la mensajería de BAAN
			Conector conn = new Conector(mqCons.getTimeOutBaan());

			Integer intentosEnvio = 2;
			Integer intentoEnvio = 1;

			log.info("*****   INICIA ENVIO A SISTEMA DE LOGS" + JSON + " *****");
			log.info("MQ: " + mqCons.toString());

			//log.info("Operación: " + tipoOperacion);

			while (intentoEnvio <= intentosEnvio) {
				//enviamos el xml al ERP
				if (conn.enviarMensaje(mqCons.getNombreQueueManager(), mqCons.getCanalQueueManager(), mqCons.getIpQueueManager(), mqCons.getPuertoQueueManager(), mqCons.getColaReq(), JSON)) {
					/*almacenamos el messaj id y referencid enviados*/
					
					String hexString = javax.xml.bind.DatatypeConverter.printHexBinary(conn.getMessageId());
					LecIdMensajesLogs iteSave = new LecIdMensajesLogs();
					iteSave.setMessageId(hexString);
					iteSave.setReferenceId(eventoEnv.getEventoReferenceId());
					lecIdMensajesLogsRepository.save(iteSave);
					log.info("intentos de envio del xml: " + intentoEnvio);
					break;
				}
				intentoEnvio++;

			}
			
         }
		} catch (Exception e) {
			log.error("Error al enviar el Descuento a BAANV", e);
			return false;
		}
		return true;
	}

	/**
	 * Obtener el nombre del metodo que llamo a los LOGS ELK
	 * @param elements Hilo de ejecucion
	 * @return Nombre del metodo que ejecuto los LOGS ELK
	 * @author ssandoval
	 */
	private String obtenerMetodoReferencia (StackTraceElement[] elements) {
		return elements[2].getMethodName();
	}
	
	/**
	 * Obtener el nombre de la clase que llamo a los LOGS ELK
	 * @param elements Hilo de ejecucion
	 * @return	Nombre de la clase que ejecuto los LOGS ELK
	 * @author ssandoval
	 */
	private String obtenerClaseReferencia(StackTraceElement[] elements) {
		String claseReference ="";
		String clasePck = elements[2].getClassName();
		String[] clase = clasePck.split("\\.");
		int cant = clase.length;
		int cont=0;
		for (String string : clase) {
			cont++;
			if (cont==cant) {
				claseReference =string;
			}
		}
		return claseReference;
		
	}
	
	/**
	 * Metodo para obtener los parametros de conexion al MQ
	 * @return Parametros conexion a MQ
	 */
	private MensajeriaLogsColaDTO consultarParametrosConexionMQ() {
		MensajeriaLogsColaDTO mq = new MensajeriaLogsColaDTO();
		try {

			mq.setTimeOutBaan(Integer.parseInt(parametroGeneralDao.getString(ConstantesLogs.PRM_TIMEOUT_MQ)));
			mq.setNombreQueueManager(parametroGeneralDao.getString(ConstantesLogs.PRM_QUEUE_MANAGER));
			mq.setCanalQueueManager(parametroGeneralDao.getString(ConstantesLogs.PRM_CANAL_QUEUE_MANAGER));
			mq.setIpQueueManager(parametroGeneralDao.getString(ConstantesLogs.PRM_IP_QUEUE_MANAGER));
			mq.setColaReq(parametroGeneralDao.getString(ConstantesLogs.PRM_COLA_GESTION_MONITOREO));
			mq.setPuertoQueueManager(Integer.parseInt(parametroGeneralDao.getString(ConstantesLogs.PRM_PUERTO_QUEUE_MANAGER)));
		} catch (DAOException e) {
			log.error("No se han encontrado ciertos parametros", e);
			mq = null;
		}

		return mq;
	}
	
	private Evento armarEvento(String codigoPromocion,Long codigoDetalle,String UUID,String mensaje, String exitoError, String tipo, String paso, String capa, String nivel, String cia, String clase, String method, String proceso) {
		Evento eventoRes = new Evento();
		

		eventoRes.setTipo(tipo);//mandatorio
		if(exitoError.equals(ConstantesLogs.ESTADO_EXITO)) {
			if(paso.equalsIgnoreCase(ConstantesLogs.PASO_ENTRADA)) {
				eventoRes.setMensajeEndtrada(mensaje); //opcional
			}else {
				eventoRes.setMensajeSalida(mensaje); //opcional
			}
		}else {
			eventoRes.setMensajeError(mensaje); //opcional
		}
		
		if(exitoError.equals(ConstantesLogs.ESTADO_EXITO)) {
			eventoRes.setEventoCodigo(ConstantesLogs.CODIGO_EXITO); //MANDATARIO
		}else {
			eventoRes.setEventoCodigo(ConstantesLogs.CODIGO_ERROR);//MANDATARIO
		}
		eventoRes.setEventoValor(exitoError); //MANDATARIO
		eventoRes.setEventoNivel(nivel); //MANDATARIO
		eventoRes.setEventoCompania(cia); //MANDATARIO
		eventoRes.setEventoSistema(ConstantesLogs.PRM_CODIGO_SISTEMA_APLICACION_ORIGEN); //MANDATARIO
		eventoRes.setEventoCapa(capa);//MANDATARIO
		if(paso.equalsIgnoreCase(ConstantesLogs.PASO_ENTRADA)) {
			eventoRes.setEventoHoraInicio(new Date().toString()); //OPCIONAL
		}else {
			eventoRes.setEventoHoraFin(new Date().toString());//OPCIONAL
		}
		eventoRes.setEventoReferenceId(this.obtenerCodigoReferencia(codigoPromocion, codigoDetalle, UUID, cia));//mandatorio
		eventoRes.setEventoProcesoNombre(proceso);
		//eventoRes.setEventoActividad("eventoActividad");//opcional
		//eventoRes.setEventoPantalla("eventoPantalla");//opcional
		eventoRes.setEventoClase(clase);
		eventoRes.setEventoMetodo(method);
		//eventoRes.setActualizaValorOriginal("actualizaValorOriginal");//opcional
		//eventoRes.setActualizaValorActualizado("actualizaValorActualizado");//opcional
		//eventoRes.setActualizaValorDescrpcion(cia);//opcional
		eventoRes.setAplicacionNombre(ConstantesLogs.PRM_CODIGO_SISTEMA_APLICACION_ORIGEN);//opcional
		//eventoRes.setHostName("hostName");//opcional
		//eventoRes.setHostIp("hostIp");//opcional
		//eventoRes.setHostOsNombre("hostOsNombre");//opcional
		//eventoRes.setHostOsVersion("hostOsVersion");//opcional
		eventoRes.setComponenteTipo(ConstantesLogs.COMPONENTE_TIPO_MS);
		eventoRes.setComponenteNombre(ConstantesLogs.COMPONENTE_NOMBRE_ENVIO_BV);
		eventoRes.setComponenteOperacion(ConstantesLogs.COMPONENTE_OPERACION_ENVIO_BV);
		eventoRes.setHttpRequestMetodo(" ");//opcional
		//eventoRes.setHttpCodigoRespuesta("httpCodigoRespuesta");//opcional
		//eventoRes.setUrlFull("urlFull");//opcional
		//eventoRes.setUrlPath("urlPath");//opcional
		//eventoRes.setUrlPuerto("urlPuerto");//opcional
		/*se qeuman esats constantes ya que esta aplciacion trabaja sola con tareas autoamticas y 
		 * no tiene iteraccion con usaurios para obtener esoa datos*/
		eventoRes.setUsuarioNombre(ConstantesLogs.PRM_CODIGO_SISTEMA_APLICACION_ORIGEN);
		eventoRes.setUsuarioEmail("mediador@Pronaca.com");
		eventoRes.setUsuarioNombrecompleto("mediado mediador");
		//eventoRes.setEventoPantalla(referencia);
		eventoRes.setEventoPaso(paso);
		//eventoRes.setUsuarioRol("mediador");//opcional
		//eventoRes.setUsuarioNumeroIntentosAcceso("usuarioNumeroIntentosAcceso");//opcional
		
		
		return eventoRes;
	}
	
	/**
	 * Metodo para obtener codigo de referencia
	 * @param codigoPromocion
	 * @param codigoDetalle
	 * @param UUID
	 * @param cia
	 * @return codigo de referencia
	 * @author ssandoval
	 */
	private String obtenerCodigoReferencia(String codigoPromocion,Long codigoDetalle,String UUID,String cia) {
		StringBuilder referencia = new StringBuilder();
		referencia.append(ConstantesBv.PRM_CODIGO_SERVICIO_DESCUENTOS_BV);
		if(cia!=null && !cia.isEmpty())
			referencia.append("_"+cia);
		if(codigoPromocion!=null && !codigoPromocion.isEmpty())
			referencia.append("_"+codigoPromocion);
		if(codigoDetalle!=null && codigoDetalle>0)
			referencia.append("_"+codigoDetalle);
		if(UUID!=null && !UUID.isEmpty())
			referencia.append("_"+UUID);
		return referencia.toString();
	}
	
	/**
	 * Metodo para guardar messageID devuelto por MQ en BDD
	 * @param messageId
	 * @param referenceID
	 */
	private void guardarMessegeIDEnBDD(String messageId,String referenceID) {
		try {
			LecIdMensajesLogs iteSave = new LecIdMensajesLogs();
			iteSave.setMessageId(messageId);
			iteSave.setReferenceId(referenceID);
			lecIdMensajesLogsRepository.save(iteSave);
		} catch (Exception e) {
			log.error("Error en el metodo guardarMessegeIDEnBDD", e);
		}

	}
	
	/**
	 * Metodo para guardar logs ELK en BDD
	 * @param codigoCompania
	 * @param codigoPromocion
	 * @param codigoDetalle
	 * @param UUID
	 * @param evento
	 * @param estado
	 * @param mensaje
	 * @param referenceID
	 */
	private void guardarLogELKEnBDD(String codigoCompania,String codigoOrden, Long codigoDetalle,String UUID, String evento,String estado, String mensaje,String referenceID) {
		try {
			LecLogsELK logELK = new LecLogsELK();
			logELK.setCodigoOrden(codigoOrden);
			logELK.setUuid(UUID);
			logELK.setReferenceId(referenceID);
			logELK.setEvento(evento);
			logELK.setEstado(estado);
			if(mensaje!=null && !mensaje.isEmpty()) {
				if(mensaje.length()>3998) {
					logELK.setMensajeRespuesta(mensaje.substring(0, 3997));
				}else {
					logELK.setMensajeRespuesta(mensaje);
				}
			}else {
				logELK.setMensajeRespuesta("");
			}
			if(codigoDetalle!=null && codigoDetalle>0) {
				logELK.setCodigoDetalle(codigoDetalle);
			}else {
				logELK.setCodigoDetalle(null);
			}
			if(codigoCompania!=null && !codigoCompania.isEmpty()) {
				logELK.setCodigoCompania(codigoCompania);
			}
			lecLogsELKRepository.save(logELK);
		} catch (Exception e) {
			log.error("Error en el metodo guardarLogELKEnBDD", e);
		}
	}

}
