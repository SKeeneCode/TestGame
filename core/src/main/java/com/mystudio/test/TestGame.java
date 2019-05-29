package com.mystudio.test;

import com.artemis.Entity;
import com.artemis.MdxWorld;
import com.artemis.WorldConfiguration;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mystudio.test.components.PlayerInputComponent;
import com.mystudio.test.components.PositionComponent;
import com.mystudio.test.components.SpriteComponent;
import com.mystudio.test.systems.MoveEntitySystem;
import com.mystudio.test.systems.PlayerInputSystem;
import com.mystudio.test.systems.RenderEntitySystem;
import com.mystudio.test.systems.TrackingSystem;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.game.GameResizeListener;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import org.mini2Dx.core.graphics.viewport.FitViewport;
import org.mini2Dx.tiled.TiledMap;

public class TestGame extends BasicGame implements GameResizeListener {
	public static final String GAME_IDENTIFIER = "com.mystudio.test";

    private TiledMap tiledMap;
    private FitViewport viewport;
    private MdxWorld world;
    private float WIDTH = 32*16;
    private float HEIGHT = 18*16;
    private int i = 13;
	
	@Override
    public void initialise() {
        WorldConfiguration worldConfiguration = new WorldConfiguration();
        worldConfiguration.setSystem(new MoveEntitySystem());
        worldConfiguration.setSystem(new RenderEntitySystem());
        PlayerInputSystem playerInputSystem = new PlayerInputSystem();
        worldConfiguration.setSystem(playerInputSystem);
        worldConfiguration.setSystem(new TrackingSystem());

        world = new MdxWorld(worldConfiguration);
        viewport = new FitViewport(WIDTH,HEIGHT);

        playerInputSystem.setFitViewport(viewport);

        int player = world.create();
        Entity me = world.getEntity(player);

        me.edit().add(new PositionComponent());
        me.edit().add(new PlayerInputComponent());
        me.edit().add(new SpriteComponent(new Sprite(new Texture("mini2Dx.png"))));

        addResizeListener(this);

        try {
            tiledMap = new TiledMap(Gdx.files.internal("map.tmx"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(new UIInputProcessor());
        multiplexer.addProcessor(playerInputSystem);
        Gdx.input.setInputProcessor(multiplexer);

    }


    @Override
    public void update(float delta) {
        world.setDelta(delta);
        world.process();
        tiledMap.update(delta);
    }
    
    @Override
    public void interpolate(float alpha) {
        world.setAlpha(alpha);
        world.interpolate();
    }
    
    @Override
    public void render(Graphics g) {
        viewport.apply(g);
        tiledMap.draw(g, 0, 0);
        world.render(g);
    }

    @Override
    public void onResize(int width, int height) {
	    if (width < 320 || height < 180) {
	        Gdx.graphics.setWindowedMode(320,180);
        }
    }
}
