package io.github.antoniosrt;

public class Jogador {
    private String nome;
    private int[] vitorias = {0, 0, 0};
    private int[] derrotas = {0, 0, 0};
    private int[] empates = {0, 0, 0};
    private Boolean jogadaTurno = false;

    private MaoJogador Mao;

    private Baralho baralho;

    public Jogador(String nome) {
        this.nome = nome;
        this.baralho = new Baralho();
    }

    public void selecionarCarta(int indexCarta) {
        this.Mao.jogarCarta(indexCarta);
    }

    public String getNome() {
        return nome;
    }


    public void iniciarJogo() {
        baralho.embaralharCartas();
        this.Mao = new MaoJogador();
        this.Mao.encherMao(baralho);
        System.out.println("Mão do jogador " + this.nome + ": Quantidade de cartas: " + this.Mao.getTotalCartas());
    }

    public void comprarCarta() {
        this.Mao.comprarCarta(baralho);
    }

    public Carta[] getCartas() {
        return this.Mao.getCartas();
    }
    public MaoJogador getMao(){
        return this.Mao;
    }

    public void setJogada(Boolean jogada){
        this.jogadaTurno = jogada;
    }
    public Boolean getJogada(){
        return this.jogadaTurno;
    }
}
