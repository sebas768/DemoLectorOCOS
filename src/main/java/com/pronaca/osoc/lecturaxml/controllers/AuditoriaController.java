package com.pronaca.osoc.lecturaxml.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pronaca.osoc.lecturaxml.loaderxml.FactoryLoaderXml;

@RestController
public class AuditoriaController {
	@Autowired
	private FactoryLoaderXml factoryLoaderXml;

	@GetMapping("/cargas/aplica-promocion")
	public ResponseEntity<?> findByColorAndPublicacion() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(factoryLoaderXml.getIAplicaPromocionLoaderView().loadJob());
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
