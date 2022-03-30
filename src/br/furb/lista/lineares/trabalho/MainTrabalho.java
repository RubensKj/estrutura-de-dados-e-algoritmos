package br.furb.lista.lineares.trabalho;

import java.util.Scanner;

public class MainTrabalho {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer tipoPilha = leTipoPilha(scanner);

        Integer limite = null;

        if (tipoPilha == 1) {
            limite = leLimite(scanner);
        }

        String expressao = leExpressao(scanner);

        CalculadoraService calculadoraService = new CalculadoraService();
        Calculadora calculadora = calculadoraService.create(limite);

        Double resultado = calculadora.calcula(expressao);

        System.out.println("\n-------------------------------------------");
        System.out.print("Resultado do calculo: ");
        System.out.println(resultado);
        System.out.println("-------------------------------------------");
    }

    private static Integer leTipoPilha(Scanner scanner) {
        Integer tipoPilha = null;

        while (tipoPilha == null) {
            System.out.print("Qual pilha deseja usar (1 - Vetor, 2 - Lista): ");
            tipoPilha = parseNumber(scanner);

            if (tipoPilha < 1 || tipoPilha > 2) {
                System.out.println("Valor inválido...");
                tipoPilha = null;
            }
        }

        return tipoPilha;
    }

    private static String leExpressao(Scanner scanner) {
        System.out.print("Digite sua expressão em notação pós-fixa (Ex: 1 2 - 4 5 + *): ");

        String expressao = null;

        while (expressao == null) {
            expressao = scanner.nextLine();

            if (expressao.isEmpty() || expressao.isBlank()) {
                expressao = null;
            }
        }

        return expressao;
    }

    private static Integer leLimite(Scanner scanner) {
        Integer limite = null;

        while (limite == null) {
            System.out.print("Qual limite deseja usar para o vetor: ");

            limite = parseNumber(scanner);

            if (limite <= 0) {
                System.out.println("Valor inválido...");
                limite = null;
            }
        }

        return limite;
    }

    private static int parseNumber(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
