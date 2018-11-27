package br.com.fiap.smartcities.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_LOJA")
public class Loja {
	
	@Id
	@Column(name="cd_loja")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="loja")
	@SequenceGenerator(name="loja",sequenceName="SQ_T_LOJA",allocationSize=1)
	private int id;
	
	@Column(name="nm_loja",nullable=false,length=100)
	private String loja;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cd_endereco")
	private Endereco endereco;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "T_LOJA_PRODUTO", 
        joinColumns = { @JoinColumn(name = "cd_loja") }, 
        inverseJoinColumns = { @JoinColumn(name = "cd_produto") }
    )
    private List<Produto> produtos = new ArrayList<Produto>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
