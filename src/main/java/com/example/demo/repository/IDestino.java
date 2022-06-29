package com.example.demo.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Destino;


@Repository
public interface IDestino extends JpaRepository<Destino, Serializable>{
    public abstract Destino findById(Long id);
    public abstract Destino findByCiudDest(String ciudad);
}