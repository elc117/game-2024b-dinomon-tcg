package io.github.antoniosrt;

public class MaoJogador {
    private Carta[] cartas;
    private int totalCartas = 3;

    public MaoJogador() {
        cartas = new Carta[totalCartas];
    }

    public void adicionarCarta(Carta carta) {
        for (int i = 0; i < totalCartas; i++) {
            if (cartas[i] == null) {
                cartas[i] = carta;
                break;
            }
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
        for (int i = 0; i < totalCartas; i++) {
            if (cartas[i] == null) {
                cartas[i] = baralho.retirarCarta();
                return cartas[i];
            }
        }
        return null;
    }

    public void jogarCarta(int index) {
        cartas[index] = null;
    }
}
