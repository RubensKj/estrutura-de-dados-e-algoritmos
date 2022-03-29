package br.furb.lista.lineares.trabalho;

import java.util.Scanner;

public class MainTrabalho {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer tipoPilha = leTipoPilha(scanner);
        String expressao = leExpressao(scanner);

        Calculadora calculadora = new Calculadora(tipoPilha);

        Double resultado = calculadora.calcula(expressao);

        System.out.println(resultado);
    }

    private static Integer leTipoPilha(Scanner scanner) {
        Integer tipoPilha = null;

        while (tipoPilha == null) {
            System.out.print("Qual pilha deseja usar (1 - Vetor, 2 - Lista): ");
            // TODO: Fix parse error
            tipoPilha = Integer.parseInt(scanner.next());

            if (tipoPilha > 2) {
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

            //TODO: Fix null pointer (if pass null)

            if (expressao.isEmpty() || expressao.isBlank()) {
                expressao = null;
            }
        }

        return expressao;
    }
}
