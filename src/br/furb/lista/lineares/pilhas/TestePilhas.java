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

        System.out.println("\n\n");
        System.out.println("-------- IGUAIS --------");

        PilhaVetor<Integer> p1 = new PilhaVetor<>(20);
        PilhaVetor<Integer> p2 = new PilhaVetor<>(20);

        p1.push(20);
        p1.push(21);
        p1.push(22);
        p1.push(23);

        p2.push(20);
        p2.push(21);
        p2.push(22);
        p2.push(23);

        System.out.println("Testando pilha iguais: ");
        System.out.println(p1.compara(p2));

        System.out.println("-------- ESTA PILHA MENOR --------");

        PilhaVetor<Integer> p1Menor = new PilhaVetor<>(20);
        PilhaVetor<Integer> p2Menor = new PilhaVetor<>(20);

        p1Menor.push(20);
        p1Menor.push(21);

        p2Menor.push(20);
        p2Menor.push(21);
        p2Menor.push(22);
        p2Menor.push(23);

        System.out.println("Testando esta pilha menor: ");
        System.out.println(p1Menor.compara(p2Menor));

        System.out.println("-------- TAMANHO IGUAL MAS EM POSIÇÃO DIFERENTE --------");

        PilhaVetor<Integer> p1Diferentes = new PilhaVetor<>(20);
        PilhaVetor<Integer> p2Diferentes = new PilhaVetor<>(20);

        p1Diferentes.push(20);
        p1Diferentes.push(21);
        p1Diferentes.push(23);
        p1Diferentes.push(22);

        p2Diferentes.push(20);
        p2Diferentes.push(21);
        p2Diferentes.push(22);
        p2Diferentes.push(23);

        System.out.println("Testando esta pilha tamanho iguais mas em posições diferentes: ");
        System.out.println(p1Diferentes.compara(p2Diferentes));

        System.out.println("-------- VAZIAS --------");

        PilhaVetor<Integer> p1Empty = new PilhaVetor<>(20);
        PilhaVetor<Integer> p2Empty = new PilhaVetor<>(20);

        System.out.println("Testando com pilhas vazias: ");
        System.out.println(p1Empty.compara(p2Empty));
    }
}
