package io.github.antoniosrt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class PartidaScreen implements Screen {
    private final Main game;
    private SpriteBatch batch;
    private Texture image, image_questao, correto, errado;
    private BitmapFont font;
    private Partida partida;
    private boolean cartasSelecionadas = false;
    private boolean cartasRenderizadas = false;
    private boolean powerup1=true, powerup2=true;
    private long tempoDeEspera;
    private int quiz=0;
    private Botao  botaoP1, botaoP2;

    private Questao questao;
    private Botao BotaoA, BotaoB, BotaoC, BotaoD;
    private int[] vetorquest = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int[] resp_corretas = {3, 0, 2, 1, 3, 3, 2, 3, 1};
    private int n_quest, respcorreta;
    private String TexturePath = ("QUIZ/");

    public PartidaScreen(Main game, int classe) {
        this.game = game;
        batch = new SpriteBatch();
        image = new Texture("playmat.png");
        font = new BitmapFont();

        botaoP2 = new Botao("powerupbuttons/theyon.png",120,60);
        botaoP2.setButtonX(300);
        botaoP2.setButtonY(-120);
        botaoP1 = new Botao("powerupbuttons/ouron.png",120,60);
        botaoP1.setButtonX(-250);
        botaoP1.setButtonY(-20);

        Random random = new Random();
        n_quest = random.nextInt(vetorquest.length);
        TexturePath = TexturePath + n_quest + ".png";
        respcorreta = resp_corretas[n_quest-1];

        questao = new Questao(n_quest,respcorreta,TexturePath);
        image_questao = new Texture(TexturePath);
        correto = new Texture("correto.png");
        errado = new Texture("errado.png");

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

        if (powerup1){
            batch.draw(botaoP1.getButtonTexture(), botaoP1.getButtonX(), botaoP1.getButtonY(), botaoP1.getButtonWidth(), botaoP1.getButtonHeight());
        } else {
            quiz=0;
            botaoP1.setButtonTexture("powerupbuttons/ouroff.png");
            batch.draw(botaoP1.getButtonTexture(), botaoP1.getButtonX(), botaoP1.getButtonY(), botaoP1.getButtonWidth(), botaoP1.getButtonHeight());
        }
        if (powerup2){
            batch.draw(botaoP2.getButtonTexture(), botaoP2.getButtonX(), botaoP2.getButtonY(), botaoP2.getButtonWidth(), botaoP2.getButtonHeight());
        } else {
            botaoP1.setButtonTexture("powerupbuttons/theyoff.png");
            batch.draw(botaoP2.getButtonTexture(), botaoP2.getButtonX(), botaoP2.getButtonY(), botaoP2.getButtonWidth(), botaoP2.getButtonHeight());
        }

        if (quiz == 1){
            batch.draw(image_questao, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.draw(BotaoA.getButtonTexture(), BotaoA.getButtonX(), BotaoA.getButtonY(), BotaoA.getButtonWidth(), BotaoA.getButtonHeight());
            batch.draw(BotaoB.getButtonTexture(), BotaoB.getButtonX(), BotaoB.getButtonY(), BotaoB.getButtonWidth(), BotaoB.getButtonHeight());
            batch.draw(BotaoC.getButtonTexture(), BotaoC.getButtonX(), BotaoC.getButtonY(), BotaoC.getButtonWidth(), BotaoC.getButtonHeight());
            batch.draw(BotaoD.getButtonTexture(), BotaoD.getButtonX(), BotaoD.getButtonY(), BotaoD.getButtonWidth(), BotaoD.getButtonHeight());
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

        if (Gdx.input.justTouched() && powerup1) {
            quiz=1;
            botaoP1.setButtonTexture("powerupbuttons/ouroff.png");
            if (BotaoA.detectaClique()) {
                if (respcorreta==0){
                    batch.draw(correto, 0, 0, 160, 80);
                } else {
                    batch.draw(errado, 0, 0, 160, 80);
                    powerup1 = false;
                }
                dispose();
            }

            if (BotaoB.detectaClique()) {
                if (respcorreta==1){
                    batch.draw(correto, 0, 0, 160, 80);
                } else {
                    batch.draw(errado, 0, 0, 160, 80);
                    powerup1 = false;
                }
                dispose();
            }

            if (BotaoC.detectaClique()) {
                if (respcorreta==2){
                    batch.draw(correto, 0, 0, 160, 80);
                } else {
                    batch.draw(errado, 0, 0, 160, 80);
                    powerup1 = false;
                }
                dispose();
            }

            if (BotaoD.detectaClique()) {
                if (respcorreta==3){
                    batch.draw(correto, 0, 0, 160, 80);
                } else {
                    batch.draw(errado, 0, 0, 160, 80);
                    powerup1 = false;
                }
                dispose();
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
        image_questao.dispose();
        BotaoA.dispose();
        BotaoB.dispose();
        BotaoC.dispose();
        BotaoD.dispose();
        botaoP1.dispose();
        botaoP2.dispose();
    }
}
