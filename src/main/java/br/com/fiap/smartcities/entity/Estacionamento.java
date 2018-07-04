package br.com.fiap.smartcities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ESTACIONAMENTO")
public class Estacionamento {
	
	@Id
	@Column(name="cd_estacionamento")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="estacionamento")
	@SequenceGenerator(name="estacionamento",sequenceName="SQ_T_ESTACIONAMENTO",allocationSize=1)
	private int codigo;
	
	@Column(name="nm_estacionamento",nullable=false,length=100)
	private String nome;
	
	@Column(name="ds_endereco",nullable=false)
	private String endereco;
	
	@Column(name="nr_vaga")
	private int vagas;
	
	@Column(name="vl_estacionamento")
	private float preco;

	
	//Getters and setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
