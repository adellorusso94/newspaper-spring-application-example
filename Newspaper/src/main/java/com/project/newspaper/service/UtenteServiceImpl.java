package com.project.newspaper.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.newspaper.dao.UtenteDAO;
import com.project.newspaper.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService{
	
	private UtenteDAO utenteDAO;
	
	public void setUtenteDAO(UtenteDAO utenteDAO) {
		this.utenteDAO = utenteDAO;
	}

	@Override
	@Transactional
	public String add(Utente utente) {
		return this.utenteDAO.addUtente(utente);
	}

	@Override
	@Transactional
	public void update(Utente utente) {
		this.utenteDAO.updateUtente(utente);
	}

	@Override
	@Transactional
	public List<Utente> getAll() {
		return this.utenteDAO.listUtenti();
	}

	@Override
	@Transactional
	public Utente getOne(int id_utente) {
		return this.utenteDAO.getUtenteById(id_utente);
	}

	@Override
	@Transactional
	public void remove(int id_utente) {
		this.utenteDAO.removeUtente(id_utente);
	}
	@Override
	@Transactional
	public Utente validate(Utente utente) {
		return this.utenteDAO.validateDAO(utente);
	}

}
