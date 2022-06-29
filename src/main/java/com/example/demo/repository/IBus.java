package com.example.demo.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Bus;

@Repository
public interface IBus extends JpaRepository<Bus,Serializable> {
	public abstract Bus findById(Long id);
	public abstract Bus findByPlacabus(String placa);

}
