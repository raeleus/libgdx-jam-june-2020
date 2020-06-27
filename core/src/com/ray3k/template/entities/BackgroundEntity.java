package com.ray3k.template.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.FloatArray;
import com.esotericsoftware.spine.AnimationStateData;
import com.ray3k.template.AnimationStateDataLoader.*;

import static com.ray3k.template.JamGame.*;
import static com.ray3k.template.screens.GameScreen.*;

public class BackgroundEntity extends Entity {
    public Vector2 bounds = new Vector2();
    public String animationPath;
    
    public BackgroundEntity(String name) {
        var path = "level-backgrounds/" + name + ".json";
        var atlasPath = "level-backgrounds/" + name + ".atlas";
        animationPath = path + "-animation";
        assetManager.load(animationPath, AnimationStateData.class, new AnimationStateDataParameter(path, atlasPath));
        assetManager.finishLoading();
        setSkeletonData(assetManager.get(path), assetManager.get(animationPath));
        depth = 100;
        animationState.setAnimation(0, "animation", true);
        skeleton.getBounds(new Vector2(), bounds, new FloatArray());
    }
    
    @Override
    public void create() {
    
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
    
    }
    
    @Override
    public void draw(float delta) {
    
    }
    
    @Override
    public void destroy() {
    
    }
    
    public void dispose() {
        assetManager.unload(animationPath);
    }
    
    public void updatePosition() {
        float scale = Math.max(gameScreen.viewport.getWorldWidth() / bounds.x, gameScreen.viewport.getWorldHeight() / bounds.y) * gameScreen.camera.zoom;
        skeleton.setScale(scale, scale);
        setPosition(gameScreen.camera.position.x, gameScreen.camera.position.y);
    }
}
