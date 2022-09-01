package com.pronaca.osoc.lecturaxml.logs.service;

public interface LogsLecturaXmlService {

	
	/**
	 * Metodo que permite enviar los paramentros necesarios para armar el objeto evento que se enviara a las colas para los logs.
	 * String mensaje paramentro en el que se pondra el mensaje a enviarse a la integracion como log ya sea xml, json, o plano, 
	 * String exitoError =EXITO/ERROR una de las dos opciones, 
	 * String tipo Auditoria/Tecnico uno de las dos opciones, 
	 * String paso Entrada/Salida uno de las dos opciones, 
	 * String capa en que capa se realizo el evento, 
	 * String referenciId debe recibir un secuencial para luego armar un id unico dentro del metodo que se enviara a las colas 
	 */
	//public boolean procesarEnvioLog(String mensaje, String exitoError, String tipo, String paso, String capa, String referenciId, String nivel, String cia, String proceso );
	
	/**
	 * Metodo que permite registras los LOGS en ELK
	 * @param codigoPromocion Codigo de Promocion
	 * @param UUID	UUID
	 * @param mensaje Mensaje que se colocara
	 * @param prefijo Prefijo del mensaje
	 * @param exitoError EXITO/ERROR una de las dos opciones
	 * @param tipo Auditoria/Tecnico uno de las dos opciones
	 * @param paso Entrada/Salida uno de las dos opciones
	 * @param capa Capa en la que se ejecuta EXPOSICION/INTEGRACION 
	 * @param nivel Nivel de log INFORMATIVO/WARNING/ERROR
	 * @param cia Compania sobre la que se procesa el log
	 * @param proceso Nombre del proceso
	 * @param codigoDescuento Codigo de descuento
	 * @param registroObligatorio
	 * 			TRUE=Envio obligatorio a ELK
	 * 			FALSE=Envio a ELK depende del parametro de BDD
	 * 	
	 * @return
	 * 			TRUE=Registro exitoso
	 * 			TRUE=Registro fallido
	 */
	public boolean registrarLogELK(
			String codigoPromocion, 
			String UUID, 
			String prefijo,
			String mensaje,
			String exitoError,
			String tipo,
			String paso,
			String capa,
			String nivel,
			String cia,
			String proceso,
			Long codigoDescuento,
			boolean registroObligatorio
		);
		

}
