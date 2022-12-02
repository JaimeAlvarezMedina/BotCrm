package com.example.Crm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		return lista;
	}
	
	@PostMapping("/clientes/{nombre}/{email}/{tel}")
	public boolean meter_cliente(@PathVariable String nombre,@PathVariable String email,@PathVariable int tel) {
		try {
			Oportunidades nuevo=new Oportunidades(nombre,false,email,tel);
			lista.add(nuevo);
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
	
	@PostMapping("/email/{email}")
	public boolean comprobarEmail(@PathVariable String email) {
		try {
			Pattern pattern = Pattern
	                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	 
	        Matcher mather = pattern.matcher(email);
	 
	        if (mather.find() == true) {
	        	return true;
	        } else {
	        	return false;
	        }
		}catch(Error e) {
			return false;
		}
	}
	
	@PostMapping("/tel/{tel}")
	public boolean comprobarTel(@PathVariable String tel) {
		try {
			String[] array=tel.split("");
			boolean isNumeric = (tel != null && tel.matches("[0-9]+"));
			if(isNumeric && array.length==9) {
				return true;
			}else {
				return false;
			}
		}catch(Error e) {
			return false;
		}
	}
	
}
