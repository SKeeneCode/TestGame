package com.mystudio.test.components;

import com.artemis.Component;
import org.mini2Dx.core.graphics.Sprite;

public class SpriteComponent extends Component {

    private Sprite sprite;

    public SpriteComponent() {
    }

    public SpriteComponent(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
