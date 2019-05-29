package com.mystudio.test.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.InterpolatingEntitySystem;
import com.artemis.annotations.Wire;
import com.badlogic.gdx.Gdx;
import com.mystudio.test.components.PositionComponent;
import com.mystudio.test.components.VelocityComponent;

@Wire
public class MoveEntitySystem extends InterpolatingEntitySystem {

    private ComponentMapper<PositionComponent> positionMapper;
    private ComponentMapper<VelocityComponent> velocityMapper;

    public MoveEntitySystem() {
        super(Aspect.all(PositionComponent.class));
    }

    @Override
    protected void update(int e, float delta) {
        PositionComponent positionComponent = positionMapper.get(e);
        positionComponent.getPoint().preUpdate();
    }

    @Override
    protected void interpolate(int e, float alpha) {
        PositionComponent positionComponent = positionMapper.get(e);
        positionComponent.getPoint().interpolate(null, alpha);
    }


}