package br.com.elasticcode.portifoliodeprojetos.repository;

import br.com.elasticcode.portifoliodeprojetos.model.PessoaEntity;
import br.com.elasticcode.portifoliodeprojetos.model.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
