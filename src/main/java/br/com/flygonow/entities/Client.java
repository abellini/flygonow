package br.com.flygonow.entities;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client extends People implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="cliente_gen")	
	@SequenceGenerator(name = "cliente_gen", sequenceName = "seq_cliente")
	private Long id;

	private String email;

	@OneToMany(mappedBy="cliente", fetch = LAZY)
	private Set<Order> pedidos;

	public Client() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Order> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Order> pedidos) {
		this.pedidos = pedidos;
	}

}