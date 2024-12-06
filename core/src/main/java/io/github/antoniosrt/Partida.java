package io.github.antoniosrt;

public class Partida {
    private Jogador jogador1;
    private Jogador jogador2;
    private int turno;
    private float timeLeft; // Tempo restante para o turno

    private Boolean jogadaTurno = false;

    public Partida(String nomeJogador1, String nomeJogador2) {
        this.jogador1 = new Jogador(nomeJogador1);
        this.jogador2 = new Jogador(nomeJogador2);
        this.turno = 1;
        this.timeLeft = 30.0f; // 30 segundos para cada turno
        jogador1.iniciarJogo();
        jogador2.iniciarJogo();
    }

    public void updateTurnTime(float delta) {
        timeLeft -= delta;
        if (timeLeft <= 0) {
            endTurn();
        }
        System.out.println("Tempo restante: " + timeLeft);
    }

    public void startTurn() {
        timeLeft = 30.0f; // Reiniciar o tempo do turno
    }

    private void endTurn() {
        if (getJogada()) {
            return;
        }
        turno++;
        startTurn(); // Iniciar próximo turno
    }

    public float getTimeLeft() {
        return timeLeft;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public Boolean getJogada() {
        return jogadaTurno;
    }

    public void validarJogadas() {
        //validar jogadas
        if ((jogador1.getMao().getTotalCartas() == 2 && jogador1.getJogada()) && (jogador2.getJogada() && jogador2.getMao().getTotalCartas() == 2)) {
            jogadaTurno = true;
        }
        jogadaTurno = false;
    }
}
