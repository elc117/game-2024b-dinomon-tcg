package io.github.antoniosrt;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class TelaQuestao implements Screen {
    private final Main game;
    private Texture image;
    private SpriteBatch batch;
    private Questao questao;
    private Botao BotaoA, BotaoB, BotaoC, BotaoD;
    private int[] vetorquest = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int[] resp_corretas = {3, 0, 2, 1, 3, 3, 2, 3, 1};
    private int n_quest, respcorreta;
    private String TexturePath = ("QUIZ/");

    public TelaQuestao(Main game) {
        this.game = game;
        batch = new SpriteBatch();

        Random random = new Random();
        n_quest = random.nextInt(vetorquest.length);
        TexturePath = TexturePath + n_quest + ".png";
        respcorreta = resp_corretas[n_quest-1];

        questao = new Questao(n_quest,respcorreta,TexturePath);
        image = new Texture(TexturePath);

        BotaoA = new Botao("botoesquiz/4.png", 80, 80);
        BotaoA.setButtonY(200);
        BotaoA.setButtonX((Gdx.graphics.getWidth() - BotaoA.getButtonWidth()) / 2);

        BotaoB = new Botao("botoesquiz/5.png", 80, 80);
        BotaoB.setButtonY(200);
        BotaoB.setButtonX(50);
        BotaoB.setButtonX((Gdx.graphics.getWidth() - BotaoB.getButtonWidth()) / 2);

        BotaoC = new Botao("botoesquiz/6.png", 80, 80);
        BotaoC.setButtonY(100);
        BotaoC.setButtonX((Gdx.graphics.getWidth() - BotaoC.getButtonWidth()) / 2);

        BotaoD = new Botao("botoesquiz/7.png", 80, 80);
        BotaoD.setButtonY(100);
        BotaoD.setButtonX(50);
        BotaoD.setButtonX((Gdx.graphics.getWidth() - BotaoD.getButtonWidth()) / 2);
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
        batch.draw(BotaoA.getButtonTexture(), BotaoA.getButtonX(), BotaoA.getButtonY(), BotaoA.getButtonWidth(), BotaoA.getButtonHeight());
        batch.draw(BotaoB.getButtonTexture(), BotaoB.getButtonX(), BotaoB.getButtonY(), BotaoB.getButtonWidth(), BotaoB.getButtonHeight());
        batch.draw(BotaoC.getButtonTexture(), BotaoC.getButtonX(), BotaoC.getButtonY(), BotaoC.getButtonWidth(), BotaoC.getButtonHeight());
        batch.draw(BotaoD.getButtonTexture(), BotaoD.getButtonX(), BotaoD.getButtonY(), BotaoD.getButtonWidth(), BotaoD.getButtonHeight());
        batch.end();

        if (Gdx.input.justTouched()) {
            if (BotaoA.detectaClique()) {
                if (respcorreta==0){
                    //acertou
                } else {
                    //errou
                }
                dispose();
            }

            if (BotaoB.detectaClique()) {
                if (respcorreta==1){
                    //acertou
                } else {
                    //errou
                }
                dispose();
            }

            if (BotaoC.detectaClique()) {
                if (respcorreta==2){
                    //acertou
                } else {
                    //errou
                }
                dispose();
            }

            if (BotaoD.detectaClique()) {
                if (respcorreta==3){
                    //acertou
                } else {
                    //errou
                }
                dispose();
            }

        }
    }

    @Override
    public void resize(int width, int height) {
        // Redimensiona
    }

    @Override
    public void pause() {
        // Lida com pausa
    }

    @Override
    public void resume() {
        // Lida com retomada
    }

    @Override
    public void hide() {
        // Libera recursos se necessário
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        BotaoA.dispose();
        BotaoB.dispose();
        BotaoC.dispose();
        BotaoD.dispose();
    }
}
