package br.furb.lista.lineares.trabalho;

import br.furb.lista.lineares.Pilha;
import br.furb.lista.lineares.pilhas.PilhaLista;
import br.furb.lista.lineares.pilhas.PilhaVetor;

public class PilhaFactory {

    public static Pilha<Double> create() {
        return new PilhaLista<>();
    }

    public static Pilha<Double> create(int limite) {
        return new PilhaVetor<>(limite);
    }
}
