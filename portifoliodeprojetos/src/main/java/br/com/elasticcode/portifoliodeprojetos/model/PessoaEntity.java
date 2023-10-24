package br.com.elasticcode.portifoliodeprojetos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class PessoaEntity {

    public PessoaEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    private Date dataNascimento;

    @Column(unique = true)
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;


    @Column
    private boolean funcionario;

    @Column
    private boolean gerente;

}
