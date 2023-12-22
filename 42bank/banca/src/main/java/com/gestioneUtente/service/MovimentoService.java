package com.gestioneUtente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioneUtente.repository.MovimentoRepository;

@Service
public class MovimentoService {

	@Autowired
	MovimentoRepository repo;
	
}
