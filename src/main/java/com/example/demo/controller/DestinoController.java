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
import com.example.demo.model.Destino;
import com.example.demo.services.DestinoService;



@Controller
@RequestMapping("/destinos")
@SessionAttributes("destino")
public class DestinoController {
	@Autowired
	@Qualifier("destino")
	DestinoService destinoService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Destino> destinos = destinoService.listar();
		model.addAttribute("destinos",destinos);
		model.addAttribute("titulo","Lista de Destinos");
		return "destinoListar";
	}
	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Destino destino = new Destino();
		model.put("destino",destino);
		model.put("btn", "Crear Destino");
		return "destinoForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("destino",destinoService.buscar(id));
		model.addAttribute("btn","Actualizar Destino");
		return "destinoForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Destino destino,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			destino = new Destino();
			model.addAttribute("destino",destino);
			model.addAttribute("btn","Crear Destino");
			return "destinoForm";
		}else {
		destinoService.guardar(destino);
		return "redirect:/destinos/listar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		destinoService.eliminar(id);
		return "redirect:/destinos/listar";
	}
}