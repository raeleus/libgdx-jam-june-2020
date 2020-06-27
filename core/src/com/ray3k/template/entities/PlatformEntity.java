package com.ray3k.template.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.dongbat.jbump.Collision;
import com.dongbat.jbump.Item;

import static com.ray3k.template.screens.GameScreen.*;

public class PlatformEntity extends Entity implements Bumpable {
    public float width;
    public float height;
    public Item<Entity> item;
    
    public PlatformEntity() {
        item = new Item<>();
        item.userData = this;
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
    
    }
    
    @Override
    public void updateEntityPosition(float x, float y) {
    
    }
    
    @Override
    public void collisions(Array<Entity> touched, Array<Collision> collisions) {
    
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
//        gameScreen.shapeDrawer.setColor(Color.PURPLE);
//        gameScreen.shapeDrawer.rectangle(getBumpX(), getBumpY(), getBumpWidth(), getBumpHeight());
    }
    
    @Override
    public void destroy() {
    
    }
    
}
