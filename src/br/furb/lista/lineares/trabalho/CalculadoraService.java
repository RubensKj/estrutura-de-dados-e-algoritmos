package br.furb.lista.lineares.trabalho;

import java.util.Objects;

public class CalculadoraService {

    public Calculadora create(Integer limite) {
        if (Objects.nonNull(limite)) {
            return new Calculadora(limite);
        }

        return new Calculadora();
    }
}
