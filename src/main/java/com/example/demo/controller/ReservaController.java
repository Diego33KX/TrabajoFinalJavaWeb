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
import com.example.demo.model.Destino;
import com.example.demo.model.Reserva;
import com.example.demo.services.BusService;
import com.example.demo.services.ClienteService;
import com.example.demo.services.DestinoService;
import com.example.demo.services.ReservaService;



@Controller
@RequestMapping("/reservas")
@SessionAttributes("reserva")
public class ReservaController {
	@Autowired
	@Qualifier("reserva")
	ReservaService reservaService;
	
	@Autowired
	@Qualifier("cliente")
	ClienteService clienteService;
	
	@Autowired
	@Qualifier("bus")
	BusService busService;
	
	@Autowired
	@Qualifier("destino")
	DestinoService destinoService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Reserva> reserva = reservaService.listar();
		model.addAttribute("reservas",reserva);
		model.addAttribute("titulo","Lista de Reservas");
		return "reservaListar";
	}
	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Reserva reserva = new Reserva();
		model.put("reserva",reserva);
		model.put("clientes", clienteService.listar());
		model.put("bus", busService.listar());
		model.put("destinos", destinoService.listar());
		model.put("btn", "Crear Reserva");
		return "reservaForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("reserva",reservaService.buscar(id));
		model.addAttribute("clientes", clienteService.listar());
		model.addAttribute("bus", busService.listar());
		model.addAttribute("destinos", destinoService.listar());
		model.addAttribute("btn","Actualizar Reserva");
		return "reservaForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Reserva reserva,Model model) {
		try {
			String id = reserva.getPlacabus();
			Bus bus = busService.buscarPlaca(id);
			String dest = reserva.getLugar_destino();
			Destino des =destinoService.buscarCiudad(dest);
			
			if(reserva.getBoleto() <= bus.getCap_bus()) {
				int diferencia = bus.getCap_bus()-reserva.getBoleto();
				bus.setCap_bus(diferencia);
				double total = des.getCostDest()*reserva.getBoleto();
				reserva.setTotal(total);
				busService.guardar(bus);
				reservaService.guardar(reserva);
				System.out.println(reserva.getBoleto());
	
			}else {
				model.addAttribute("ERROR","NO HAY PASAJES DISPONIBLES");
				reserva = new Reserva();
				model.addAttribute("reserva",reserva);
				model.addAttribute("bus",busService.listar());
				model.addAttribute("clientes",clienteService.listar());
				model.addAttribute("destinos",destinoService.listar());
				model.addAttribute("btn","Registro de Reserva");
				return "reservaForm";
			}
		}catch(Exception e) {
			
		}
		return "redirect:/reservas/listar";
		
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		reservaService.eliminar(id);
		return "redirect:/reservas/listar";
	}
}
