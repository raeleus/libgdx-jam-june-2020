package com.ray3k.template.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.ray3k.template.*;

public class DecalEntity extends Entity {
    AtlasRegion region;
    public DecalEntity(int x, int y, String region) {
        setPosition(x, y);
        TextureAtlas atlas = Core.assetManager.get("textures/textures.atlas");
        this.region = atlas.findRegion(region);
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
        Core.batch.draw(region, x, y);
    }
    
    @Override
    public void destroy() {
    
    }
}
