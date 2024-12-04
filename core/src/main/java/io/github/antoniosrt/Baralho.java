package io.github.antoniosrt;

public class Baralho {

    private int totalCartas = 10;
    private Carta[] cartas;

    public void Baralho(){
        cartas = new Carta[totalCartas];
        int i = 0;
        for (int tipo = 0; tipo < 3; tipo++) {
            for (int valor = 1; valor < 4; valor++) {
                cartas[i] = new Carta(valor, tipo);
                i++;
            }
        }
    }

    public Carta retirarCarta(){
        int i = (int) (Math.random() * 10);
        Carta carta = cartas[i];
        cartas[i] = null;
        this.totalCartas--;
        return carta;
    }

    public Carta[] embaralharCartas(){
        Carta[] cartasEmbaralhadas = new Carta[10];
        int[] indicesJaUtilizados = new int[10];
        for (int i = 0; i < 10; i++) {
            int indiceAleatorioCarta = (int) (Math.random() * 10);
            while (indicesJaUtilizados[indiceAleatorioCarta] == 1) {
                indiceAleatorioCarta = (int) (Math.random() * 10);
            }
            indicesJaUtilizados[indiceAleatorioCarta] = 1;
            cartasEmbaralhadas[indiceAleatorioCarta] = retirarCarta();
        }

        return cartasEmbaralhadas;
    }

    public void jogarCarta(int indexCarta){
        cartas[indexCarta] = null;
        this.totalCartas--;
    }
    public int getTotalCartas(){
        return this.totalCartas;
    }


}
