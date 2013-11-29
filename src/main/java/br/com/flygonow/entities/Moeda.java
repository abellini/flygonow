package br.com.flygonow.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Moeda")
public class Moeda implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "moeda_gen")
	@SequenceGenerator(name = "moeda_gen", sequenceName = "seq_moeda")
	private Long id;
	
	private String simbol;
	
	private String name;
	
	private Double vl_conversao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSimbol() {
		return simbol;
	}

	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getVl_conversao() {
		return vl_conversao;
	}

	public void setVl_conversao(Double vl_conversao) {
		this.vl_conversao = vl_conversao;
	}


}
