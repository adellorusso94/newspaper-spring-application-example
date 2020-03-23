package com.project.newspaper.dao;

import java.util.List;

import com.project.newspaper.model.Commento;

public interface CommentoDAO {
	
	public void addCommento(Commento commento);
	public void updateCommento(Commento commento);
	public List<Commento> listCommenti(int id_articolo);
	public Commento getCommentoById(int id_commento);
	public void removeCommento(int id_commento);
	
}
