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

@Entity
@Table(name="Produtos")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="produto_gen")	
	@SequenceGenerator(name = "produto_gen", sequenceName = "seq_produto")

	private Long id;
	
	@Column(name="prod_nome")
	private String prodNome;
	
	@Column(name="descricao")
	@Lob
	private String descricao;

	private Double preco;
	
	private Double desconto;

	private byte[] imagem;
	
	private byte[] video;

	@ManyToOne(fetch=LAZY)
	@JoinColumn(name="cat_id", referencedColumnName = "id")
	private Categoria cat;

	@OneToMany(mappedBy="produto", fetch = LAZY, cascade = ALL)
	private Set<ItensPedido> itens;
	
	@OneToMany(mappedBy="produto", fetch = LAZY, cascade = ALL)
	private Set<Acompanhamento> acompanhamentos;

	public Produto() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
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

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}

	public Set<Acompanhamento> getAcompanhamentos() {
		return acompanhamentos;
	}

	public void setAcompanhamentos(Set<Acompanhamento> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}

	public void setItens(Set<ItensPedido> itens) {
		this.itens = itens;
	}
}
