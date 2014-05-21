package br.com.sara.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "membro")
public class Membro implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(sequenceName = "seq_objref_membro", initialValue = 1, allocationSize = 1, name = "objref_membro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objref_membro")
	private Integer objref;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String cpf;
	
	@Column
	private String discipulador;
	
	@Column
	private String endereco;
	
	@Column
	private String telefone;
	
	@Column
	private Date dataNascimento;

	public Membro(Integer objref, String nome, String email,
			String discipulador, String endereco, String telefone,
			Date dataNascimento) {
		super();
		this.objref = objref;
		this.nome = nome;
		this.email = email;
		this.discipulador = discipulador;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public Membro() {
	}

	public Integer getObjref() {
		return objref;
	}

	public void setObjref(Integer objref) {
		this.objref = objref;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiscipulador() {
		return discipulador;
	}

	public void setDiscipulador(String discipulador) {
		this.discipulador = discipulador;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
