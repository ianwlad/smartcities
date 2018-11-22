package br.com.fiap.smartcities.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.smartcities.dao.UsuarioDAO;
import br.com.fiap.smartcities.entity.Usuario;

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario,Integer> implements UsuarioDAO{
	public void cadastrar(Usuario u) {
		em.persist(u);
	}
}
