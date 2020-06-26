package com.ray3k.template.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite;
import com.ray3k.template.*;

public class DecalEntity extends Entity {
    public AtlasSprite sprite;
    
    public DecalEntity(int x, int y, String region) {
        setPosition(x, y);
        TextureAtlas atlas = Core.assetManager.get("textures/textures.atlas");
        sprite = new AtlasSprite(atlas.findRegion(region));
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
        sprite.setPosition(x - sprite.getWidth() / 2, y - sprite.getHeight() / 2);
        sprite.draw(Core.batch);
    }
    
    @Override
    public void destroy() {
    
    }
}
