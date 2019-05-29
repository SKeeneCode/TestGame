package com.mystudio.test.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.InterpolatingEntitySystem;
import com.artemis.annotations.Wire;
import com.mystudio.test.components.PositionComponent;
import com.mystudio.test.components.SpriteComponent;
import com.mystudio.test.components.TargetComponent;
import com.mystudio.test.components.VelocityComponent;
import org.mini2Dx.core.engine.geom.CollisionPoint;

@Wire
public class TrackingSystem extends InterpolatingEntitySystem {

    private ComponentMapper<PositionComponent> positionMapper;
    private ComponentMapper<TargetComponent> targetMapper;
    private ComponentMapper<SpriteComponent> mSprite;

    public TrackingSystem() {
        super(Aspect.all(PositionComponent.class, TargetComponent.class, SpriteComponent.class));
    }

    @Override
    protected void update(int e, float delta) {
        PositionComponent positionComponent = positionMapper.get(e);
        TargetComponent targetComponent = targetMapper.get(e);

        positionComponent.getPoint().moveTowards(targetComponent.getPoint(),2);

        CollisionPoint target = targetComponent.getPoint();
        if (positionComponent.getPoint().getDistanceTo(target.x,target.y) < 5) {
            mSprite.remove(e);
        }
    }

    @Override
    protected void interpolate(int e, float alpha) {
    }


}