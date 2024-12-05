package io.github.antoniosrt;

public class Baralho {

    private int totalCartas = 10;
    private Carta[] cartas;

    public void Baralho(){
        cartas = new Carta[totalCartas];
        int i = 0;
        //0 - vento 1 - agua 2 - terra
        for (int tipo = 0; tipo < 3; tipo++) {
            for (int valor = 1; valor < 10; valor++) {
                cartas[i] = new Carta(tipo,valor,i,"core/assets/carta"+tipo+valor+".png");
                i++;
            }
        }
    }

    public Carta retirarCarta(){

        this.totalCartas--;
        Carta cartaTopo = cartas[totalCartas];
        return cartaTopo;
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
