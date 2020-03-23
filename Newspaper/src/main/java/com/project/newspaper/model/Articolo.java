package com.project.newspaper.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="articolo")
public class Articolo {
	
	@Id
	@Column(name="id_articolo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_articolo;
	private String titolo;
	private String testo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;
	
	@OneToMany(mappedBy = "articolo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Commento> commenti;
	
	@ManyToOne
	@JoinColumn(name="autore", referencedColumnName="id_utente")
	private Utente autore;
	
	public Articolo() {
		super();
	}
	
	public Articolo(int id_articolo, String titolo, String testo, Date data, Utente autore, Set<Commento> commenti) {
		super();
		this.id_articolo = id_articolo;
		this.titolo = titolo;
		this.testo = testo;
		this.data = data;
		this.autore = autore;
		this.commenti = commenti;
	}

	public Set<Commento> getCommenti() {
		return commenti;
	}

	public void setCommenti(Set<Commento> commenti) {
		this.commenti = commenti;
	}

	public int getId_articolo() {
		return id_articolo;
	}

	public void setId_articolo(int id_articolo) {
		this.id_articolo = id_articolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Utente getAutore() {
		return autore;
	}

	public void setAutore(Utente utente) {
		this.autore = utente;
	}
	
}