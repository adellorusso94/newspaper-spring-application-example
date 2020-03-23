package com.project.newspaper.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="commento")
public class Commento {
	
	@Id
	@Column(name="id_commento")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_commento;
	private String testo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="utente", referencedColumnName="id_utente")
	private Utente autore;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="articolo", referencedColumnName="id_articolo")
	private Articolo articolo;

	public Commento() {

	}
	
	public Commento(int id_commento, String testo, Date data, Utente autore, Articolo articolo) {
		super();
		this.id_commento = id_commento;
		this.testo = testo;
		this.data = data;
		this.autore = autore;
		this.articolo = articolo;
	}
	
	public int getId_commento() {
		return id_commento;
	}

	public void setId_commento(int id_commento) {
		this.id_commento = id_commento;
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

	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	public Utente getAutore() {
		return autore;
	}

	public void setAutore(Utente autore) {
		this.autore = autore;
	}
	
}