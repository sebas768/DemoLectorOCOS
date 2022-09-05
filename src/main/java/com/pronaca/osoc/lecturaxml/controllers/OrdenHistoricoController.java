package com.pronaca.osoc.lecturaxml.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pronaca.osoc.lecturaxml.view.service.IOrdenHistoricoService;

@RestController
public class OrdenHistoricoController {
	
	@Autowired
	private IOrdenHistoricoService iOrdenHistoricoService;

	
	@GetMapping("/ocosH/getCabeceraH")
	public ResponseEntity<?> getAll(@RequestParam("n") String numeroOrden) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iOrdenHistoricoService.findByNumeroOrden(numeroOrden));
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
	@GetMapping("/ocosH/getOrdenH")
	public ResponseEntity<?> getOcos(@RequestParam("c") Long codigo) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iOrdenHistoricoService.findByCodigo(codigo));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
		}
	}

}
