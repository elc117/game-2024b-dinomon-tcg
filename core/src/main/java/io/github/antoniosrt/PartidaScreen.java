package io.github.antoniosrt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PartidaScreen implements Screen {
    private final Main game;
    private SpriteBatch batch;
    private Texture image;
    private BitmapFont font;
    private Partida partida;
    private boolean cartasSelecionadas = false;
    private boolean cartasRenderizadas = false;
    private long tempoDeEspera;
    public PartidaScreen(Main game, int classe) {
        this.game = game;
        batch = new SpriteBatch();
        image = new Texture("playmat.png");
        font = new BitmapFont();
        iniciarPartida();
    }

    public void iniciarPartida() {
        this.partida = new Partida("Jogador 1", "Jogador 2");
        partida.startTurn();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        int x = Gdx.graphics.getWidth() / 2 - 180;
        int yMeio = Gdx.graphics.getHeight() / 2 + 70;
        int yFim = -Gdx.graphics.getHeight() + (Gdx.graphics.getHeight() - 100);
        batch.begin();
        batch.draw(image, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        font.draw(batch, "Tempo restante: " + (int) partida.getTimeLeft(), Gdx.graphics.getWidth() - 180, yMeio);
        font.draw(batch, "Turno: " + partida.getTurno(), Gdx.graphics.getWidth() - 180, yMeio - 20);

        // Renderizar as cartas jogadas no meio do tabuleiro
        if (cartasSelecionadas && !cartasRenderizadas) {
            if (partida.getJogador1().getJogada()) {
                Carta cartaJogada1 = partida.getJogador1().getMao().getCartaJogada();
                batch.draw(cartaJogada1.getTexture(), Gdx.graphics.getWidth() / 2 - cartaJogada1.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 200, cartaJogada1.getWidth(), cartaJogada1.getHeight());
            }
            if (partida.getJogador2().getJogada()) {
                Carta cartaJogada2 = partida.getJogador2().getMao().getCartaJogada();
                batch.draw(cartaJogada2.getTexture(), Gdx.graphics.getWidth() / 2 - cartaJogada2.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 50, cartaJogada2.getWidth(), cartaJogada2.getHeight());
            }
        }
        //desenha as cartas do jogador 1
        for (int i = 0; i < 3; i++) {
            //adiciona os pontos de vitoria na tela jogador 1
            font.draw(batch, partida.getJogador1().getPontosVitoria(i), 55 + i * 90, -yFim);
            //adiciona os pontos de vitoria na tela jogador 2
            font.draw(batch, partida.getJogador2().getPontosVitoria(i), Gdx.graphics.getWidth() - 240 + i * 90, Gdx.graphics.getHeight() - 200);
            //adiciona as cartas na mao do jogador
            Carta carta = partida.getJogador1().getCartas()[i];
            if (carta != null) {
                float xCarta = x + i * 140;
                float yCarta = 15;
                //achar o meio da tela
                batch.draw(carta.getTexture(), x + i * 140, yCarta, carta.getWidth(), carta.getHeight());
                carta.setCartaX(xCarta);
                carta.setCartaY(yCarta);
//                System.out.println("Carta " + i + ": Elemento = " + carta.getElemento() + ", Texture = " + carta.getTexture());
            }
        }
        batch.end();
        partida.validarJogadas();
        if (!partida.getJogada()) {
            // Atualizar o tempo restante do turno
            partida.updateTurnTime(delta);
        } else {
            try {
                // Aguarde 3 segundos antes de calcular o dano
                partida.combate();
                cartasSelecionadas = false;
                cartasRenderizadas = false;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < partida.getJogador1().getMao().getTotalCartas(); i++) {
            Carta carta = partida.getJogador1().getCartas()[i];
            if (carta == null) {
                continue;
            }
            if (carta.detectaClique()) {
                System.out.println("Clique na carta " + i);
                partida.getJogador1().selecionarCarta(i);
                partida.getJogador2().selecionarCarta(i);
                cartasSelecionadas = partida.getJogador1().getJogada() && partida.getJogador2().getJogada();

            }
        }


    }
        public static Boolean manualSleep(long millis) {
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < millis) {
                // Loop vazio para "dormir"
            }
            return true;
        }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        font.dispose();
    }
}
