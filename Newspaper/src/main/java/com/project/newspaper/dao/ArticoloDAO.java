package com.project.newspaper.dao;

import java.util.List;

import com.project.newspaper.model.Articolo;

public interface ArticoloDAO {
	
	public void addArticolo(Articolo articolo);
	public void updateArticolo(Articolo articolo);
	public List<Articolo> listArticoli();
	public Articolo getArticoloById(int id_articolo);
	public void removeArticolo(int id_articolo);
	
}
