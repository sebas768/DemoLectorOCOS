package com.pronaca.osoc.lecturaxml.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pronaca.osoc.lecturaxml.view.service.ICebeceraOrdenService;

@RestController
public class CabeceraOrdenController {
	
	@Autowired
	private ICebeceraOrdenService iCebeceraOrdenService;

	@GetMapping("/cabecera/searchByParameters")
	public ResponseEntity<?> searchByParameters(@RequestParam("fi")String fechaInicio, 
												@RequestParam("fn")String fechaFin,
												@RequestParam("c")String codigo,
												@RequestParam("p")String codProveedor,
												@RequestParam("e")String empresa,
												@RequestParam("s")String estado) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iCebeceraOrdenService.searchByParameters(fechaInicio, fechaFin, codigo, codProveedor, empresa, estado));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
		}
	}
	
	/**
	 * Term
	 * @return
	 */
	@GetMapping("/cabecera/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iCebeceraOrdenService.getAll());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
		}
	}


}
