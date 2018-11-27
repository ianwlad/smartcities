package br.com.fiap.smartcities.dao.impl;

import org.springframework.stereotype.Repository;
import br.com.fiap.smartcities.dao.ProdutoDAO;
import br.com.fiap.smartcities.entity.Produto;

@Repository
public class ProdutoDAOImpl extends GenericDAOImpl<Produto,Integer> implements ProdutoDAO{
	
	public void cadastrar(Produto p) {
		em.persist(p);
	}
	
}
