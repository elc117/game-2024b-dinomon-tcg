package io.github.antoniosrt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SelecaoScreen implements Screen {
    private final Main game;
    private SpriteBatch batch;
    private Texture image;
    private Botao botaoFacil, botaoDificil, botaoCarn, botaoHerb, botaoVen, botaoBack;
    private int carn,herb,ven;

    public SelecaoScreen(Main game) {
        this.game = game;
        batch = new SpriteBatch();
        image = new Texture("selectmenu.png");

        botaoFacil = new Botao("botaofacil.png", 140, 70);
        botaoFacil.setButtonY(320);
        botaoFacil.setButtonX(-150);
        botaoDificil = new Botao("botaodificil.png", 140, 70);
        botaoDificil.setButtonY(320);
        botaoDificil.setButtonX(150);

        botaoBack = new Botao("helpback.png", 80, 80);
        botaoBack.setButtonY(-350);
        botaoBack.setButtonX(400);

        botaoCarn = new Botao("classes/1.png", 300, 160);
        botaoCarn.setButtonY(-120);
        botaoCarn.setButtonX(-350);
        botaoCarn.setSelected(1);

        botaoHerb = new Botao("classes/2.png", 300, 160);
        botaoHerb.setButtonY(-120);
        botaoHerb.setButtonX(0);

        botaoVen = new Botao("classes/3.png", 300, 160);
        botaoVen.setButtonY(-120);
        botaoVen.setButtonX(350);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(botaoFacil.getButtonTexture(), botaoFacil.getButtonX(), botaoFacil.getButtonY(), botaoFacil.getButtonWidth(), botaoFacil.getButtonHeight());
        batch.draw(botaoDificil.getButtonTexture(), botaoDificil.getButtonX(), botaoDificil.getButtonY(), botaoDificil.getButtonWidth(), botaoDificil.getButtonHeight());
        batch.draw(botaoCarn.getButtonTexture(), botaoCarn.getButtonX(), botaoCarn.getButtonY(), botaoCarn.getButtonWidth(), botaoCarn.getButtonHeight());
        batch.draw(botaoHerb.getButtonTexture(), botaoHerb.getButtonX(), botaoHerb.getButtonY(), botaoHerb.getButtonWidth(), botaoHerb.getButtonHeight());
        batch.draw(botaoVen.getButtonTexture(), botaoVen.getButtonX(), botaoVen.getButtonY(), botaoVen.getButtonWidth(), botaoVen.getButtonHeight());
        batch.draw(botaoBack.getButtonTexture(), botaoBack.getButtonX(), botaoBack.getButtonY(), botaoBack.getButtonWidth(), botaoBack.getButtonHeight());
        batch.end();

       /* if (botaoFacil.detectaClique()) {
            game.setScreen(new Help(game));
            dispose();
        }

        if (botaoDificil.detectaClique()) {
            game.setScreen(new Colecao(game));
            dispose();
        }*/
        if (botaoBack.detectaClique()){
            game.setScreen(new MenuScreen(game));
            dispose();
        }
        if (botaoCarn.detectaClique()){
            carn = botaoCarn.getSelected();
            if (carn == 0){
                botaoCarn.setButtonTexture("classes/4.png");
                botaoCarn.setSelected(1);
            } else {
                botaoCarn.setButtonTexture("classes/1.png");
                botaoCarn.setSelected(0);
            }
        }

        if (botaoHerb.detectaClique()){
            herb = botaoHerb.getSelected();
            if (herb == 0){
                botaoHerb.setButtonTexture("classes/5.png");
                botaoHerb.setSelected(1);
            } else {
                botaoHerb.setButtonTexture("classes/2.png");
                botaoHerb.setSelected(0);
            }
        }

        if (botaoVen.detectaClique()){
            ven = botaoVen.getSelected();
            if (ven == 0){
                botaoVen.setButtonTexture("classes/6.png");
                botaoVen.setSelected(1);
            } else {
                botaoVen.setButtonTexture("classes/3.png");
                botaoVen.setSelected(0);
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
        botaoFacil.getButtonTexture().dispose();
        botaoDificil.getButtonTexture().dispose();
        //botaoCartas.getButtonTexture().dispose();
    }
}
