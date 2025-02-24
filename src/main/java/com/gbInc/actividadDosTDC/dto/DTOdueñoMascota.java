package com.gbInc.actividadDosTDC.dto;


public class DTOdueñoMascota {

	private String nombreMascota;
	private String especie;
	private String raza;
	private String nombreDueño;
	private String apellidoDueño;

	public DTOdueñoMascota(String nombreMascota, String especie, String raza, String nombreDueño, String apellidoDueño) {
		this.nombreMascota = nombreMascota;
		this.especie = especie;
		this.raza = raza;
		this.nombreDueño = nombreDueño;
		this.apellidoDueño = apellidoDueño;
	}

	public DTOdueñoMascota() {
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
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

	public String getNombreDueño() {
		return nombreDueño;
	}

	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}

	public String getApellidoDueño() {
		return apellidoDueño;
	}

	public void setApellidoDueño(String apellidoDueño) {
		this.apellidoDueño = apellidoDueño;
	}
	
	
	
}
