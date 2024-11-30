package io.github.antoniosrt;

import com.badlogic.gdx.Game;

public class Main extends Game {
    @Override
    public void create() {
        // Define a tela inicial do jogo
        this.setScreen(new MenuScreen(this));
    }

    @Override
    public void render() {
        super.render(); // Chama o render da tela atual
    }

    @Override
    public void dispose() {
        getScreen().dispose();
    }
}
