package br.furb.lista.lineares.trabalho;

import br.furb.lista.lineares.Pilha;

import java.util.Arrays;

public class Calculadora {

    private static final String SEPARATOR = " ";

    private final Pilha<Double> pilha;

    public Calculadora() {
        this.pilha = PilhaFactory.create();
    }

    public Calculadora(int limite) {
        this.pilha = PilhaFactory.create(limite);
    }

    private Double soma(Double primeiroArgumento, Double segundoArgumento) {
        return primeiroArgumento + segundoArgumento;
    }

    private Double subtrai(Double primeiroArgumento, Double segundoArgumento) {
        return primeiroArgumento - segundoArgumento;
    }

    private double multiplica(Double primeiroArgumento, Double segundoArgumento) {
        return primeiroArgumento * segundoArgumento;
    }

    private Double divide(Double primeiroArgumento, Double segundoArgumento) {
        return primeiroArgumento / segundoArgumento;
    }

    public Double calcula(String expressao) {
        String[] expressionValues = expressao.split(SEPARATOR);

        if (expressionValues.length < 2) {
            throw new CalculoException("Expressão inválida");
        }

        long totalNumbers = Arrays.stream(expressionValues).filter(this::isNumber).count();
        long countSymbols = expressionValues.length - totalNumbers;

        if (totalNumbers == 0) {
            throw new CalculoException("Não há números na expressão.");
        }

        if (totalNumbers == countSymbols) {
            throw new CalculoException("Não há operandos suficientes para realizar a soma");
        }

        if ((totalNumbers - 1) != countSymbols) {
            throw new CalculoException("Faltou algum operador para usar todos os elementos da expressão");
        }

        for (String expressionValue : expressionValues) {
            if (isNumber(expressionValue)) {
                pilha.push(Double.parseDouble(expressionValue));
                continue;
            }


            Double segundoArgumento = pilha.pop();
            Double primeiroArgumento = pilha.pop();
            double resultado;

            switch (expressionValue) {
                case "+":
                    resultado = soma(primeiroArgumento, segundoArgumento);
                    break;
                case "–":
                case "-":
                    resultado = subtrai(primeiroArgumento, segundoArgumento);
                    break;
                case "*":
                    resultado = multiplica(primeiroArgumento, segundoArgumento);
                    break;
                case "/":
                    resultado = divide(primeiroArgumento, segundoArgumento);
                    break;
                default:
                    throw new CalculoException("Caracter inválido na expressão. Caracter: " + expressionValue);
            }

            pilha.push(resultado);
        }

        return pilha.pop();
    }

    private boolean isNumber(String expressionValue) {
        try {
            Double.parseDouble(expressionValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
