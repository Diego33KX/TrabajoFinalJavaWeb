package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bus;
import com.example.demo.repository.IBus;


@Service("bus")
public class BusService {
	@Autowired
	IBus iBus;
	public void guardar(Bus bus) {
		iBus.save(bus);
	}
	
	public Bus buscar(Long id) {
		return iBus.findById(id);	
	}
	
	public List<Bus> listar(){
		return iBus.findAll();
	}
	
	public boolean eliminar(Long id) {
		try {
			iBus.delete(iBus.findById(id));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public  Bus buscarPlaca(String placa) {
		return iBus.findByPlacabus(placa);
	}
}
