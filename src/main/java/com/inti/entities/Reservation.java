package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATIONS", schema = "gestion_coiffure_db")
public class Reservation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservation;
	private Date dateResa;
	@OneToMany(mappedBy = "reservation")
	private List<Salon> salons = new ArrayList<>();
	@OneToMany(mappedBy = "reservation")
	private List<Prestation> prestations = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;

	public Reservation() {
	}

	public Reservation(Long idReservation, Date dateResa, List<Salon> salons) {
		super();
		this.idReservation = idReservation;
		this.dateResa = dateResa;
		this.salons = salons;
	}

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDateResa() {
		return dateResa;
	}

	public void setDateResa(Date dateResa) {
		this.dateResa = dateResa;
	}

	public List<Salon> getSalons() {
		return salons;
	}

	public void setSalons(List<Salon> salons) {
		this.salons = salons;
	}

	public List<Prestation> getPrestations() {
		return prestations;
	}

	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", dateResa=" + dateResa + ", salons=" + salons + "]";
	}

}
