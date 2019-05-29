package com.mystudio.test.components;

import com.artemis.Component;
import org.mini2Dx.core.engine.geom.CollisionPoint;

public class TargetComponent extends Component {

    private CollisionPoint point;

    public TargetComponent() {
        point = new CollisionPoint();
    }

    public CollisionPoint getPoint() {
        return point;
    }
}
