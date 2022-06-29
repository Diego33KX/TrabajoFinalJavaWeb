package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Destino;
import com.example.demo.repository.IDestino;


@Service("destino")
public class DestinoService {
    @Autowired
    private IDestino iDestino;
    public void guardar(Destino destino) {
        iDestino.save(destino);
    }
    public List<Destino> listar(){
        return iDestino.findAll();
    }
    public Destino buscar(Long id) {
        return iDestino.findById(id);
    }
    public boolean eliminar(Long id) {
        try {
            iDestino.delete(iDestino.findById(id));
            return true;
        }catch(Exception e) {
            return false;
        }
    }
    public Destino buscarCiudad(String ciudad) {
    	return iDestino.findByCiudDest(ciudad);
    }

}