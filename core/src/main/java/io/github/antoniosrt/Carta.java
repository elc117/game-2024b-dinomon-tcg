package io.github.antoniosrt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Carta {
    private int elemento;
    private int valor;
    private int id;
    private Texture texture;
    private String texturePath;
    public Carta(int elemento, int valor, int id, String texturePath){
        this.elemento = elemento;
        this.valor = valor;
        this.id = id;
        this.texturePath = texturePath;
        this.texture = new Texture(Gdx.files.internal(texturePath));
    }

    public int getElemento() {
        return elemento;
    }

    public Texture getTexture() {
        return texture;
    }
    public String getTexturePath() {
        return texturePath;
    }
}
