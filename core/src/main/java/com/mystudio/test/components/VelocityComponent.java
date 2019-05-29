package com.mystudio.test.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;
import org.mini2Dx.core.engine.geom.CollisionPoint;

public class VelocityComponent extends Component {

    private Vector2 velocity = new Vector2(0,0);

    public VelocityComponent() {

    }
    public Vector2 getVelocity() {
        return velocity;
    }
}
