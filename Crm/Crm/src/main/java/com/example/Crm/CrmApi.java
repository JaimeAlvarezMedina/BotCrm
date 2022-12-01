package com.example.Crm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CrmApi {
	
	public CrmApi() {}
	
	List<Oportunidades> lista=new ArrayList<>();
	
	@GetMapping("/clientes")
	public List<Oportunidades> info() {
		Oportunidades opo=new Oportunidades("Jaime",false);
		lista.add(opo);
		return lista;
	}
	
	@PostMapping("/clientes/{nombre}")
	public boolean meter_cliente(@PathVariable String nombre) {
		try {
			lista.add(new Oportunidades(nombre,false));
			return true;
		}catch(Error e) {
			return false;
		}
	}
	
	@PostMapping("/clientes/{id}/{estado}")
	public boolean cambiarEstadoCliente(@PathVariable int id,@PathVariable boolean estado) {
		try {
			for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
				Oportunidades oportunidades = (Oportunidades) iterator.next();
				if(oportunidades.getId()==id) {
					oportunidades.cambiarEstado(estado);
					return true;
				}
			}
			return false;
		}catch(Error e) {
			return false;
		}
	}
	
	@PostMapping("/contacto/{id}/{tel}/{email}")
	public boolean anadirContacto(@PathVariable int id,@PathVariable int tel,@PathVariable String email) {
		try {
			for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
				Oportunidades oportunidades = (Oportunidades) iterator.next();
				if(oportunidades.getId()==id) {
					oportunidades.anadirContacto(email, tel);
					return true;
				}
			}
			return false;
		}catch(Error e) {
			return false;
		}
	}
	
}
