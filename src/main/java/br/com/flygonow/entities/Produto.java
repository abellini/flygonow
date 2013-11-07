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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Produtos")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)    
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "produto_gen", sequenceName = "seq_Produto")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto_gen")
	private Integer id;

	@Column(name="descricao")
	@Lob
	private String descricao;

	@Column(name="prod_nome")
	private String prodNome;

	private Double preco;
	
	private Double desconto;

	private String imagem;

	@ManyToOne(fetch=LAZY)
	@JoinColumn(name="cat_id", referencedColumnName = "id")
	private Categoria cat;

	@OneToMany(mappedBy="produto", fetch = LAZY, cascade = ALL)
	private Set<ItensPedido> itens;
	

	public Produto() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescGd() {
		return this.descricao;
	}

	public void setDescGd(String descGd) {
		this.descricao = descGd;
	}

	public String getProdNome() {
		return this.prodNome;
	}

	public void setProdNome(String prodNome) {
		this.prodNome = prodNome;
	}

	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getDesconto() {
		return desconto;
	}	
	
	public String getImagem() {
		return this.imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Categoria getCat() {
		return this.cat;
	}

	public void setCat(Categoria cat) {
		this.cat = cat;
	}

	public Set<ItensPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItensPedido> itens) {
		this.itens = itens;
	}





}
