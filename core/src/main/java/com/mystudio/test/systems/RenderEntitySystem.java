package com.mystudio.test.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.RenderingEntitySystem;
import com.mystudio.test.components.PositionComponent;
import com.mystudio.test.components.SpriteComponent;
import org.mini2Dx.core.graphics.Graphics;

public class RenderEntitySystem extends RenderingEntitySystem {

    private ComponentMapper<SpriteComponent> spriteMapper;
    private ComponentMapper<PositionComponent> positionMapper;

    public RenderEntitySystem() {
        super(Aspect.all(SpriteComponent.class, PositionComponent.class));
    }


    @Override
    protected void render(int entityId, Graphics g) {
        g.drawSprite(spriteMapper.get(entityId).getSprite(),
                positionMapper.get(entityId).getPoint().x,
                positionMapper.get(entityId).getPoint().y);
    }


}
