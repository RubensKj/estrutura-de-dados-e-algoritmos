package br.furb.lista.lineares.trabalho;

import br.furb.lista.lineares.Pilha;

public class Calculadora {

    private static final String SEPARATOR = " ";

    private final Pilha<Double> pilha;

    public Calculadora(Integer tipoPilha) {
        this.pilha = PilhaFactory.create(tipoPilha);
    }

    private double multiplica(Double primeiroArgumento, Double segundoArgumento) {
        return primeiroArgumento * segundoArgumento;
    }

    private Double subtrai(Double primeiroArgumento, Double segundoArgumento) {
        return primeiroArgumento - segundoArgumento;
    }

    private Double soma(Double primeiroArgumento, Double segundoArgumento) {
        return primeiroArgumento + segundoArgumento;
    }

    private Double divide(Double primeiroArgumento, Double segundoArgumento) {
        return primeiroArgumento / segundoArgumento;
    }

    public Double calcula(String expressao) {
        String[] expressionValues = expressao.split(SEPARATOR);

        for (String expressionValue : expressionValues) {
            if (isNumber(expressionValue)) {
                pilha.push(Double.parseDouble(expressionValue));
                System.out.println(expressionValue);
                continue;
            }


            Double segundoArgumento = pilha.pop();
            Double primeiroArgumento = pilha.pop();
            double resultado;

            // TODO: Fix pilha lista... nao trazendo resultado certo

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
                    throw new RuntimeException("Caracter inválido na expressão. Caracter: " + expressionValue);
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
