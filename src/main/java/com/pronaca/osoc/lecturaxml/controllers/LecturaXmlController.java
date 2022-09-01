package com.pronaca.osoc.lecturaxml.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pronaca.osoc.lecturaxml.loaderxml.ILoaderXml;
import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.view.service.ICabeceraOrdenService;

@RestController
public class LecturaXmlController {
	
	@Autowired
	private ILoaderXml iLoaderXml;
	
	@Autowired
	private ICabeceraOrdenService iCabeceraOrdenService;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/lecturaXml/load")
	public ResponseEntity<?> initLecturaXml() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iLoaderXml.loadXml());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param numeroOrden
	 * @param estado
	 * @return
	 */
	@GetMapping("/lecturaXml/updateStatus")
	public ResponseEntity<?> updateStatus(@RequestParam("n") String numeroOrden,
										  @RequestParam("s") EstadoEnum estado) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iCabeceraOrdenService.updateStatus(numeroOrden, estado));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param numeroOrden
	 * @return
	 */
	@GetMapping("/lecturaXml/getOcos")
	public ResponseEntity<?> getOcos(@RequestParam("n") String numeroOrden) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iCabeceraOrdenService.getByNumeroOrden(numeroOrden));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
		}
	}

	
	/**
	@PostMapping("/auditoria/guardarEntrega")
	public ResponseEntity<?> guardarEntrega(@RequestBody Auditoria p) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(auditoriaService.process(""));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
		}
	}**/

}
