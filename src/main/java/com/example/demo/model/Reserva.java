package com.example.demo.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;
@Entity 
@Table(name="RESERVA")
public class Reserva {
	
		@Id // PRIMARY KEY
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id; // CAMPO SEA AUTONUMERICO
		@NotNull
		private String lugar_partida;
		@NotNull
		private String lugar_destino;
		@NotNull
		private String dia_partida;
		@NotNull
		private String dia_llegada;
		@NotNull
		private Integer boleto;
		@NotNull
		@Column(name = "nombres")
		private String nombre_cliente;
		@NotNull
		private String placabus;
		
		private Double total;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getLugar_partida() {
			return lugar_partida;
		}
		public void setLugar_partida(String lugar_partida) {
			this.lugar_partida = lugar_partida;
		}
		public String getLugar_destino() {
			return lugar_destino;
		}
		public void setLugar_destino(String lugar_destino) {
			this.lugar_destino = lugar_destino;
		}
		public String getDia_partida() {
			return dia_partida;
		}
		public void setDia_partida(String dia_partida) {
			this.dia_partida = dia_partida;
		}
		public String getDia_llegada() {
			return dia_llegada;
		}
		public void setDia_llegada(String dia_llegada) {
			this.dia_llegada = dia_llegada;
		}
		
		public String getNombre_cliente() {
			return nombre_cliente;
		}
		public void setNombre_cliente(String nombre_cliente) {
			this.nombre_cliente = nombre_cliente;
		}
		public String getPlacabus() {
			return placabus;
		}
		public void setPlacabus(String placabus) {
			this.placabus = placabus;
		}
		
		public Integer getBoleto() {
			return boleto;
		}
		public void setBoleto(Integer boleto) {
			this.boleto = boleto;
		}
		public Double getTotal() {
			return total;
		}
		public void setTotal(Double total) {
			this.total = total;
		}
		@Override
		public String toString() {
			return "Reserva [id=" + id + ", lugar_partida=" + lugar_partida + ", lugar_destino=" + lugar_destino
					+ ", dia_partida=" + dia_partida + ", dia_llegada=" + dia_llegada + ", boleto=" + boleto
					+ ", nombre_cliente=" + nombre_cliente + ", placabus=" + placabus + ", total=" + total + "]";
		}
		
}