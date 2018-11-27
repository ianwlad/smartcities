package br.com.fiap.smartcities.dao;

import br.com.fiap.smartcities.entity.Produto;

public interface ProdutoDAO extends GenericDAO<Produto,Integer>{
	public void cadastrar(Produto p);
}
