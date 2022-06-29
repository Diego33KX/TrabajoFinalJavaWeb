package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ICliente;

@Service("cliente")
public class ClienteService {
    @Autowired 
    private ICliente iCliente;

    public void guardar(Cliente cliente) {
        iCliente.save(cliente);
    }

    public List<Cliente> listar(){
        return iCliente.findAll();
    }

    public Cliente buscar(Long id) {
        return iCliente.findById(id);
    }

    public boolean eliminar(Long id) {
        try {
            iCliente.delete(iCliente.findById(id));
            return true;
        }catch(Exception e) {
            return false;
        }
    }

}