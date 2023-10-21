package br.com.elasticcode.portifoliodeprojetos.exception;

public class ProjetoNaoExistenteException extends RuntimeException {
    public ProjetoNaoExistenteException(Long id) {
        super("Projeto com Id: " +id+ " nao foi encontrado.");
    }
}
