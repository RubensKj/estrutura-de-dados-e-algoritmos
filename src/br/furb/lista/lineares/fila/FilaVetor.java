package br.furb.lista.lineares.fila;

import br.furb.lista.lineares.Fila;

public class FilaVetor<T> implements Fila<T> {

    private final int limite;
    private T[] info;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new RuntimeException("Fila está cheia");
        }

        int posicaoInserir = (inicio + tamanho) % limite;

        info[posicaoInserir] = valor;
        tamanho++;
    }

    @Override
    public T retirar() {
        T valor = peek();

        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho--;

        return valor;
    }

    @Override
    public T peek() {
        if (estaVazio()) {
            throw new RuntimeException("Fila está vazia");
        }

        return info[inicio];
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        info = (T[]) new Object[limite];
        tamanho = 0;
        inicio = 0;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    public FilaVetor<T> concatenar(FilaVetor<T> f2) {
        FilaVetor<T> nova = new FilaVetor<>(getTamanho() + f2.getTamanho());

        for (int i = 0; i < getTamanho(); i++) {
            nova.inserir(this.info[(i + this.inicio) % this.limite]);
        }

        for (int i = 0; i < f2.getTamanho(); i++) {
            nova.inserir(f2.info[(i + f2.inicio) % f2.limite]);
        }

        return nova;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        int posicao = inicio;
        for (int i = 0; i < tamanho; i++) {
            stringBuilder.append(info[posicao]);

            posicao = (posicao + 1) % limite;

            if ((i + 1) != tamanho) {
                stringBuilder.append(", ");
            }
        }

        return stringBuilder.append("]").toString();
    }
}
