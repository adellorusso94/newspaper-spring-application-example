package com.project.newspaper.dao;

import java.util.List;

import com.project.newspaper.model.Utente;

public interface UtenteDAO {
	
	public String addUtente(Utente utente);
	public void updateUtente(Utente utente);
	public List<Utente> listUtenti();
	public Utente getUtenteById(int id_utente);
	public void removeUtente(int id_utente);
	public Utente validateDAO(Utente utente);
	
}
