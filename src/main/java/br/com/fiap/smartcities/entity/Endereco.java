package br.com.fiap.smartcities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ENDERECO")
public class Endereco {

	@Id
	@Column(name="cd_endereco")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="endereco")
	@SequenceGenerator(name="endereco",sequenceName="SQ_T_ENDERECO",allocationSize=1)
	private int id;
	
	@Column(name="ds_logradouro", nullable=false, length=100)
	private String logradouro;
	
	@Column(name="ds_numero", nullable=false)
	private int numero;
	
	@Column(name="ds_cep", nullable=false)
	private int cep;
	
	@Column(name="ds_bairro", nullable=false, length=60)
	private String bairro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
}
