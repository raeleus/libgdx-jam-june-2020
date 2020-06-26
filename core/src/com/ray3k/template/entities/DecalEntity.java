package com.ray3k.template.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.dongbat.jbump.Item;
import com.ray3k.template.*;

public class DecalEntity extends Entity implements Bumpable {
    AtlasRegion region;
    public float width;
    public float height;
    public Item<Entity> item;
    public DecalEntity(int x, int y, String region) {
        setPosition(x, y);
        TextureAtlas atlas = Core.assetManager.get("textures/textures.atlas");
        this.region = atlas.findRegion(region);
        width = 100;
        height = 100;
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
    
    @Override
    public float getBumpX() {
        return x;
    }
    
    @Override
    public float getBumpY() {
        return y;
    }
    
    @Override
    public float getBumpWidth() {
        return width;
    }
    
    @Override
    public float getBumpHeight() {
        return height;
    }
    
    @Override
    public Item<Entity> getItem() {
        return item;
    }
    
    @Override
    public void setItem(Item<Entity> item) {
        this.item = item;
    }
    
    @Override
    public void updateEntityPosition(float x, float y) {
    
    }
}
