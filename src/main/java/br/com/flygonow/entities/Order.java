package br.com.flygonow.entities;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Pedidos")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="pedido_gen")	
	@SequenceGenerator(name = "pedido_gen", sequenceName = "seq_pedido")
	private Long id;

	@Column(name="cc_numero")
	private String ccNumero;

	@Column(name="cc_nome")
	private String ccNome;

	@Column(name="cc_tipo")
	private int ccTipo;

	@Column(name="data_ped")
	private Timestamp dataPed;

	@ManyToOne
	private Client cliente;
	
	@ManyToOne
	private Atendente atendente;
	
	@ManyToOne
	private Tablet tablet;

	@OneToMany(mappedBy="pedido", fetch = LAZY)
	private List<ItensPedido> itens =  new ArrayList<ItensPedido>();

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Order() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCcNumero() {
		return this.ccNumero;
	}

	public void setCcNumero(String ccNumero) {
		this.ccNumero = ccNumero;
	}

	public String getCcNome() {
		return this.ccNome;
	}

	public void setCcNome(String ccNome) {
		this.ccNome = ccNome;
	}

	public int getCcTipo() {
		return this.ccTipo;
	}

	public void setCcTipo(int ccTipo) {
		this.ccTipo = ccTipo;
	}

	public Timestamp getDataPed() {
		return this.dataPed;
	}

	public void setDataPed(Timestamp dataPed) {
		this.dataPed = dataPed;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public List<ItensPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItensPedido> itens) {
		this.itens = itens;
	}
	
	public Tablet getTablet() {
		return tablet;
	}

	public void setTablet(Tablet tablet) {
		this.tablet = tablet;
	}

}
