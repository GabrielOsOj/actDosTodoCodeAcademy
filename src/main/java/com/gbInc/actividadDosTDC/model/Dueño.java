package com.gbInc.actividadDosTDC.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Dueño {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idDueño;
	private int DNI;
	private String nombre;
	private String apellido;
	private int celular;

	public Dueño() {
	}

	public Dueño(Long idDueño, int DNI, String nombre, String apellido, int celular) {
		this.idDueño = idDueño;
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
	}

	public Long getIdDueño() {
		return idDueño;
	}

	public void setIdDueño(Long idDueño) {
		this.idDueño = idDueño;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int DNI) {
		this.DNI = DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}
	
	
	
}
