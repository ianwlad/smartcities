package br.com.fiap.smartcities.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_Produto")
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="produto")
	@SequenceGenerator(name="produto",sequenceName="SQ_T_PRODUTO",allocationSize=1)
	private int codigo;
	
	@Column(name="nm_produto",nullable = false, length = 100)
	private String nomeProduto;
	
	@Column(name="nm_marca",nullable = false, length = 100)
	private String nomeMarca;
	
	@Column(name="ds_medida",nullable = false, length = 20)
	private String medida;
	
	@Column(name="vl_preco",nullable = false)
	private float preco;
	
	@ManyToMany(mappedBy = "produtos")
    private Set<Receita> receitas = new HashSet<Receita>();

	public Set<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(Set<Receita> receitas) {
		this.receitas = receitas;
	}

	//Getters e Setters	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
