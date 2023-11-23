package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  // sto dicendo a spring che questa classe la deve gestire lui
@Scope("prototype")
public class Persona {

	String nome;
	String cognome;
	Indirizzo indirizzo;
	
	public Persona()
	{
		
	}
}
