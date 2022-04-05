package br.furb.lista.lineares.fila;

public class TesteFilas {

    public static void main(String[] args) {
        FilaVetor<Integer> filaVetor = new FilaVetor<>(5);
        FilaVetor<Integer> filaVetor2 = new FilaVetor<>(5);

        filaVetor.inserir(13);
        filaVetor.inserir(14);
        filaVetor.inserir(15);
        filaVetor.inserir(16);
        filaVetor.inserir(12);

        filaVetor.retirar();
        filaVetor.retirar();
        filaVetor.retirar();
        filaVetor.retirar();

        filaVetor.inserir(9);
        filaVetor.inserir(3);

        filaVetor2.inserir(25);
        filaVetor2.inserir(30);
        filaVetor2.inserir(35);
        filaVetor2.inserir(40);

        FilaVetor<Integer> concatenar = filaVetor.concatenar(filaVetor2);

        System.out.println(filaVetor);
        System.out.println(concatenar);
    }
}
