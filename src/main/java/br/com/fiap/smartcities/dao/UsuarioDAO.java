package br.com.fiap.smartcities.dao;

import br.com.fiap.smartcities.entity.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario,Integer>{
	public void cadastrar(Usuario u);
}
