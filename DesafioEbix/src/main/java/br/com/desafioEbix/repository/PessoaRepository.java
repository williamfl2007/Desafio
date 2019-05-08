package br.com.desafioEbix.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.desafioEbix.model.Pessoa;

@Repository
public class PessoaRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Pessoa> findAll() {
		return jdbcTemplate.query("select * from pessoa", 
				(rs, rowNum) -> new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade")));
	}
	
	public Pessoa findById(Integer id) {
		return jdbcTemplate.queryForObject("select * from Pessoa where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Pessoa>(Pessoa.class));
	}
	
	public void incluir(Pessoa pessoa) {
		String sqlInsertQuery = "insert into Pessoa (nome,idade) values (?, ?)";
		jdbcTemplate.update(sqlInsertQuery, pessoa.getNome(),pessoa.getIdade());
	}
	

	public void alterar(Pessoa pessoa) {
		String sqlUpdateQuery  = "update Pessoa set nome=?,idade=? where id=?";
		jdbcTemplate.update(sqlUpdateQuery, pessoa.getNome(),pessoa.getIdade(),pessoa.getId());
	}
	
	public void excluir(Integer id) {
		String sqlDeleteQuery = "delete from pessoa where id=?";
		jdbcTemplate.update(sqlDeleteQuery, id);
	}
	
	
}
