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
@Table(name = "Atendente")
public class Atendente extends People implements Serializable{

	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "atendente_gen")
	@SequenceGenerator(name = "atendente_gen", sequenceName = "seq_atendente")
	private Long id;
	
	@OneToMany(mappedBy = "atendente", fetch = LAZY)
	private Set<Order> pedidos;
	
	@OneToMany(mappedBy = "atendente", fetch = LAZY)
	private Set<Tablet> tablets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<Order> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Order> pedidos) {
		this.pedidos = pedidos;
	}
	
	public Set<Tablet> getTablets() {
		return tablets;
	}

	public void setTablets(Set<Tablet> tablets) {
		this.tablets = tablets;
	}
	
}
