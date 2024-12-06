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

    public PartidaScreen(Main game) {
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
        batch.begin();
        batch.draw(image, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        font.draw(batch, "Tempo restante: " + (int) partida.getTimeLeft(), Gdx.graphics.getWidth() - 180, yMeio);
        //desenha as cartas do jogador 1
        for (int i = 0; i < partida.getJogador1().getMao().getTotalCartas(); i++) {
            Carta carta = partida.getJogador1().getCartas()[i];
            if (carta != null) {
                //achar o meio da tela
                batch.draw(carta.getTexture(), x + i * 140, 15, 120, 160);
                System.out.println("Carta " + i + ": Elemento = " + carta.getElemento() + ", Texture = " + carta.getTexture());
            }
        }
        batch.end();
        partida.validarJogadas();
        if (!partida.getJogada()) {
            // Atualizar o tempo restante do turno
            partida.updateTurnTime(delta);
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
