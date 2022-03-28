package br.furb.lista.lineares.pilhas;

import br.furb.lista.lineares.Pilha;
import br.furb.lista.lineares.encadeada.ListaEncadeada;
import br.furb.lista.lineares.encadeada.NoLista;

public class PilhaLista<T> implements Pilha<T> {

    private final ListaEncadeada<T> listaEncadeada = new ListaEncadeada<>();

    @Override
    public void push(T info) {
        listaEncadeada.inserir(info);
    }

    @Override
    public T pop() {
        T valor = peek();
        listaEncadeada.retirar(valor);
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha está vazia");
        }

        NoLista<T> ultimo = listaEncadeada.getUltimo();

        return ultimo.getInfo();
    }

    @Override
    public boolean estaVazia() {
        return listaEncadeada.estaVazia();
    }

    @Override
    public void liberar() {
        for (int i = 0; i < listaEncadeada.getTamanho(); i++) {
            T valor = listaEncadeada.pegar(i);
            listaEncadeada.retirar(valor);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        int tamanho = listaEncadeada.getTamanho();

        for (int i = 0; i < tamanho; i++) {
            stringBuilder.append(listaEncadeada.pegar(i));

            if ((i + 1) != tamanho) {
                stringBuilder.append(", ");
            }
        }

        return stringBuilder.append("]").toString();
    }
}
