package br.furb.lista;

public class ListaEstatica {

    private static final int DEFAULT_SIZE = 10;

    private int info[];
    private int tamanho;

    public ListaEstatica() {
        info = new int[DEFAULT_SIZE];
        tamanho = 0;
    }

    public void inserir(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }

        info[tamanho] = valor;
        tamanho++;
    }

    private void redimensionar() {
        int[] novo = new int[info.length + DEFAULT_SIZE];

        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }

        info = novo;
    }

    public int buscar(int valor) {

        for (int i = 0; i < info.length; i++) {
            if (info[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor) {
        int indexValor = buscar(valor);

        if (indexValor == -1) {
            return;
        }

        for (int i = indexValor; i < info.length; i++) {
            if (i + 1 == info.length) {
                break;
            }

            int proximo = info[i + 1];
            info[i] = proximo;
        }

        tamanho--;
    }

    public String exibir() {
        StringBuilder infoString = new StringBuilder("[");

        for (int i = 0; i < info.length; i++) {
            infoString.append(info[i]);

            if (i + 1 != info.length) {
                infoString.append(", ");
            }
        }

        return infoString.append("]").toString();
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void concatenar(ListaEstatica lista) {
        for (int i = 0; i < lista.info.length; i++) {
            this.inserir(lista.info[i]);
        }
    }

    public ListaEstatica dividir() {
        ListaEstatica dividida = new ListaEstatica();

        for (int i = 0; i < tamanho / 2; i++) {
            int valor = this.info[i];
            dividida.inserir(valor);
            this.retirar(valor);
        }

        return dividida;
    }

    public ListaEstatica copiar() {
        ListaEstatica copy = new ListaEstatica();

        for (int i = 0; i < info.length; i++) {
            copy.inserir(info[i]);
        }

        return copy;
    }
}
