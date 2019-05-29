package com.mystudio.test.systems;

import com.artemis.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mystudio.test.components.PlayerInputComponent;
import com.mystudio.test.components.PositionComponent;
import com.mystudio.test.components.SpriteComponent;
import com.mystudio.test.components.TargetComponent;
import org.mini2Dx.core.graphics.Sprite;
import org.mini2Dx.core.graphics.viewport.FitViewport;

public class PlayerInputSystem extends InterpolatingEntitySystem implements InputProcessor {

    private ComponentMapper<PlayerInputComponent> mPlayer;
    private ComponentMapper<PositionComponent> mPosition;
    private ComponentMapper<TargetComponent> mTarget;
    private ComponentMapper<SpriteComponent> mSprite;

    private int playerID = 5;

    private FitViewport fitViewport;


    public PlayerInputSystem() {
        super(Aspect.all(PositionComponent.class, PlayerInputComponent.class));
    }

    @Override
    protected void update(int entityId, float delta) {
        playerID = entityId;
        PlayerInputComponent playerInput = mPlayer.get(playerID);

        if (playerInput.isMovingLeft()) mPosition.get(playerID).getPoint().add(-1,0);
        if (playerInput.isMovingRight()) mPosition.get(playerID).getPoint().add(1,0);
        if (playerInput.isMovingUp()) mPosition.get(playerID).getPoint().add(0,-1);
        if (playerInput.isMovingDown()) mPosition.get(playerID).getPoint().add(0,1);

    }

    @Override
    protected void interpolate(int entityId, float alpha) {

    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                mPlayer.get(playerID).setMovingUp(true);
                break;
            case Input.Keys.A:
                mPlayer.get(playerID).setMovingLeft(true);
                break;
            case Input.Keys.S:
                mPlayer.get(playerID).setMovingDown(true);
                break;
            case Input.Keys.D:
                mPlayer.get(playerID).setMovingRight(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                mPlayer.get(playerID).setMovingUp(false);
                break;
            case Input.Keys.A:
                mPlayer.get(playerID).setMovingLeft(false);
                break;
            case Input.Keys.S:
                mPlayer.get(playerID).setMovingDown(false);
                break;
            case Input.Keys.D:
                mPlayer.get(playerID).setMovingRight(false);
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        int fireball = getWorld().create();
        Vector2 vector2 = new Vector2();
        fitViewport.toWorldCoordinates(vector2,screenX,screenY);
        mPosition.create(fireball).getPoint().set(vector2);
        mTarget.create(fireball).getPoint().set(300,200);
        mSprite.create(fireball).setSprite(new Sprite(new Texture("fireball.png")));


        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }


    public void setFitViewport(FitViewport fitViewport) {
        this.fitViewport = fitViewport;
    }
}
