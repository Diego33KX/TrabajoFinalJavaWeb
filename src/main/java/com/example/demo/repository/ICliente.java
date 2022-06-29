package com.example.demo.repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Cliente;


@Repository
public interface ICliente extends JpaRepository<Cliente, Serializable>{
    public Cliente findById(Long id);
}