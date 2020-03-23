package com.project.newspaper.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="utente")
public class Utente {
	
	@Id
	@Column(name="id_utente")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_utente;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private int giornalista;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "autore", cascade = CascadeType.ALL)
	private Set<Articolo> articoli;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "autore", cascade = CascadeType.ALL)
	private Set<Commento> commenti;

	public Utente() {
		super();
	}
	
	public Utente(String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	public Utente(int id_utente, String username, String password, String nome, String cognome, int giornalista,
			Set<Articolo> articoli, Set<Commento> commenti) {
		super();
		this.id_utente = id_utente;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.giornalista = giornalista;
		this.articoli = articoli;
		this.commenti = commenti;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	public int getGiornalista() {
		return giornalista;
	}

	public void setGiornalista(int giornalista) {
		this.giornalista = giornalista;
	}

	public Set<Commento> getCommenti() {
		return commenti;
	}

	public void setCommenti(Set<Commento> commenti) {
		this.commenti = commenti;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}
	
}