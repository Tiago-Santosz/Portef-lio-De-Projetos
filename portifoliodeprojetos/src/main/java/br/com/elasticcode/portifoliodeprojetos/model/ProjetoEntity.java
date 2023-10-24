package br.com.elasticcode.portifoliodeprojetos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "projeto")
public class ProjetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeInicio;
    private  String gerenteResponsavel;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPrevisaoFim;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private  LocalDate dataDeTermino;
    private BigDecimal orcamentoTotal;
    private String descricao;
    private String risco;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    private  ClassificacaoDeRiscoEnum classificacaoDeRiscoEnum;


    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
    @JoinTable(name = "membros", joinColumns = @JoinColumn(name = "idprojeto", foreignKey = @ForeignKey(name
            = "idprojeto_fk")), inverseJoinColumns = @JoinColumn(name = "idpessoa", foreignKey = @ForeignKey(name
            = "idpessoa_fk")))
    private List<PessoaEntity> membros = new ArrayList<PessoaEntity>();


    public ProjetoEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public String getGerenteResponsavel() {
        return gerenteResponsavel;
    }

    public void setGerenteResponsavel(String gerenteResponsavel) {
        this.gerenteResponsavel = gerenteResponsavel;
    }

    public LocalDate getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(LocalDate dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(LocalDate dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
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

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public ClassificacaoDeRiscoEnum getClassificacaoDeRiscoEnum() {
        return classificacaoDeRiscoEnum;
    }

    public void setClassificacaoDeRiscoEnum(ClassificacaoDeRiscoEnum classificacaoDeRiscoEnum) {
        this.classificacaoDeRiscoEnum = classificacaoDeRiscoEnum;
    }

    public List<PessoaEntity> getMembros() {
        return membros;
    }

    public void setMembros(List<PessoaEntity> membros) {
        this.membros = membros;
    }
}

