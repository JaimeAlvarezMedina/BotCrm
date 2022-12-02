package com.example.Crm;


import java.util.List;


public class Oportunidades {

	private List<Contacto> contactos;
	private String nombre;
	private int id;
	private String email;

	private int tel;
	private boolean cliente;
	private static int contador=1;
	
	public String getEmail() {return email;}
	
	public int getTel() {return tel;}
	
	public String getNombre() {return this.nombre;}

	public int getId() {return id;}
	
	public boolean getCliente() {return cliente;}

	public Oportunidades() {
		super();
	}

	public Oportunidades(String nombre,boolean cliente,String email,int tel) {
		id=Oportunidades.contador++;
		this.nombre=nombre;
		this.cliente=cliente;
		this.email=email;
		this.tel=tel;
	}
	
	public void cambiarEstado(boolean estado) {
		this.cliente=estado;
	}
	
	
	
	
}
