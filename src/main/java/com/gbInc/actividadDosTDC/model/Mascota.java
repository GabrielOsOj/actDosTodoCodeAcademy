package com.gbInc.actividadDosTDC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Mascota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idMascota;
	private String nombre;
	private String especie;
	private String raza;
	private String color;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "idDueño")
	@Cascade(CascadeType.ALL)
	private Dueño dueño;

	public Mascota(Long idMascota, String nombre, String especie, String raza, String color, Dueño dueño) {
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.color = color;
		this.dueño = dueño;
	}

	
	public Mascota() {
	}

	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Dueño getDueño() {
		return dueño;
	}

	public void setDueño(Dueño dueño) {
		this.dueño = dueño;
	}
	
	
	
}
