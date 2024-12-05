package io.github.antoniosrt;

public class Partida {
    private Jogador jogador1;
    private Jogador jogador2;
    private int turno;

    public Partida(String nomeJogador1, String nomeJogador2) {
        this.jogador1 = new Jogador(nomeJogador1);
        this.jogador2 = new Jogador(nomeJogador2);
        this.turno = 1;
    }
}
