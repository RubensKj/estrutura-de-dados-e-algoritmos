package br.furb.lista.lineares.encadeada;

import br.furb.lista.lineares.Lista;

public class ListaEncadeada implements Lista {

    private NoLista primeiro;
    private NoLista ultimo;
    private int qtdElementos;

    public ListaEncadeada() {
        primeiro = null;
        qtdElementos = 0;
    }

    @Override
    public void inserir(int valor) {
        NoLista novo = new NoLista();
        novo.setInfo(valor);

        if (this.estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProx(novo);
        }

        ultimo = novo;
        qtdElementos++;
    }

    @Override
    public void inserir(int valor, int pos) {

    }

    @Override
    public int pegar(int pos) {
        return 0;
    }

    @Override
    public int buscar(int valor) {
        NoLista p = this.primeiro;

        int index = 0;

        while (p != null) {
            if (p.getInfo() == valor) {
                return index;
            }
            p = p.getProx();
            index++;
        }

        return -1;
    }

    @Override
    public void retirar(int valor) {
        if (primeiro.getInfo() == valor) {
            primeiro = primeiro.getProx();
            return;
        }

        NoLista p = primeiro.getProx();
        NoLista anterior = primeiro;

        while (p != null) {
            if (p.getInfo() == valor) {
                anterior.setProx(p.getProx());
                break;
            }
            anterior = p;
            p = p.getProx();
        }

        if (ultimo == p) {
            ultimo = anterior;
        }
    }

    @Override
    public String exibir() {
        StringBuilder builder = new StringBuilder("[");
        NoLista p = this.primeiro;

        while (p != null) {
            builder.append(p.getInfo());
            builder.append(", ");
            p = p.getProx();
        }

        return builder.append("]").toString();
    }

    @Override
    public boolean estaVazia() {
        return primeiro == null;
    }

    @Override
    public void concatenar(Lista lista) {

    }

    @Override
    public Lista dividir() {
        return null;
    }

    @Override
    public Lista copiar() {
        return null;
    }

    @Override
    public int getTamanho() {
        return qtdElementos;
    }
}
