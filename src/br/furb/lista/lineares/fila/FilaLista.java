package br.furb.lista.lineares.fila;

import br.furb.lista.lineares.Fila;
import br.furb.lista.lineares.encadeada.ListaEncadeada;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> listaEncadeada = new ListaEncadeada<>();

    @Override
    public void inserir(T valor) {
        listaEncadeada.inserir(valor);
    }

    @Override
    public T retirar() {
        T valor = peek();
        listaEncadeada.retirar(valor);
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazio()) {
            throw new RuntimeException("Fila está vazia");
        }

        return listaEncadeada.pegar(0);
    }

    @Override
    public boolean estaVazio() {
        return listaEncadeada.estaVazia();
    }

    @Override
    public void liberar() {
        listaEncadeada = new ListaEncadeada<>();
    }

    @Override
    public int getTamanho() {
        return listaEncadeada.getTamanho();
    }
}
