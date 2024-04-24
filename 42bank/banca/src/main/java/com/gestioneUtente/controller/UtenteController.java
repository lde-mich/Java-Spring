package com.gestioneUtente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestioneUtente.DTO.UtenteDTO;
import com.gestioneUtente.service.UtenteService;

@RestController
@CrossOrigin
public class UtenteController {

	@Autowired
	UtenteService srv;
	
	
	@PostMapping("/creaUtente")
	public UtenteDTO creaUtente(@RequestBody @Validated UtenteDTO utenteDTO)
	{
		return srv.creaUtenteService(utenteDTO);
	}
	
	
	@PutMapping("/modificaUtente")
	public UtenteDTO modificaUtente(@RequestBody @Validated UtenteDTO utenteDTO) throws Exception
	{
		return srv.modificaUtenteService(utenteDTO);
	}
	
	
	@GetMapping("/getUtente")
	public UtenteDTO getUtente(@RequestParam @Validated int idUtente) throws Exception
	{
		return srv.getUtenteService(idUtente);
	}
	
	
	@GetMapping("/getSalientiUtente")
	public UtenteDTO getSalientiUtente(@RequestParam @Validated int idUtente) throws Exception
	{
		return srv.getSalientiUtenteService(idUtente);
	}
	
	
	@GetMapping("/reportUtenti")
	public List<UtenteDTO> reportUtenti()
	{
		return srv.reportUtentiService();
	}
	
	
	@DeleteMapping("/cancellaUtente")
	public void cancellaUtente(@RequestParam @Validated int idUtente) throws Exception
	{
		srv.cancellaUtenteService(idUtente);
	}
	
}




















