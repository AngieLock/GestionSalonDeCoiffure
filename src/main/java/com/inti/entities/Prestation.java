package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRESTATIONS", schema="gestion_coiffure_db")
public class Prestation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestation;
	private String nomPrestation;
	@ManyToOne
	@JoinColumn(name="id_resa")
	private Reservation reservation;
	public Prestation() {
	}
	public Prestation(String nomPrestation, Reservation reservation) {
		this.nomPrestation = nomPrestation;
		this.reservation = reservation;
	}
	public Long getIdPrestation() {
		return idPrestation;
	}
	public void setIdPrestation(Long idPrestation) {
		this.idPrestation = idPrestation;
	}
	public String getNomPrestation() {
		return nomPrestation;
	}
	public void setNomPrestation(String nomPrestation) {
		this.nomPrestation = nomPrestation;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	@Override
	public String toString() {
		return "Prestation [idPrestation=" + idPrestation + ", nomPrestation=" + nomPrestation + ", reservation="
				+ reservation + "]";
	}
	
	
}
