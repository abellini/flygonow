package br.com.flygonow.entities;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Tablet")
public class Tablet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="tablet_gen")	
	@SequenceGenerator(name = "tablet_gen", sequenceName = "seq_tablet")
	private Long id;

	private String serverIP;
	
	private int serverPort;
	
	private String ip;
	
	private int port;
	
	private int number;
	
	@OneToMany(mappedBy = "tablet", fetch = LAZY)
	private Set<Pedido> orders;
	
	@ManyToOne
	private Atendente attendant;
	
	@OneToOne
	private Moeda coin;
	
	@OneToMany(mappedBy = "tablets", fetch = LAZY)
	private Set<Advertisement> advertisements;
	
	@OneToOne
	private TabletStatus serviceStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public Integer getNumero() {
		return number;
	}

	public void setNumero(Integer numero) {
		this.number = numero;
	}

	public Set<Pedido> getPedidos() {
		return orders;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.orders = pedidos;
	}

	public Atendente getAtendente() {
		return attendant;
	}

	public void setAtendente(Atendente atendente) {
		this.attendant = atendente;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set<Pedido> getOrders() {
		return orders;
	}

	public void setOrders(Set<Pedido> orders) {
		this.orders = orders;
	}

	public Atendente getAttendant() {
		return attendant;
	}

	public void setAttendant(Atendente attendant) {
		this.attendant = attendant;
	}

	public Moeda getCoin() {
		return coin;
	}

	public void setCoin(Moeda coin) {
		this.coin = coin;
	}

	public Set<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(Set<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public TabletStatus getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(TabletStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	
	
}
