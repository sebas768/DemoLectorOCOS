package com.pronaca.osoc.lecturaxml.util;

public class ConstantesLogs {
	
	/********
	 * constantantes para integrcion con sistema de LOGS
	 * LOS PARAMENTROS ESTARAN EN LA BDD DE DESAGREGADOR
	 */

	public static final String PRM_TIMEOUT_MQ = "PRM_TIMEOUT_MQ";

	public static final String PRM_QUEUE_MANAGER = "PRM_QUEUE_MANAGER";

	public static final String PRM_CANAL_QUEUE_MANAGER = "PRM_CANAL_QUEUE_MANAGER";

	public static final String PRM_IP_QUEUE_MANAGER = "PRM_IP_QUEUE_MANAGER";

	public static final String PRM_COLA_GESTION_MONITOREO= "PRM_COLA_GESTION_MONITOREO";
	
	public static final String PRM_PUERTO_QUEUE_MANAGER = "PRM_PUERTO_QUEUE_MANAGER";
	
	/**
	 * Constante que representa el estatus del proceso a enviarse a logstash
	 */
	public static final String ESTADO_EXITO = "EXITO";
	
	/**
	 * Constante que representa el estatus del proceso a enviarse a logstash
	 */
	public static final String ESTADO_ERROR = "ERROR";
	
	
	/**
	 * Constante que representa el tipo de log
	 */
	public static final String TIPO_AUDITORIA = "Auditoria";
	
	/**
	 * Constante que representa e el tipo de log
	 */
	public static final String TIPO_TECNICO = "Tecnico";
	
	
	/**
	 * Constante que representa el paso
	 */
	public static final String PASO_ENTRADA = "Entrada";
	
	/**
	 * Constante que representa e el tipo de log
	 */
	public static final String PASO_SALIDA = "Salida";
	
	
	/**
	 * Constante que representa la capa del log
	 */
	public static final String CAPA_EXPOSICION= "Exposicion";
	
	/**
	 * Constante que representa e el tipo de log
	 */
	public static final String CAPA_INTEGRACION = "Integracion";


	/**
	 * Constante que representa la capa del log
	 */
	public static final String CODIGO_ERROR= "2";
	
	/**
	 * Constante que representa e el tipo de log
	 */
	public static final String CODIGO_EXITO = "3";
	
	/**
	 * Constante que representa e el nivel de log
	 */
	public static final String NIVEL_LOG_INFO = "Info";


	/**
	 * Constante que representa la capa del log
	 */
	public static final String NIVEL_LOG_WARN= "WARN";
	
	/**
	 * Constante que representa e el tipo de log
	 */
	public static final String NIVEL_LOG_ERR = "ERR";
	

	/**
	 * Constante que representa el codigo de empresa pronaca
	 */
	public static final String CODIGO_CIA = "602";
	
	
	/**
	 * Constante que representa el codigo de empresa pronaca
	 */
	public static final String CODIGO_CIA_MADRE = "101";

	

	/**
	 * Constante que representa el codigo de empresa pronaca
	 */
	public static final String CODIGO_SISTEMA= "602";
	
	
	public static final String PRM_CODIGO_SISTEMA_APLICACION_ORIGEN = "MEDIADOR";
	
	/**
	 * Constante  q representa el proceso amcro en que se enviara el log
	 */
	public static final String PROCESO_LOGS_RP= "ENVIO_BV";
	
	/**
	 * Constante  q representa el proceso amcro en que se enviara el log
	 */
	public static final String PROCESO_LOGS_ENVIO_DESC_BV= "PROCESO_LOGS_ENVIO_DESC_BV";
	
	/**
	 * Constante  q representa el proceso amcro en que se enviara el log
	 */	
	public static final String PROCESO_LOGS_ENVIO_DESC_LN= "PROCESO_LOGS_ENVIO_DESC_LN";
	
	
	/**
	 * Constante  q representa el componenente en el que se enviara el LOG
	 */	
	public static final String COMPONENTE_TIPO_MS= "Microservicio";
	
	/**
	 * Constante  q representa el componenente en el que se enviara el LOG
	 */	
	public static final String COMPONENTE_NOMBRE_ENVIO_BV= "ENVIO_BV_PROMOCIONES";
	
	/**
	 * Constante  q representa el componenente en el que se enviara el LOG
	 */	
	public static final String COMPONENTE_OPERACION_ENVIO_BV= "ENVIO_PROMOCIONES_INDIRECTA";
	
	/**
	 * Prefijo mensaje servicio entrada
	 */
	public static final String PREFIJO_MSJ_SERVICIO_ENTRADA = "Inicio Servicio";
	
	/**
	 * Prefijo mensaje servicio salida
	 */
	public static final String PREFIJO_MSJ_SERVICIO_SALIDA = "Finaliza Servicio";
	
	/**
	 * Prefijo mensaje integracion entrada
	 */
	public static final String PREFIJO_MSJ_INTEGRACION_ENTRADA = "Inicio Integracion";
	
	/**
	 * Prefijo mensaje integracion salida
	 */
	public static final String PREFIJO_MSJ_INTEGRACION_SALIDA = "Finaliza Integracion";

}
