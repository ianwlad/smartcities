package br.com.fiap.smartcities.entity;

import javax.persistence.*;

@Entity
@Table(name="T_USUARIO")
public class Usuario {
	
	@Id
	@Column(name="cd_usuario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="usuario")
	@SequenceGenerator(name="usuario",sequenceName="SQ_T_USUARIO",allocationSize=1)
	private int codigo;
	
	@Column(name="nm_usuario",nullable=false,length=100)
	private String nome;
	
	@Column(name="ds_email", nullable=false,length=80)
	private String email;
	
	@Column(name="ds_senha", nullable=false, length=16)
	private String senha;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cd_endereco")
	private Endereco endereco;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
