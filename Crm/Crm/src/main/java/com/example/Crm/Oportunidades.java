package com.example.Crm;


import java.util.List;


public class Oportunidades {

	private List<Contacto> contactos;
	private String nombre;
	private int id;
	private boolean cliente;
	private static int contador=1;
	
	public String getNombre() {return this.nombre;}

	public int getId() {return id;}
	
	public boolean getCliente() {return cliente;}

//	public List<Contacto> getContactos() {return contactos;}
	
	public void setContactos(List<Contacto> contactos) {this.contactos = contactos;}

	public Oportunidades() {
		super();
	}

	public Oportunidades(String nombre,boolean cliente) {
		id=Oportunidades.contador++;
		this.nombre=nombre;
		this.cliente=cliente;
	}
	
	public void anadirContacto(String email,int tel) {
		contactos.add(new Contacto(tel,email));
	}
	
	public void cambiarEstado(boolean estado) {
		this.cliente=estado;
	}
	
	
	
	
}
