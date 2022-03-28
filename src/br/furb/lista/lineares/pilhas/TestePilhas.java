package br.furb.lista.lineares.pilhas;

public class TestePilhas {

    public static void main(String[] args) {
        PilhaLista<Integer> pilhaLista = new PilhaLista<>();

        pilhaLista.push(2);
        pilhaLista.push(3);

        System.out.println(pilhaLista);
        System.out.println(pilhaLista.peek());
        System.out.println(pilhaLista.pop());
        System.out.println(pilhaLista.pop());

        PilhaVetor<Integer> pilhaVetor = new PilhaVetor<>(3);

        pilhaVetor.push(6);
        pilhaVetor.push(4);
        pilhaVetor.push(4);
        System.out.println(pilhaVetor);
        System.out.println(pilhaVetor.peek());
        System.out.println(pilhaVetor.pop());
        System.out.println(pilhaVetor.pop());
        System.out.println(pilhaVetor.pop());
    }
}
