package br.com.elasticcode.portifoliodeprojetos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "funcionario")
public class FuncionarioEntity extends PessoaEntity {

    @NotBlank
    private String matricula;


    public FuncionarioEntity() {

    }
}
