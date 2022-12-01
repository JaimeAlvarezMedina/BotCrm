package com.example.Crm;

public class Contacto {
	
	private int telefono;
	private String email;
	
	public int getTelefono() {
		return telefono;
	}
	
	public String email() {
		return email;
	}
	
	public Contacto(int tel, String email) {
		this.telefono=tel;
		this.email=email;
	}

}
