package br.furb.lista.lineares;

public interface Lista<T> {
    void inserir(T valor);

    void inserir(T valor, int pos);

    T pegar(int pos);

    int buscar(T valor);

    void retirar(T valor);

    String exibir();

    boolean estaVazia();

    void concatenar(Lista<T> lista);

    Lista<T> dividir();

    Lista<T> copiar();

    int getTamanho();
}
