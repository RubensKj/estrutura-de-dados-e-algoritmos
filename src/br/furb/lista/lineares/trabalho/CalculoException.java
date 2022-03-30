package br.furb.lista.lineares.trabalho;

public class CalculoException extends RuntimeException {

    public CalculoException() {
    }

    public CalculoException(String message) {
        super(message);
    }

    public CalculoException(String message, Throwable cause) {
        super(message, cause);
    }
}
