package br.furb.lista.lineares;

public interface Lista {
    void inserir(int valor);

    void inserir(int valor, int pos);

    int pegar(int pos);

    int buscar(int valor);

    void retirar(int valor);

    String exibir();

    boolean estaVazia();

    void concatenar(Lista lista);

    Lista dividir();

    Lista copiar();

    int getTamanho();
}
