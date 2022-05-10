package br.furb.lista.arvores;

public abstract class ArvoreBinariaAbstract<T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
        this.raiz = null;
    }

    protected void setRaiz(NoArvoreBinaria<T> no) {
        this.raiz = no;
    }

    public boolean vazia() {
        return this.raiz == null;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (this.vazia()) {
            return null;
        } else {
            return this.raiz.pertence(info);
        }
    }

    public String toString() {
        if (this.vazia()) {
            return "<>";
        } else {
            return this.raiz.imprimePre();
        }
    }

    public NoArvoreBinaria<T> getRaiz(){
        return this.raiz;
    }

    public abstract void retirar(T info);
}
