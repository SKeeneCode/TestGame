package com.mystudio.test.components;

import com.artemis.Aspect;
import com.artemis.Component;
import com.badlogic.gdx.InputProcessor;
import org.mini2Dx.core.engine.geom.CollisionPoint;

public class PlayerInputComponent extends Component{

    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }
}
