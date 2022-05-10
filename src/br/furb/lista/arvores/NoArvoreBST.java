package br.furb.lista.arvores;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

    public NoArvoreBST(T info) {
        super(info);
    }

    public NoArvoreBST<T> buscar(T valor) {
        if (this.getInfo().equals(valor)) {
            return this;
        } else {
            if (valor.compareTo(this.getInfo()) < 0) {
                if (this.getEsq() == null) {
                    return null;
                } else {
                    return ((NoArvoreBST<T>) this.getEsq()).buscar(valor);
                }
            } else {
                if (this.getDir() == null) {
                    return null;
                } else {
                    return ((NoArvoreBST<T>) this.getDir()).buscar(valor);
                }
            }
        }
    }

    public void inserir(T info) {
        if (info.compareTo(this.getInfo()) < 0) {
            if (this.getEsq() == null) {
                this.setEsq(new NoArvoreBST<>(info));
            } else {
                ((NoArvoreBST<T>) this.getEsq()).inserir(info);
            }
        } else {
            if (this.getDir() == null) {
                this.setDir(new NoArvoreBST<>(info));
            } else {
                ((NoArvoreBST<T>) this.getDir()).inserir(info);
            }
        }
    }

    public NoArvoreBST<T> descobrirPai(NoArvoreBST<T> noArvore) {
        if (this.getInfo().equals(noArvore.getInfo())) {
            return null;
        }

        if (this.getEsq() != null && this.getEsq().equals(noArvore) || this.getDir() != null && this.getDir().equals(noArvore)) {
            return this;
        } else {
            NoArvoreBST<T> esq = (NoArvoreBST<T>) this.getEsq();

            if (esq != null) {
                NoArvoreBST<T> achouEsquerda = esq.descobrirPai(noArvore);

                if (achouEsquerda != null) {
                    return achouEsquerda;
                }
            }

            NoArvoreBST<T> dir = (NoArvoreBST<T>) this.getDir();

            if (dir != null) {
                return dir.descobrirPai(noArvore);
            }

            return null;
        }
    }

    public boolean ehFolha() {
        return this.getEsq() == null && this.getDir() == null;
    }

    public boolean temUmFilho() {
        return this.getEsq() == null ^ this.getDir() == null;
    }
}