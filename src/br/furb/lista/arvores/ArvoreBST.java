package br.furb.lista.arvores;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public NoArvoreBST<T> buscar(T valor) {
        if (this.vazia()) {
            return null;
        }
        return ((NoArvoreBST<T>) this.getRaiz()).buscar(valor);
    }

    public void inserir(T info) {
        if (this.vazia()) {
            this.setRaiz(new NoArvoreBST<>(info));
        } else {
            ((NoArvoreBST<T>) this.getRaiz()).inserir(info);
        }
    }

    @Override
    public void retirar(T info) {
        NoArvoreBST<T> encontrado = buscar(info);

        if (encontrado == null) {
            return;
        }

        NoArvoreBST<T> pai = this.descobrirPai(encontrado);

        NoArvoreBinaria<T> dir = encontrado.getDir();
        NoArvoreBinaria<T> esq = encontrado.getEsq();

        // TODO: Caso 2/3


        if (encontrado.temUmFilho()) {
            System.out.println("Tem um filho");
            return;
        }

        if (!encontrado.ehFolha()) {
            System.out.println("Tem dois filho");
            return;
        }

        if (encontrado.ehFolha()) {
            if (pai.getDir().equals(encontrado)) {
                pai.setDir(null);
                return;
            }

            if (pai.getEsq().equals(encontrado)) {
                pai.setEsq(null);
                return;
            }
        }
    }

    private NoArvoreBST<T> descobrirPai(NoArvoreBST<T> noArvore) {
        NoArvoreBST<T> raiz = (NoArvoreBST<T>) this.getRaiz();
        return raiz.descobrirPai(noArvore);
    }
}