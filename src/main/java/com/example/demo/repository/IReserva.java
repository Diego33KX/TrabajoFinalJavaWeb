package com.example.demo.repository;


import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reserva;


@Repository
public interface IReserva extends JpaRepository<Reserva, Serializable>{
    public abstract Reserva findById(Long id);
}