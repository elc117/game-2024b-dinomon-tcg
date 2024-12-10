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
    private long tempoDeEspera = 0;

    public PartidaScreen(Main game, int classe) {
        this.game = game;
        batch = new SpriteBatch();
        image = new Texture(Gdx.files.internal("playmat.png"));
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

        // Renderizar as cartas jogadas no meio do tabuleiro se ambas foram selecionadas
        if (cartasSelecionadas && cartasRenderizadas) {
            Carta cartaJogada1 = partida.getJogador1().getMao().getCartaJogada();
            Carta cartaJogada2 = partida.getJogador2().getMao().getCartaJogada();
            if (cartaJogada1 != null) {
                batch.draw(cartaJogada1.getTexture(), Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 100, cartaJogada1.getWidth(), cartaJogada1.getHeight());
            }
            if (cartaJogada2 != null) {
                batch.draw(cartaJogada2.getTexture(), Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 + 50, cartaJogada2.getWidth(), cartaJogada2.getHeight());
            }
        }

        // Renderizar as cartas da mão do jogador 1
        for (int i = 0; i < 3; i++) {
            // Adicionar os pontos de vitória na tela do jogador 1
            font.draw(batch, partida.getJogador1().getPontosVitoria(i), 55 + i * 90, -yFim);
            // Adicionar os pontos de vitória na tela do jogador 2
            font.draw(batch, partida.getJogador2().getPontosVitoria(i), Gdx.graphics.getWidth() - 240 + i * 90, Gdx.graphics.getHeight() - 200);
            // Adicionar as cartas na mão do jogador
            Carta carta = partida.getJogador1().getCartas()[i];
            if (carta != null) {
                float xCarta = x + i * 140;
                float yCarta = 15;
                batch.draw(carta.getTexture(), x + i * 140, yCarta, carta.getWidth(), carta.getHeight());
                carta.setCartaX(xCarta);
                carta.setCartaY(yCarta);
            }
        }
        batch.end();

        partida.setJogadaTurno(partida.validarJogadas());
        if (!partida.getJogada()) {
            // Atualizar o tempo restante do turno
            partida.updateTurnTime(delta);
        } else {
            System.out.println("Jogadas válidas");
            if (cartasRenderizadas && (System.currentTimeMillis() - tempoDeEspera) >= 3000) {
                try {
                    // Aguarde 3 segundos antes de calcular o dano
                    int resultado = partida.combate();
                    if(resultado == 1){
//                        game.setScreen(new VitoriaScreen(game, "Jogador 1"));
                    }
                    if(resultado == 2){
//                        game.setScreen(new DerrotaScreen(game, "Jogador 1"));
                    }
                    cartasSelecionadas = false;
                    cartasRenderizadas = false;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
                if (cartasSelecionadas) {
                    tempoDeEspera = System.currentTimeMillis();
                    cartasRenderizadas = true;
                }
            }
        }
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
