package com.project.newspaper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.project.newspaper.model.Articolo;

@Repository
public class ArticoloDAOImpl implements ArticoloDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addArticolo(Articolo articolo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(articolo);
		System.out.println("Articolo salvato con successo.");
	}

	@Override
	public void updateArticolo(Articolo articolo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(articolo);
		System.out.println("Articolo aggiornato con successo.");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> listArticoli() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Articolo> articoliList = session.createQuery("from Articolo").list();
		System.out.println("Lista articoli caricata con successo.");
		return articoliList;
	}

	@Override
	public Articolo getArticoloById(int id_articolo) {
		Session session = this.sessionFactory.getCurrentSession();
		Articolo articolo = (Articolo) session.load(Articolo.class, id_articolo);
		if(articolo != null) {
			System.out.println("Articolo caricato con successo.");
		} else {
			System.out.println("Articolo non presente nel database!");
		}
		return articolo;
	}

	@Override
	public void removeArticolo(int id_articolo) {
		Session session = this.sessionFactory.getCurrentSession();
		Articolo articolo = (Articolo) session.load(Articolo.class, id_articolo);
		if(articolo != null) {
			session.delete(articolo);
			System.out.println("Articolo eliminato con successo.");
		} else {
			System.out.println("Articolo non presente nel database!");
		}
	}

}
