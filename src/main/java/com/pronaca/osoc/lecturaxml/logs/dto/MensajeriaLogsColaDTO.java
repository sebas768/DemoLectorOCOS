package com.pronaca.osoc.lecturaxml.logs.dto;

import java.io.Serializable;

public class MensajeriaLogsColaDTO implements Serializable{
	
	private static final long serialVersionUID = -3833624658212387889L;
	
	private String nombreServidor = null;
	private int timeOutBaan = 0;
	private String nombreQueueManager = null;
	private String canalQueueManager = null;
	private String ipQueueManager = null;
	private String colaReq = null;
	private String colaResp = null;
	private int puertoQueueManager = 0;
	private String mensajeriaBv = null;
	private String mensajeriaLN;
	
	public String getNombreServidor() {
		return nombreServidor;
	}
	public void setNombreServidor(String nombreServidor) {
		this.nombreServidor = nombreServidor;
	}
	public int getTimeOutBaan() {
		return timeOutBaan;
	}
	public void setTimeOutBaan(int timeOutBaan) {
		this.timeOutBaan = timeOutBaan;
	}
	public String getNombreQueueManager() {
		return nombreQueueManager;
	}
	public void setNombreQueueManager(String nombreQueueManager) {
		this.nombreQueueManager = nombreQueueManager;
	}
	public String getCanalQueueManager() {
		return canalQueueManager;
	}
	public void setCanalQueueManager(String canalQueueManager) {
		this.canalQueueManager = canalQueueManager;
	}
	public String getIpQueueManager() {
		return ipQueueManager;
	}
	public void setIpQueueManager(String ipQueueManager) {
		this.ipQueueManager = ipQueueManager;
	}
	public String getColaReq() {
		return colaReq;
	}
	public void setColaReq(String colaReq) {
		this.colaReq = colaReq;
	}
	public String getColaResp() {
		return colaResp;
	}
	public void setColaResp(String colaResp) {
		this.colaResp = colaResp;
	}
	public int getPuertoQueueManager() {
		return puertoQueueManager;
	}
	public void setPuertoQueueManager(int puertoQueueManager) {
		this.puertoQueueManager = puertoQueueManager;
	}
	public String getMensajeriaBv() {
		return mensajeriaBv;
	}
	public void setMensajeriaBv(String mensajeriaBv) {
		this.mensajeriaBv = mensajeriaBv;
	}
	
	public String getMensajeriaLN() {
		return mensajeriaLN;
	}
	public void setMensajeriaLN(String mensajeriaLN) {
		this.mensajeriaLN = mensajeriaLN;
	}
	@Override
	public String toString() {
		return "MensajeriaColaDTO [nombreServidor=" + nombreServidor + ", timeOutBaan=" + timeOutBaan
				+ ", nombreQueueManager=" + nombreQueueManager + ", canalQueueManager=" + canalQueueManager
				+ ", ipQueueManager=" + ipQueueManager + ", colaReq=" + colaReq + ", colaResp=" + colaResp
				+ ", puertoQueueManager=" + puertoQueueManager + ", mensajeriaBv=" + mensajeriaBv + ", mensajeriaLN="
				+ mensajeriaLN + "]";
	}
	
	
}
