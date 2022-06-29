package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Reserva;
import com.example.demo.repository.IReserva;


@Service("reserva")
public class ReservaService {
    @Autowired
    private IReserva iReserva;
    public void guardar(Reserva reserva) {
        iReserva.save(reserva);
    }
    public List<Reserva> listar(){
        return iReserva.findAll();
    }
    public Reserva buscar(Long id) {
        return iReserva.findById(id);
    }
    public boolean eliminar(Long id) {
        try {
            iReserva.delete(iReserva.findById(id));
            return true;
        }catch(Exception e) {
            return false;
        }
    }

}