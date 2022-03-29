package br.furb.lista.lineares.pilhas;

public class TestePilhas {

    public static void main(String[] args) {

        PilhaLista<Integer> pilhaLista = new PilhaLista<>();

        pilhaLista.push(6);
        pilhaLista.push(4);
        pilhaLista.push(5);
        pilhaLista.push(2);
        pilhaLista.push(3);
        pilhaLista.push(8);
        pilhaLista.push(12);
        System.out.println(pilhaLista);
        System.out.println(pilhaLista.peek());
        System.out.println(pilhaLista.pop());
        System.out.println(pilhaLista.pop());
        System.out.println(pilhaLista.pop());

        PilhaVetor<Integer> pilhaVetor = new PilhaVetor<>(10);

        pilhaVetor.push(6);
        pilhaVetor.push(4);
        pilhaVetor.push(5);
        pilhaVetor.push(2);
        pilhaVetor.push(3);
        pilhaVetor.push(8);
        pilhaVetor.push(12);
        System.out.println(pilhaVetor);
        System.out.println(pilhaVetor.peek());
        System.out.println(pilhaVetor.pop());
        System.out.println(pilhaVetor.pop());
        System.out.println(pilhaVetor.pop());
    }
}
