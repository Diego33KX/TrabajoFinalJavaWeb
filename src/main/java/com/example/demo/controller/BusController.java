package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Bus;
import com.example.demo.services.BusService;

@Controller
@RequestMapping("/buses")
@SessionAttributes("bus")
public class BusController {
	@Autowired
	@Qualifier("bus")
	BusService busService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Bus> buses = busService.listar();
		model.addAttribute("buses",buses);
		model.addAttribute("titulo","Lista de Productos");
		return "busListar";
	}
	
	@RequestMapping("/form")
	public String formulario(Map<String,Object>model) {
		Bus bus = new Bus();
		model.put("bus", bus);
		model.put("btn","Crear bus");
		return "busForm";	
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar(@PathVariable("id") Long id,Model model) {
		model.addAttribute("bus",busService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "busForm";
	}
	
	@RequestMapping(value = "/insertar", method = RequestMethod.POST)
	public String guardar(@Validated Bus bus, BindingResult result,Model model ) {
		if(result.hasErrors()) {
			model.addAttribute("ERROR","ERROR AL ENVIAR REGISTRO");
			bus = new Bus();
			model.addAttribute("bus",bus);
			model.addAttribute("btn","Crear Bus");
			return "busForm";
		}else {
			busService.guardar(bus);
			return "redirect:/buses/listar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		busService.eliminar(id);
		return "redirect:/buses/listar";
	}
	

}
