package br.furb.lista.lineares.estatica;

import br.furb.lista.lineares.Lista;

public class ListaEstatica<T> implements Lista<T> {

    private static final int DEFAULT_SIZE = 10;

    private T[] info;
    private int tamanho;

    public ListaEstatica() {
        info = (T[]) new Object[DEFAULT_SIZE];
        tamanho = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }

        info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public void inserir(T valor, int pos) {

    }

    @Override
    public T pegar(int pos) {
        return info[pos];
    }

    private void redimensionar() {
        T[] novo = (T[]) new Object[info.length + DEFAULT_SIZE];

        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }

        info = novo;
    }

    @Override
    public int buscar(T valor) {

        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void retirar(T valor) {
        int indexValor = buscar(valor);

        if (indexValor == -1) {
            return;
        }

        for (int i = indexValor; i < tamanho; i++) {
            if (i + 1 == tamanho) {
                break;
            }

            T proximo = info[i + 1];
            info[i] = proximo;
        }

        tamanho--;
    }

    @Override
    public String exibir() {
        StringBuilder infoString = new StringBuilder("[");

        for (int i = 0; i < tamanho; i++) {
            infoString.append(info[i]);

            if (i + 1 != tamanho) {
                infoString.append(", ");
            }
        }

        return infoString.append("]").toString();
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void concatenar(Lista<T> lista) {
        for (int i = 0; i < lista.getTamanho(); i++) {
            this.inserir(lista.pegar(i));
        }
    }

    @Override
    public Lista<T> dividir() {
        ListaEstatica<T> dividida = new ListaEstatica<>();

        int tamanhoOriginal = this.tamanho;
        int metadeLista = this.tamanho / 2;

        for (int i = metadeLista; i < tamanhoOriginal; i++) {
            dividida.inserir(info[i]);
        }

        this.tamanho = metadeLista;

        return dividida;
    }

    @Override
    public Lista<T> copiar() {
        Lista<T> copy = new ListaEstatica<>();

        for (int i = 0; i < tamanho; i++) {
            copy.inserir(info[i]);
        }

        return copy;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }
}
