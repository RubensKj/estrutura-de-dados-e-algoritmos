package br.furb.lista.lineares.trabalho;

import br.furb.lista.lineares.Pilha;
import br.furb.lista.lineares.pilhas.PilhaLista;
import br.furb.lista.lineares.pilhas.PilhaVetor;

public class PilhaFactory {

    public static Pilha<Double> create(Integer tipoPilha) {
        switch (tipoPilha) {
            case 1:
                return new PilhaVetor<>(10000);
            case 2:
                return new PilhaLista<>();
            default:
                throw new RuntimeException("Tipo de pilha inválido. TipoPilha: " + tipoPilha);
        }
    }
}
