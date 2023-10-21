package br.com.elasticcode.portifoliodeprojetos.exception;
public class ExclusaoInvalidaException extends RuntimeException {
    public  ExclusaoInvalidaException (String mensagem){
        super(mensagem);
    }
}
