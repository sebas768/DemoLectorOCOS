package com.pronaca.osoc.lecturaxml.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pronaca.osoc.lecturaxml.model.enums.EstadoEnum;
import com.pronaca.osoc.lecturaxml.view.service.ICabeceraOrdenService;

@RestController
public class CabeceraOrdenController {
	
	@Autowired
	private ICabeceraOrdenService iCebeceraOrdenService;

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @param codigo
	 * @param codProveedor
	 * @param empresa
	 * @param estado
	 * @return
	 */
	@GetMapping("/ocos/searchByParameters")
	public ResponseEntity<?> searchByParameters(@RequestParam("fi")String fechaInicio, 
												@RequestParam("fn")String fechaFin,
												@RequestParam("c")String codigo,
												@RequestParam("p")String codProveedor,
												@RequestParam("r")String rucProveedor,
												@RequestParam("e")String codEmpresa, 
												@RequestParam("s")EstadoEnum estado) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iCebeceraOrdenService.searchByParameters(fechaInicio, fechaFin, codigo, codProveedor, rucProveedor, codEmpresa, estado));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/ocos/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iCebeceraOrdenService.getAll());
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
	@GetMapping("/ocos/updateStatus")
	public ResponseEntity<?> updateStatus(@RequestParam("n") String numeroOrden,
										  @RequestParam("s") EstadoEnum estado) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iCebeceraOrdenService.updateStatus(numeroOrden, estado));
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
	@GetMapping("/ocos/getOcos")
	public ResponseEntity<?> getOcos(@RequestParam("n") String numeroOrden) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iCebeceraOrdenService.getByNumeroOrden(numeroOrden));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
		}
	}

	
	//IMPLEMENT ...
	@PostMapping("/ocos/getOcosTest/")
	public ResponseEntity<?> getOcosP(@RequestBody String numeroOrden) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(iCebeceraOrdenService.getByNumeroOrden(numeroOrden));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
		}
	}

}
