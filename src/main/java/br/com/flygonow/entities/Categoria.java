package br.com.flygonow.entities;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Categorias")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "categoria_gen", sequenceName = "seq_Categoria")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoria_gen")
	private Integer id;

	@Column(name="cat_nome")
	private String catNome;

	@OneToMany(mappedBy="cat", fetch = LAZY, cascade = ALL)    
	private Set<Produto> produtos;

	public Categoria() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCatNome() {
		return this.catNome;
	}

	public void setCatNome(String catNome) {
		this.catNome = catNome;
	}

	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

}
