package com.ray3k.template.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.dongbat.jbump.CollisionFilter;
import com.dongbat.jbump.Item;
import com.dongbat.jbump.Response;

import static com.ray3k.template.screens.GameScreen.*;

public class HurtboxEntity extends Entity {
    public Rectangle rectangle = new Rectangle();
    public boolean active;
    public Item<Entity> item = new Item<>(this);
    public PerformerEntity parent;
    
    @Override
    public void create() {
        hitBoxWorld.add(item, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
        hitBoxWorld.update(item, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
    
    @Override
    public void draw(float delta) {
        if (active) {
            var g = gameScreen.shapeDrawer;
            g.setColor(Color.GREEN);
            g.filledRectangle(rectangle);
        }
    }
    
    @Override
    public void destroy() {
    
    }
}
