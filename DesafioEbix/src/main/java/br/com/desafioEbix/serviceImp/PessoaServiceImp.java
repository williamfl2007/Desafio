package br.com.desafioEbix.serviceImp;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.desafioEbix.model.Pessoa;
import br.com.desafioEbix.repository.PessoaRepository;
import br.com.desafioEbix.service.PessoaService;

@WebService()
public class PessoaServiceImp implements PessoaService{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public List<Pessoa> consultarTodos() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa consultarPorId(Integer id) {
		return pessoaRepository.findById(id);
	}

	@Override
	public void incluir(Pessoa pessoa) {		
		pessoaRepository.incluir(pessoa);
	}

	@Override
	public void alterar(Pessoa pessoa) {
		pessoaRepository.alterar(pessoa);
	}

	@Override
	public void excluir(Integer id) {		
		pessoaRepository.excluir(id);
	}

}
