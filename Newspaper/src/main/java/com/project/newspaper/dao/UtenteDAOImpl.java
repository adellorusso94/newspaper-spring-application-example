package com.project.newspaper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.project.newspaper.model.Utente;

@Repository
public class UtenteDAOImpl implements UtenteDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public String addUtente(Utente utente) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Utente> list = session.createQuery("from Utente u where u.username=:us", Utente.class)
				.setParameter("us", utente.getUsername()).list();
		if (!list.isEmpty()) {
			String res = "Errore";
			return res;
		} else {
			session.persist(utente);
			String res = "Ok";
			return res;
		}
	}

	@Override
	public void updateUtente(Utente utente) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(utente);
		System.out.println("Utente aggiornato con successo.");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> listUtenti() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Utente> utentiList = session.createQuery("from Utente").list();
		System.out.println("Lista utenti caricata con successo.");
		return utentiList;
	}

	@Override
	public Utente getUtenteById(int id_utente) {
		Session session = this.sessionFactory.getCurrentSession();
		Utente utente = (Utente) session.load(Utente.class, id_utente);
		if (utente != null) {
			System.out.println("Utente caricato con successo.");
		} else {
			System.out.println("Utente non presente nel database!");
		}
		return utente;
	}

	@Override
	public void removeUtente(int id_utente) {
		Session session = this.sessionFactory.getCurrentSession();
		Utente utente = (Utente) session.load(Utente.class, id_utente);
		if (utente != null) {
			session.delete(utente);
			System.out.println("Utente eliminato con successo.");
		} else {
			System.out.println("Utente non presente nel database!");
		}
	}

	@Override
	public Utente validateDAO(Utente utente) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Utente> list = session
				.createQuery("select u from Utente u where u.username=:us and u.password =:pas", Utente.class)
				.setParameter("us", utente.getUsername()).setParameter("pas", utente.getPassword()).list();
		return (list.isEmpty() ? null : list.get(0));
	}

}
