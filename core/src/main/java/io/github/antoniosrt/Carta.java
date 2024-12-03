package io.github.antoniosrt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Carta {
    private String elemento;
    private int valor;
    private int id;
    private Texture texture;

    public Carta(String elemento, int valor, int id, String texturePath){
        this.elemento = elemento;
        this.valor = valor;
        this.id = id;
        this.texture = new Texture(Gdx.files.internal(texturePath));
    }

    public String getElemento() {
        return elemento;
    }
}
