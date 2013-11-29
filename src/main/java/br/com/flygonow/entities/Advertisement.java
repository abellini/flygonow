package br.com.flygonow.entities;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Advertisement")
public class Advertisement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="advertisement_gen")	
	@SequenceGenerator(name = "advertisement_gen", sequenceName = "seq_advertisement")
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "advertisements", fetch = LAZY)
	private List<Tablet> tablets;
	
	private Timestamp inicialDate;
	
	private Timestamp finalDate;
	
	private boolean isActive;
	
	private byte[] photo;
	
	private byte[] video;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tablet> getTablets() {
		return tablets;
	}

	public void setTablets(List<Tablet> tablets) {
		this.tablets = tablets;
	}

	public Timestamp getInicialDate() {
		return inicialDate;
	}

	public void setInicialDate(Timestamp inicialDate) {
		this.inicialDate = inicialDate;
	}

	public Timestamp getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Timestamp finalDate) {
		this.finalDate = finalDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}
	
}