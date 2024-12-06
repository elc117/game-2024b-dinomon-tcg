package io.github.antoniosrt;

public class MaoJogador {
    private Carta[] cartas;
    private int totalCartas = 3;

    public MaoJogador() {
        cartas = new Carta[totalCartas];
    }

    public void adicionarCarta(Carta carta,int i) {
            if (cartas[i] == null) {
                cartas[i] = carta;
        }
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void removerCarta(int index) {
        cartas[index] = null;
    }

    public int getTotalCartas() {
        int total = 0;
        for (int i = 0; i < totalCartas; i++) {
            if (cartas[i] != null) {
                total++;
            }
        }
        return total;
    }

    public Carta comprarCarta(Baralho baralho) {
        return baralho.retirarCarta();
    }

    public void jogarCarta(int index) {
        cartas[index] = null;
    }
    public void encherMao(Baralho baralho){
        for (int i = 0; i < totalCartas; i++) {
            adicionarCarta(comprarCarta(baralho),i);
        }
    }
}
