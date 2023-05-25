package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.inti.model.Adresse;

@Entity
@Table(name="SALONS", schema="gestion_coiffure_db")
public class Salon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSalon;
	private String nomSalon;
	@Embedded
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name="id_reservation")
	private Reservation reservation;
	public Salon() {
	}
	public Salon(String nomSalon, Adresse adresse, Reservation reservation) {
		this.nomSalon = nomSalon;
		this.adresse = adresse;
		this.reservation = reservation;
	}
	public Long getIdSalon() {
		return idSalon;
	}
	public void setIdSalon(Long idSalon) {
		this.idSalon = idSalon;
	}
	public String getNomSalon() {
		return nomSalon;
	}
	public void setNomSalon(String nomSalon) {
		this.nomSalon = nomSalon;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	@Override
	public String toString() {
		return "Salon [idSalon=" + idSalon + ", nomSalon=" + nomSalon + ", adresse=" + adresse + "]";
	}
	
	
}
