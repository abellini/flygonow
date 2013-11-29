package br.com.flygonow.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class People {

	@Column(name="nome")
	private String nome;

	@Column(name="sobrenome")
	private String sobrenome;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="dt_nascimento")
	private Timestamp dt_nascimento;

	@Column(name="dt_registro")
	private Timestamp dt_registro;
	
	@Column(name="imagem")
	private byte[] imagem;
	
	@Column(name="login")
	private String login;

	@Column(name="senha")
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Timestamp getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Timestamp dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public Timestamp getDt_registro() {
		return dt_registro;
	}

	public void setDt_registro(Timestamp dt_registro) {
		this.dt_registro = dt_registro;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
