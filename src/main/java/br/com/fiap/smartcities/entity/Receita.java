package br.com.fiap.smartcities.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
	
@Entity
@Table(name="T_RECEITA")
public class Receita {

	@Id
	@Column(name="cd_receita")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="receita")
	@SequenceGenerator(name="receita",sequenceName="SQ_T_RECEITA",allocationSize=1)
	private int id;
	
	@Column(name="nm_receita",nullable=false,length=100)
	private String nome;
	
	@Column(name="ds_receita", nullable = false, length = 600)
	private String descricao;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "T_PRODUTO_RECEITA", 
        joinColumns = { @JoinColumn(name = "cd_receita") }, 
        inverseJoinColumns = { @JoinColumn(name = "cd_produto") }
    )
    private List<Produto> produtos = new ArrayList<Produto>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
