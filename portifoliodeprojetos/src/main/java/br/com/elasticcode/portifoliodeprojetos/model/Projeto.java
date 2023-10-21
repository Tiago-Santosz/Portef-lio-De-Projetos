package br.com.elasticcode.portifoliodeprojetos.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nome;
    private LocalDate dataDeInicio;
    private  String gerenteResponsavel;
    private  LocalDate dataDeTermino;
    private BigDecimal orcamentoTotal;
    private String descricao;
    private String status;

    @Enumerated(EnumType.STRING)
    private  ClassificacaoDeRiscoEnum classificacaoDeRiscoEnum;

    @ManyToMany
    @JoinTable(name = "projeto_pessoa",
    joinColumns = @JoinColumn(name = "projeto_id"),
    inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
    private Set<Pessoa> membros = new HashSet<>();

    public Projeto() {

    }

    public Projeto(Long id, String nome, LocalDate dataDeInicio, LocalDate dataDeTermino,
                   BigDecimal orcamentoTotal, String descricao, String status) {
        this.id = id;
        this.nome = nome;
        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;
        this.orcamentoTotal = orcamentoTotal;
        this.descricao = descricao;
        this.status = status;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(LocalDate dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGerenteResponsavel() {
        return gerenteResponsavel;
    }

    public void setGerenteResponsavel(String gerenteResponsavel) {
        this.gerenteResponsavel = gerenteResponsavel;
    }

    public BigDecimal getOrcamentoTotal() {
        return orcamentoTotal;
    }

    public void setOrcamentoTotal(BigDecimal orcamentoTotal) {
        this.orcamentoTotal = orcamentoTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Pessoa> getMembros() {
        return membros;
    }

    public void setMembros(Set<Pessoa> membros) {
        this.membros = membros;
    }

    public ClassificacaoDeRiscoEnum getClassificacaoDeRiscoEnum() {
        return classificacaoDeRiscoEnum;
    }

    public void setClassificacaoDeRiscoEnum(ClassificacaoDeRiscoEnum classificacaoDeRiscoEnum) {
        this.classificacaoDeRiscoEnum = classificacaoDeRiscoEnum;
    }
}

