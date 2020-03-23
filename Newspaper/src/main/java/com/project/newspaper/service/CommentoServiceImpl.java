package com.project.newspaper.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.newspaper.dao.CommentoDAO;
import com.project.newspaper.model.Commento;

@Service
public class CommentoServiceImpl implements CommentoService{
	
	private CommentoDAO commentoDAO;
	
	public void setCommentoDAO(CommentoDAO commentoDAO) {
		this.commentoDAO = commentoDAO;
	}

	@Override
	@Transactional
	public void add(Commento commento) {
		this.commentoDAO.addCommento(commento);
	}

	@Override
	@Transactional
	public void update(Commento commento) {
		this.commentoDAO.updateCommento(commento);
	}
	
	@Override
	@Transactional
	public List<Commento> getAll(int id_articolo) {
		return this.commentoDAO.listCommenti(id_articolo);
	}

	@Override
	@Transactional
	public Commento getOne(int id_commento) {
		return this.commentoDAO.getCommentoById(id_commento);
	}

	@Override
	@Transactional
	public void remove(int id_commento) {
		this.commentoDAO.removeCommento(id_commento);
	}

}
