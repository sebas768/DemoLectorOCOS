package com.pronaca.osoc.lecturaxml.loaderxml.impl;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.springframework.stereotype.Service;

import com.pronaca.osoc.lecturaxml.loaderxml.ILeerXmlStream;
import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;
import com.pronaca.osoc.lecturaxml.util.Constantes;

@Service
public class LeerXmlStream<T, Pk extends Serializable> implements ILeerXmlStream<T, Pk> {

	@Override
	public List<T> obtenerDatos(RespuestaSFTP respuestaFTP, Class<T> entidad) throws Exception {
		List<T> registros = new ArrayList<>();
		Class<T> entity = entidad;
		XMLInputFactory xmlif = XMLInputFactory.newInstance();
		XMLStreamReader xmlr = xmlif.createXMLStreamReader(new FileInputStream(respuestaFTP.getFileDownload()));
		try {
			JAXBContext ucontext = JAXBContext.newInstance(entity);
			Unmarshaller unmarshaller = ucontext.createUnmarshaller();
			while (xmlr.hasNext()) {
				xmlr.next();
				if (xmlr.getEventType() == XMLStreamConstants.END_ELEMENT
						&& xmlr.getLocalName().equals(Constantes.ETIQUETA_CABECERA)) {
					xmlr.nextTag();
					break;
				}
			}
			xmlr.require(XMLStreamConstants.START_ELEMENT, null, Constantes.ETIQUETA_DETALLES);
			xmlr.nextTag();
			Boolean existeRegistros = Boolean.TRUE;
			while (existeRegistros) {
				try { 
					if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
						JAXBElement<T> pt = unmarshaller.unmarshal(xmlr, entity);
						T retorno = pt.getValue();
						registros.add(retorno);
						if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
							xmlr.next();
						}
					} else {
						existeRegistros = false;
					}
				} catch (JAXBException jaxbe) {
					existeRegistros = false;
					jaxbe.printStackTrace();
				} catch (XMLStreamException xmlste) {
					existeRegistros = false;
					xmlste.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			xmlr.close();
			System.gc();
			
			if (respuestaFTP.getFileDownload().exists()) {
				System.out.println(respuestaFTP.getFileDownload());
				if (respuestaFTP.getFileDownload().delete()) {
					System.out.println("BORRADO");
				} 
			}
		}
		return registros;
	}

	public void cerrarArchivo() throws XMLStreamException {}

}
