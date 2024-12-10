package io.github.antoniosrt;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Screen currentScreen;
    private static final int PADDING = 0;

    @Override
    public void create() {
        batch = new SpriteBatch();
        int width = Gdx.graphics.getWidth() - PADDING;
        int height = Gdx.graphics.getHeight() - PADDING;
        Gdx.graphics.setWindowedMode(width, height);
        Gdx.app.getApplicationListener().resize(width, height);
        setScreen(new MenuScreen(this));
    }

    public void setScreen(Screen screen) {
        if (currentScreen != null) {
            currentScreen.hide();
            currentScreen.dispose();
        }
        currentScreen = screen;
        if (currentScreen != null) {
            currentScreen.show();
            currentScreen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (currentScreen != null) {
            currentScreen.render(Gdx.graphics.getDeltaTime());
        }
    }

    @Override
    public void dispose() {
        if (currentScreen != null) {
            currentScreen.dispose();
        }
        batch.dispose();
    }
}
