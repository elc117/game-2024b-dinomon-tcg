package io.github.antoniosrt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.ScreenUtils;

public class Help implements Screen {
    private final Main game;
    private SpriteBatch batch;
    private Texture gameImage;
    private Botao botaoBack;

    public Help(Main game) {
        this.game = game;
        batch = new SpriteBatch();
        gameImage = new Texture("help.png");

        botaoBack = new Botao("helpback.png", 80, 80);
        botaoBack.setButtonY(-180);
        botaoBack.setButtonX(260);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1f);
        batch.begin();
        batch.draw(gameImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(botaoBack.getButtonTexture(), botaoBack.getButtonX(), botaoBack.getButtonY(), botaoBack.getButtonWidth(), botaoBack.getButtonHeight());
        batch.end();

        if (botaoBack.detectaClique()){
            game.setScreen(new MenuScreen(game));
            dispose();
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
        gameImage.dispose();
        botaoBack.getButtonTexture().dispose();
    }
}
