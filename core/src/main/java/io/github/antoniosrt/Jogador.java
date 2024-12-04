package io.github.antoniosrt;

public class Jogador {
    private String nome;
    private int pontos;
    private int vitorias;
    private int derrotas;
    private int empates;

    private Carta[] Mao;

    private Baralho baralho;
    public Jogador(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.baralho = new Baralho();
    }

    public void selecionarCarta(int indexCarta) {
        this.baralho.jogarCarta(indexCarta);
    }
    public String getNome() {
        return nome;
    }


    public void adicionarVitoria() {
        this.vitorias++;
        this.pontos += 3;
    }

    public void adicionarDerrota() {
        this.derrotas++;
    }

    public void adicionarEmpate() {
        this.empates++;
        this.pontos++;
    }
}
