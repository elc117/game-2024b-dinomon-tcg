package io.github.antoniosrt;

public class Jogador {
    private String nome;
    private int[] vitorias;
    private int[] derrotas;
    private int[] empates;


    private MaoJogador Mao;

    private Baralho baralho;

    public Jogador(String nome) {
        this.nome = nome;
        for (int i = 0; i < 3; i++) {
            this.vitorias[i] = 0;
            this.derrotas[i] = 0;
            this.empates[i] = 0;
        }
        this.baralho = new Baralho();
    }

    public void selecionarCarta(int indexCarta) {
        this.Mao.jogarCarta(indexCarta);
    }

    public String getNome() {
        return nome;
    }


    public void iniciarJogo(){
        this.Mao = new MaoJogador();
        for (int i = 0; i < 3; i++) {
            this.Mao.adicionarCarta(baralho.retirarCarta());
        }
    }

    public void comprarCarta(){
        this.Mao.comprarCarta(baralho);
    }

    public Carta[] getCartas(){
        return this.Mao.getCartas();
    }
}
