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
import com.example.demo.model.Cliente;
import com.example.demo.services.ClienteService;



@Controller
@RequestMapping("/clientes")
@SessionAttributes("cliente")
public class ClienteController {
	@Autowired
	@Qualifier("cliente")
	private ClienteService clienteService;
	//LISTAR CLIENTES
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Cliente> clientes = clienteService.listar();
		model.addAttribute("clientes",clientes);
		model.addAttribute("titulo","Lista de clientes");
		return "clienteListar";
	}
	
	//FORMULARIO
	@RequestMapping("/form")
	public String formulario (Map<String,Object> model) {
		Cliente cliente =  new Cliente();
		model.put("cliente", cliente);
		model.put("btn", "Registrar nuevo cliente");
		return "clienteForm";
	}
	//BUSCAR CLIENTE
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("cliente",clienteService.buscar(id));
		model.addAttribute("btn","Actualizar Registro");
		return "clienteForm";
	}
	//CREA NUEVO CLIENTE
	@RequestMapping(value="/insertar",method=RequestMethod.POST )
	public String guardar(@Validated Cliente cliente,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("Error","Error al enviar registro");
			cliente = new Cliente();
			model.addAttribute("cliente",cliente);
			model.addAttribute("btn","Crear Cliente");
			return "clienteForm";
		}else {
			clienteService.guardar(cliente);
			return "redirect:/clientes/listar";
		}
	}
	//ELIMINAR REGISTRO
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		clienteService.eliminar(id);
		return "redirect:/clientes/listar";
	}
	
}
