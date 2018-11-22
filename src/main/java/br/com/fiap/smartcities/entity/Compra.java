package br.com.fiap.smartcities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_COMPRA")
public class Compra {

	@Id
	@Column(name="cd_compra")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="compra")
	@SequenceGenerator(name="compra",sequenceName="SQ_T_COMPRA",allocationSize=1)
	private int codigo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cd_endereco")
	private Endereco endereco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cd_receita")
	private Receita receita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cd_loja")
	private Loja loja;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
