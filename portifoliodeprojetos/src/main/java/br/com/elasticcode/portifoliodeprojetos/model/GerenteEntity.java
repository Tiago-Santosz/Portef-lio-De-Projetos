package br.com.elasticcode.portifoliodeprojetos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "gerente")
public class GerenteEntity extends PessoaEntity {

    public GerenteEntity() {

    }
}
