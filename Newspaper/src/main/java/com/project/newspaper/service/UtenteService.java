package com.project.newspaper.service;

import java.util.List;

import com.project.newspaper.model.Utente;

public interface UtenteService {
	
	public String add(Utente utente);
	public void update(Utente utente);
	public List<Utente> getAll();
	public Utente getOne(int id_utente);
	public void remove(int id_utente);
	public Utente validate(Utente utente);
	
}
