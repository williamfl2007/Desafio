package br.com.desafioEbix.service;

import java.util.List;

import br.com.desafioEbix.model.Pessoa;

public abstract interface PessoaService {
	
     List<Pessoa> consultarTodos();
     
     Pessoa consultarPorId(Integer id);
     
     void incluir(Pessoa pessoa);
     
     void alterar(Pessoa pessoa);
     
     void excluir(Integer id);

}
