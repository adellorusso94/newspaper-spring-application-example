package com.project.newspaper.service;

import java.util.List;

import com.project.newspaper.model.Commento;

public interface CommentoService {

	public void add(Commento commento);
	public void update(Commento commento);
	public List<Commento> getAll(int id_articolo);
	public Commento getOne(int id_commento);
	public void remove(int id_commento);
	
}
