package br.furb.lista.lineares.estatica;

import br.furb.lista.lineares.Lista;

public class ListaEstatica implements Lista {

    private static final int DEFAULT_SIZE = 10;

    private int info[];
    private int tamanho;

    public ListaEstatica() {
        info = new int[DEFAULT_SIZE];
        tamanho = 0;
    }

    @Override
    public void inserir(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }

        info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public void inserir(int valor, int pos) {

    }

    @Override
    public int pegar(int pos) {
        return info[pos];
    }

    private void redimensionar() {
        int[] novo = new int[info.length + DEFAULT_SIZE];

        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }

        info = novo;
    }

    @Override
    public int buscar(int valor) {

        for (int i = 0; i < info.length; i++) {
            if (info[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void retirar(int valor) {
        int indexValor = buscar(valor);

        if (indexValor == -1) {
            return;
        }

        for (int i = indexValor; i < tamanho; i++) {
            if (i + 1 == tamanho) {
                break;
            }

            int proximo = info[i + 1];
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
    public void concatenar(Lista lista) {
        for (int i = 0; i < lista.getTamanho(); i++) {
            this.inserir(lista.pegar(i));
        }
    }

    @Override
    public ListaEstatica dividir() {
        ListaEstatica dividida = new ListaEstatica();

        int tamanhoOriginal = this.tamanho;
        int metadeLista = this.tamanho / 2;

        for (int i = metadeLista; i < tamanhoOriginal; i++) {
            dividida.inserir(info[i]);
        }

        this.tamanho = metadeLista;

        return dividida;
    }

    @Override
    public ListaEstatica copiar() {
        ListaEstatica copy = new ListaEstatica();

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
