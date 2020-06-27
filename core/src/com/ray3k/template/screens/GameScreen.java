package com.ray3k.template.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crashinvaders.vfx.effects.EarthquakeEffect;
import com.dongbat.jbump.Item;
import com.dongbat.jbump.World;
import com.ray3k.template.*;
import com.ray3k.template.OgmoReader.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.steering.*;
import com.ray3k.template.screens.DialogPause.*;
import com.sun.source.tree.CaseTree;
import space.earlygrey.shapedrawer.ShapeDrawer;

import static com.ray3k.template.Core.*;

public class GameScreen extends JamScreen {
    public static GameScreen gameScreen;
    public static final Color BG_COLOR = new Color();
    public static SkinName player1Skin, player2Skin;
    public Stage stage;
    public ShapeDrawer shapeDrawer;
    public EntityController entityController;
    private EarthquakeEffect vfxEffect;
    public boolean paused;
    public static CameraEntity cameraEntity;
    public static World<Entity> hitBoxWorld;
    public BackgroundEntity backgroundEntity;
    
    public GameScreen() {
        gameScreen = this;
        vfxEffect = new EarthquakeEffect();
        vfxEffect.setAmount(0);
        vfxEffect.rebind();
        
        BG_COLOR.set(Color.PINK);
    
        paused = false;
        
        stage = new Stage(new ScreenViewport(), batch);
        stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if (!paused && keycode == Keys.ESCAPE) {
                    paused = true;
                    
                    DialogPause dialogPause = new DialogPause(GameScreen.this);
                    dialogPause.show(stage);
                    dialogPause.addListener(new PauseListener() {
                        @Override
                        public void resume() {
                            paused = false;
                        }
    
                        @Override
                        public void quit() {
                            core.transition(new MenuScreen());
                        }
                    });
                }
                return super.keyDown(event, keycode);
            }
        });
        
        shapeDrawer = new ShapeDrawer(batch, skin.getRegion("white"));
        shapeDrawer.setPixelSize(.5f);
        
        InputMultiplexer inputMultiplexer = new InputMultiplexer(stage, this);
        Gdx.input.setInputProcessor(inputMultiplexer);
        
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(1024, 576, camera);
    
        vfxManager.addEffect(vfxEffect);
        
        hitBoxWorld = new World<>();
        
        entityController = new EntityController();
        
        cameraEntity = new CameraEntity();
        entityController.add(cameraEntity);
    
        backgroundEntity = new BackgroundEntity("space");
        entityController.add(backgroundEntity);
        
        var ogmoReader = new OgmoReader();
        ogmoReader.addListener(new OgmoAdapter() {
            String layerName;
            @Override
            public void level(String ogmoVersion, int width, int height, int offsetX, int offsetY,
                              ObjectMap<String, OgmoValue> valuesMap) {
                
            }
    
            @Override
            public void layer(String name, int gridCellWidth, int gridCellHeight, int offsetX, int offsetY) {
                layerName = name;
            }
    
            @Override
            public void entity(String name, int id, int x, int y, int width, int height, boolean flippedX,
                               boolean flippedY, int originX, int originY, int rotation, Array<EntityNode> nodes,
                               ObjectMap<String, OgmoValue> valuesMap) {
                if (layerName.equals("entities")) {
                    switch (valuesMap.get("index").asInt()) {
                        case 1:
                            if (player1Skin != null) {
                                var player = new PerformerEntity(player1Skin, new P1Steering(), 3);
                                player.setPosition(x, y);
                                entityController.add(player);
                            }
                            break;
                        case 2:
                            if (player2Skin != null) {
                                var player = new PerformerEntity(player2Skin, new P2Steering(), 3);
                                player.setPosition(x, y);
                                entityController.add(player);
                            }
                            break;
                    }
                } else if (layerName.equals("bbox")) {
                    if (name.equals("wall")) {
                        var wall = new WallEntity();
                        wall.setPosition(x, y);
                        wall.width = 0;
                        wall.height = 0;
                        
                        for (var node : nodes) {
                            var newWidth = node.x - x;
                            var newHeight = node.y - y;
                            
                            if (newWidth > wall.width) wall.width = newWidth;
                            if (newHeight > wall.height) wall.height = newHeight;
                        }
                        
                        entityController.add(wall);
                    } else if (name.equals("platform")) {
                        var platform = new PlatformEntity();
                        platform.setPosition(x, y);
                        platform.width = width;
                        platform.height = height;
    
                        for (var node : nodes) {
                            var newWidth = node.x - x;
                            var newHeight = node.y - y;
        
                            if (newWidth > platform.width) platform.width = newWidth;
                            if (newHeight > platform.height) platform.height = newHeight;
                        }
                        
                        entityController.add(platform);
                    }
                }
            }
    
            @Override
            public void grid(int col, int row, int x, int y, int width, int height, int id) {
            
            }
    
            @Override
            public void decal(int centerX, int centerY, float scaleX, float scaleY, int rotation, String texture, String folder) {
                var decalEntity = new DecalEntity(centerX, centerY, folder + "/" + Utils.fileName(texture));
                entityController.add(decalEntity);
            }
    
            @Override
            public void layerComplete() {
            
            }
        });
        
        ogmoReader.readFile(Gdx.files.internal("levels/stage1.json"));
    }
    
    @Override
    public void act(float delta) {
        if (!paused) {
            entityController.act(delta);
        }
        backgroundEntity.updatePosition();
        stage.act(delta);
    }
    
    @Override
    public void draw(float delta) {
        batch.setBlendFunction(GL20.GL_ONE, GL20.GL_ONE_MINUS_SRC_ALPHA);
        
        vfxManager.cleanUpBuffers();
        vfxManager.beginCapture();
        Gdx.gl.glClearColor(BG_COLOR.r, BG_COLOR.g, BG_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        entityController.draw(paused ? 0 : delta);
        
        shapeDrawer.setColor(Color.BLUE);
        shapeDrawer.rectangle(0, 0, 100, 100);
        batch.end();
        
        vfxManager.endCapture();
        vfxManager.applyEffects();
        vfxManager.renderToScreen();
    
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        stage.draw();
    }
    
    @Override
    public void resize(int width, int height) {
        if (width + height != 0) {
            vfxManager.resize(width, height);
            viewport.update(width, height);
    
            stage.getViewport().update(width, height, true);
        }
    }
    
    @Override
    public void dispose() {
        vfxEffect.dispose();
    }
    
    @Override
    public void hide() {
        super.hide();
        vfxManager.removeAllEffects();
        vfxEffect.dispose();
        backgroundEntity.dispose();
    }
}
