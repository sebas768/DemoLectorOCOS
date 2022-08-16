package com.pronaca.osoc.lecturaxml.model.xml;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.pronaca.osoc.lecturaxml.anotacions.LoaderAnotation;
import com.pronaca.osoc.lecturaxml.model.entities.CabeceraOrden;
import com.pronaca.osoc.lecturaxml.model.entities.DetalleCabecera;

/**
 * 
 * @author bayteq
 *
 */
@LoaderAnotation(fileXML = "AplicaPromocion.xml", isUpdateEstatus = false)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "cabecera", "detallesCabecera"})
public class ModelOcos implements Serializable {

	private static final long serialVersionUID = 700413412370715597L;

	@XmlElement(name = "Cabecera", namespace = "")
	private CabeceraOrden cabecera;

	@XmlElementWrapper(name = "DetallesCabecera")
	@XmlElement(name = "DetalleCabecera", namespace = "")
	private List<DetalleCabecera> detallesCabecera;
	
	public ModelOcos() {
		// TODO Auto-generated constructor stub
	}

	public CabeceraOrden getCabecera() {
		return cabecera;
	}

	public void setCabecera(CabeceraOrden cabecera) {
		this.cabecera = cabecera;
	}

	public List<DetalleCabecera> getDetallesCabecera() {
		return detallesCabecera;
	}

	public void setDetallesCabecera(List<DetalleCabecera> detallesCabecera) {
		this.detallesCabecera = detallesCabecera;
	}

	public Boolean isValidEntiti() {
		// TODO Auto-generated method stub
		return true;
	}

}