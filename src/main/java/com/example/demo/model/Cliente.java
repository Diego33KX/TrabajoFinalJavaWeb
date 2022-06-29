package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{


    private static final long serialVersionUID = 4626127331904581077L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombres;
    @NotNull
    private String apellidos;
    @NotNull
    private int edad;
    @NotNull
    private String sexo;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + ", sexo="
                + sexo + "]";
    }
}