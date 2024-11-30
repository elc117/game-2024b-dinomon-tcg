package io.github.antoniosrt;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

public class Botao {
    private float buttonX, buttonY, buttonWidth, buttonHeight;
    private Texture buttonTexture;

    public Botao(String texturePath, float buttonWidth, float buttonHeight) {
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.buttonX = (Gdx.graphics.getWidth() - buttonWidth) / 2f;
        this.buttonY = Gdx.graphics.getHeight() / 2f - buttonHeight / 2f;
        this.buttonTexture = new Texture(Gdx.files.internal(texturePath));
    }

    public boolean detectaClique() {
        if (Gdx.input.isTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

            return touchX >= buttonX && touchX <= buttonX + buttonWidth && touchY >= buttonY && touchY <= buttonY + buttonHeight;
        }
        return false;
    }

    public void setButtonY(float offsetY) {
        this.buttonY -= offsetY;
    }

    public void setButtonX(float offsetX) {
        this.buttonX += offsetX;
    }

    public float getButtonX() {
        return buttonX;
    }

    public float getButtonY() {
        return buttonY;
    }

    public float getButtonWidth() {
        return buttonWidth;
    }

    public float getButtonHeight() {
        return buttonHeight;
    }

    public Texture getButtonTexture() {
        return buttonTexture;
    }

    public void dispose() {
        buttonTexture.dispose();
    }
}

