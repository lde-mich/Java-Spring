package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller("/")
public class Corso2Application {
	
	@Autowired
	Persona p;
	
	@Autowired
	Persona p2;

	public static void main(String[] args) {
		SpringApplication.run(Corso2Application.class, args);
		
	
	}

	
	// http://localhost:8081/test
	
	
	// 1 - PATH VARIABLE
	
	@RequestMapping("/test/{nome}/{nome1}")
	public void test(@PathVariable String nome, @PathVariable String nome1)
	{
		p.nome = nome;
		p2.nome = nome1;
		
//		p.cognome = "Totti";
//		p2.cognome = "Cassano";
		
//		p.indirizzo = new Indirizzo();
//		p.indirizzo.via = "Via dai laziali";
//		p.indirizzo.civico = "10";
		
		System.out.println(p.nome); // Stamperà in console il nome passato come argomento nella URL
		System.out.println(p2.nome); // Stamperà in console il nome passato come argomento nella URL
		
	}
	
	// 2 - REQUEST PARAM
	
	@RequestMapping("/testParam")
	public void testParam(@RequestParam String nome, @RequestParam String nome1)
	{
		p.nome = nome;
		p2.nome = nome1;
		
//		p.cognome = "Totti";
//		p2.cognome = "Cassano";
		
//		p.indirizzo = new Indirizzo();
//		p.indirizzo.via = "Via dai laziali";
//		p.indirizzo.civico = "10";
		
		System.out.println(p.nome); // Stamperà in console il nome passato come argomento nella URL
		System.out.println(p2.nome); // Stamperà in console il nome passato come argomento nella URL
		
	}
	
	
	
	
	
	
	
}
