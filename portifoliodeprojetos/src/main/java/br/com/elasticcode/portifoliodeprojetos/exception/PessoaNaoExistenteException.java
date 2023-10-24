package br.com.elasticcode.portifoliodeprojetos.exception;

public class PessoaNaoExistenteException extends RuntimeException {
    public PessoaNaoExistenteException(Long id) {
        super("Pessoa com Id: " +id+ " nao foi encontrada.");
    }
}
