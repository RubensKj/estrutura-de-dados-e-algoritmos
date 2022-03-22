package br.furb.lista.lineares.encadeada;

import br.furb.lista.lineares.Lista;

public class ListaEncadeada<T> implements Lista<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;
    private int qtdElementos;

    public ListaEncadeada() {
        primeiro = null;
        qtdElementos = 0;
    }

    @Override
    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>();
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
    public void inserir(T valor, int pos) {

    }

    @Override
    public T pegar(int pos) {
        if (pos >= qtdElementos || pos < 0) {
            throw new IndexOutOfBoundsException();
        }

        NoLista<T> p = this.primeiro;

        int index = 0;

        while (p != null) {
            if (index == pos) {
                return p.getInfo();
            }
            p = p.getProx();
            index++;
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public int buscar(T valor) {
        NoLista<T> p = this.primeiro;

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
    public void retirar(T valor) {
        if (primeiro.getInfo().equals(valor)) {
            primeiro = primeiro.getProx();
            qtdElementos--;
            return;
        }

        NoLista<T> p = primeiro.getProx();
        NoLista<T> anterior = primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                anterior.setProx(p.getProx());
                qtdElementos--;
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
        NoLista<T> p = this.primeiro;

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
    public void concatenar(Lista<T> lista) {
        for (int i = 0; i < lista.getTamanho(); i++) {
            T valor = lista.pegar(i);
            inserir(valor);
        }
    }

    @Override
    public Lista<T> dividir() {
        Lista<T> dividida = new ListaEncadeada<T>();

        int metadeLista = this.qtdElementos / 2;

        NoLista<T> p = this.primeiro;
        int index = 0;

        while (p != null) {
            if (index > metadeLista) {
                T valor = pegar(index);
                dividida.inserir(valor);
            }

            if (index == metadeLista) {
                ultimo = p;
            }

            p = p.getProx();
            index++;
        }

        this.ultimo.setProx(null);
        this.qtdElementos = metadeLista;

        return dividida;
    }

    @Override
    public Lista<T> copiar() {
        Lista<T> listaEncadeada = new ListaEncadeada<>();

        NoLista<T> p = this.primeiro;

        while (p != null) {
            listaEncadeada.inserir(p.getInfo());
            p = p.getProx();
        }

        return listaEncadeada;
    }

    @Override
    public int getTamanho() {
        return qtdElementos;
    }
}
