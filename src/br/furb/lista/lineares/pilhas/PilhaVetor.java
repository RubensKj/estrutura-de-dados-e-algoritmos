package br.furb.lista.lineares.pilhas;

import br.furb.lista.lineares.Pilha;

public class PilhaVetor<T> implements Pilha<T> {

    private T[] info;
    private final int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.tamanho = 0;
        this.limite = limite;
    }

    @Override
    public void push(T valor) {
        if (tamanho == limite) {
            throw new RuntimeException("Capacidade escogata da pilha");
        }

        info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public T pop() {
        T peek = peek();
        tamanho--;
        info[tamanho] = null;
        return peek;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha está vazia");
        }

        return info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        info = (T[]) new Object[limite];
        tamanho = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < tamanho; i++) {
            stringBuilder.append(info[i]);

            if ((i + 1) != tamanho) {
                stringBuilder.append(", ");
            }
        }

        return stringBuilder.append("]").toString();
    }

    public int compara(PilhaVetor<T> p2) {
        if (this.tamanho < p2.tamanho) {
            return -1;
        }

        if (this.tamanho == p2.tamanho) {
            for (int i = 0; i < this.tamanho; i++) {
                if (!info[i].equals(p2.info[i])) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }
}
