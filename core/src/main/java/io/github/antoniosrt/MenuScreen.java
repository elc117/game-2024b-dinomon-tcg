package io.github.antoniosrt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen {
    private final Main game;
    private SpriteBatch batch;
    private Texture image;
    private float buttonX, buttonY, buttonWidth, buttonHeight;
    private Texture buttonTexture;

    public MenuScreen(Main game) {
        this.game = game;
        batch = new SpriteBatch();
        image = new Texture("menubg.png");

        buttonWidth = 80;
        buttonHeight = 40;
        buttonX = (Gdx.graphics.getWidth() - buttonWidth) / 2f;
        buttonY = Gdx.graphics.getHeight() / 2f - buttonHeight / 2f;
        buttonY -= 100;

        buttonTexture = new Texture(Gdx.files.internal("botaohelp.png"));
    }

    @Override
    public void show() {
        // Inicializa recursos
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch.draw(buttonTexture, buttonX, buttonY, buttonWidth, buttonHeight);
        batch.end();

        if (Gdx.input.isTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (touchX >= buttonX && touchX <= buttonX + buttonWidth &&
                touchY >= buttonY && touchY <= buttonY + buttonHeight) {
                game.setScreen(new Help(game));
                dispose();
            }
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
        // Lida com pausa
    }

    @Override
    public void resume() { // Lida com retomada
    }

    @Override
    public void hide() { // Libera recursos se necessário
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        buttonTexture.dispose();
    }
}


