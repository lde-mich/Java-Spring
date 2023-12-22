package com.gestioneUtente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gestioneUtente.service.MovimentoService;

@RestController
public class MovimentoController {

	@Autowired
	MovimentoService srv;
}
