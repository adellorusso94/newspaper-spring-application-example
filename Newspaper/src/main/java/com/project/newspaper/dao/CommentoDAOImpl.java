package com.project.newspaper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.project.newspaper.model.Commento;

@Repository
public class CommentoDAOImpl implements CommentoDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCommento(Commento commento) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(commento);
		System.out.println("Commento salvato con successo.");
	}

	@Override
	public void updateCommento(Commento commento) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(commento);
		System.out.println("Commento aggiornato con successo.");
	}
	
	@Override
	public List<Commento> listCommenti(int art) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "select C from Commento C where C.articolo = :arti";
		List<Commento> list = session.createQuery(hql,Commento.class)
		.setParameter("arti", art)
		.list();
		System.out.println("Lista commenti dell'articolo caricata con successo.");
		return list;
	}

	@Override
	public Commento getCommentoById(int id_commento) {
		Session session = this.sessionFactory.getCurrentSession();
		Commento commento = (Commento) session.load(Commento.class, id_commento);
		if(commento != null) {
			System.out.println("Commento caricato con successo.");
		} else {
			System.out.println("Commento non presente nel database!");
		}
		return commento;
	}

	@Override
	public void removeCommento(int id_commento) {
		Session session = this.sessionFactory.getCurrentSession();
		Commento commento = (Commento) session.load(Commento.class, id_commento);
		if(commento != null) {
			session.delete(commento);
			System.out.println("Commento eliminato con successo.");
		} else {
			System.out.println("Commento non presente nel database!");
		}
	}

}
