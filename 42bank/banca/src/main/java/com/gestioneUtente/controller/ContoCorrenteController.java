package com.gestioneUtente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestioneUtente.DTO.ContoCorrenteDTO;
import com.gestioneUtente.service.ContoCorrenteService;

@RestController
public class ContoCorrenteController {

	@Autowired
	ContoCorrenteService srv;
	
	
	@PostMapping("/creaContoCorrente")
	public ContoCorrenteDTO creaContoCorrente(@RequestParam @Validated double saldo, @RequestParam @Validated int idUtenteIntestatario, @RequestParam int idUtenteCointestatario)
	{
		ContoCorrenteDTO cDTO = srv.creaContoCorrenteService(saldo, idUtenteIntestatario, idUtenteCointestatario);
		System.out.println(cDTO);
		return cDTO;
	}
	
	
	@PutMapping("/modificaContoCorrente")
	public ContoCorrenteDTO modificaContoCorrente(@RequestParam @Validated int numeroConto, @RequestParam @Validated double newSaldo, @RequestParam int idUtenteOperatore)
	{
		return srv.modificaContoCorrenteService(numeroConto, newSaldo, idUtenteOperatore);
	}
	
	
	@DeleteMapping("/cancellaContoCorrente")
	public void cancellaContoCorrente(@RequestParam @Validated int numeroConto)
	{
		srv.cancellaContoCorrenteService(numeroConto);
	}
	
}





































