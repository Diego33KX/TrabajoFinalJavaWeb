package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;
@Entity 
@Table(name="DESTINO")
public class Destino {
        @Id // PRIMARY KEY
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id; // CAMPO SEA AUTONUMERICO
        @NotNull
        @Column(name="ciud_dest")
        private String ciudDest;
        @NotNull
        @Column(name="cost_dest")
        private Integer costDest;
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getCiudDest() {
            return ciudDest;
        }
        public void setCiudDest(String ciudDest) {
            this.ciudDest = ciudDest;
        }
        
        public Integer getCostDest() {
			return costDest;
		}
		public void setCostDest(Integer costDest) {
			this.costDest = costDest;
		}
		@Override
        public String toString() {
            return "Destino [id=" + id + ", ciudDest=" + ciudDest + ", costDest=" + costDest + "]";
        }
}