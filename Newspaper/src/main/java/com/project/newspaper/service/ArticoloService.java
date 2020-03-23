package com.project.newspaper.service;

import java.util.List;

import com.project.newspaper.model.Articolo;

public interface ArticoloService {
	
	public void add(Articolo articolo);
	public void update(Articolo articolo);
	public List<Articolo> getAll();
	public Articolo getOne(int id_articolo);
	public void remove(int id_articolo);
	
}
