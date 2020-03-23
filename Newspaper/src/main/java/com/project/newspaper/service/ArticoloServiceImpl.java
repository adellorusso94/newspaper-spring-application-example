package com.project.newspaper.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.newspaper.dao.ArticoloDAO;
import com.project.newspaper.model.Articolo;

@Service
public class ArticoloServiceImpl implements ArticoloService{
	
	private ArticoloDAO articoloDAO;

	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;
	}

	@Override
	@Transactional
	public void add(Articolo articolo) {
		this.articoloDAO.addArticolo(articolo);
	}

	@Override
	@Transactional
	public void update(Articolo articolo) {
		this.articoloDAO.updateArticolo(articolo);
	}

	@Override
	@Transactional
	public List<Articolo> getAll() {
		return this.articoloDAO.listArticoli();
	}

	@Override
	@Transactional
	public Articolo getOne(int id_articolo) {
		return this.articoloDAO.getArticoloById(id_articolo);
	}

	@Override
	@Transactional
	public void remove(int id_articolo) {
		this.articoloDAO.removeArticolo(id_articolo);
	}

}
