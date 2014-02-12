package br.com.flygonow.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Acompanhamento")
public class Acompanhamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="acompanhamento_gen")	
	@SequenceGenerator(name = "acompanhamento_gen", sequenceName = "seq_acompanhamento")

	private Long id;
	
	@Column(name="acomp_nome")
	private String acompNome;
	
	@Column(name="descricao")
	@Lob
	private String descricao;

	private Double preco;
	
	private Double valor;
	
	@ManyToOne
	private Product produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcompNome() {
		return acompNome;
	}

	public void setAcompNome(String acompNome) {
		this.acompNome = acompNome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
