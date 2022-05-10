package br.furb.lista.arvores;

public class TesteNovo {

    public static void main(String[] args) {
        ArvoreBST<Integer> arvoreBST = new ArvoreBST<>();

        arvoreBST.inserir(22);
        arvoreBST.inserir(18);
        arvoreBST.inserir(31);
        arvoreBST.inserir(35);
        arvoreBST.inserir(30);
        arvoreBST.inserir(13);
        arvoreBST.inserir(40);
        arvoreBST.inserir(34);
        arvoreBST.inserir(14);

        System.out.println(arvoreBST.toString());

        arvoreBST.retirar(40);

        System.out.println(arvoreBST.toString());
    }
}
