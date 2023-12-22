package com.gestioneUtente.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gestioneUtente.entity.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;

@Repository
@Transactional
public class UtenteRepository {

	@PersistenceContext
	EntityManager em;
	
	
	public Utente getUtenteById(int idUtente)
	{
		Utente p = em.find(Utente.class, idUtente);
		
		return p;
	}
	
	public Utente creaUtenteRepository(Utente utente)
	{
		
		try
		{
			em.persist(utente);
			return utente;
		}
		catch(PersistenceException e)
		{
			if(e.getCause() instanceof ConstraintViolationException)
			{
				throw new RuntimeException("Utente duplicato",e);
			}
			else
			{
				throw e;
			}
		}
	}
	
	
	
	public boolean checkMail(String mail) {

		boolean result = false;
		try
		{
			em.createQuery("SELECT u FROM Utente u WHERE u.mail = :strMail").setParameter("strMail", mail).getSingleResult();
			result = true;

		}
		catch(Exception e)
		{
			result = false;
		}
		return result;
	}
	
	
	public Utente modificaUtenteRepository(Utente utente)
	{
		Utente p = em.find(Utente.class, utente.getIdUtente());
		
		if (p != null && p.getIdUtente() != 0)
			em.merge(utente);
		return (p);
	}
	
	
	public Utente getUtenteRepository(int idUtente)
	{
		
		if (idUtente != 0)
		{
			Query q = em.createQuery("select u from Utente u where u.idUtente = :strIdUtente");
			q.setParameter("strIdUtente", idUtente);
			
			Utente u = (Utente) (q.getSingleResult());
			return (u);
		}
		return null;
	}
	
	
	public Utente getSalientiUtenteRepository(int idUtente)
	{
		
		if (idUtente != 0)
		{
			Query q = em.createQuery("select u from Utente u where u.idUtente = :strIdUtente");
			q.setParameter("strIdUtente", idUtente);
			
			Utente u = (Utente) (q.getSingleResult());
			return (u);
		}
		return null;
	}
	
	
	public List<Utente> reportUtentiRepository()
	{
		Query q = em.createQuery("select u from Utente u");
		
		return (q.getResultList());
	}
	
	
	public void cancellaUtenteRepository(int idUtente) throws Exception
	{
		Utente u = em.find(Utente.class, idUtente);
		
		if (u != null && u.getIdUtente() != 0 && u.getContiCointestati().isEmpty() && u.getContiIntestati().isEmpty())
		{
			em.remove(u);
		}
		else
		{
			throw new Exception("L'utente non si può eliminare");
		}
	}
	
	
}




















