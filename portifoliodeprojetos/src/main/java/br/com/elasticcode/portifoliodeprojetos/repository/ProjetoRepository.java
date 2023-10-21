package br.com.elasticcode.portifoliodeprojetos.repository;

import br.com.elasticcode.portifoliodeprojetos.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository  extends JpaRepository<Projeto, Long> {
}
