package com.ray3k.template.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.dongbat.jbump.Item;
import com.dongbat.jbump.Response;
import com.ray3k.template.entities.projectiles.*;

import static com.ray3k.template.screens.GameScreen.*;

public class HitboxEntity extends Entity {
    public Rectangle rectangle = new Rectangle();
    public boolean active;
    public Item<Entity> item = new Item<>(this);
    public PerformerEntity parent;
    public Projectile projectileParent;
    public float damage;
    public float force;
    public float forceAngle;
    
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
        if (active) {
            var result = hitBoxWorld.check(item, rectangle.x, rectangle.y, (item, other) -> {
                if (other.userData instanceof HitboxEntity) return null;
                if (((HurtboxEntity) other.userData).parent == parent) return null;
                return Response.cross;
            });
    
            for (int i = 0; i < result.projectedCollisions.size(); i++) {
                var col = result.projectedCollisions.get(i);
                ((HurtboxEntity) col.other.userData).parent.hurt(damage, force, forceAngle);
                parent.hitEnemy();
                if (projectileParent != null) projectileParent.hitEnemy();
            }
        }
    }
    
    @Override
    public void draw(float delta) {
        if (active) {
//            var g = gameScreen.shapeDrawer;
//            g.setColor(Color.RED);
//            g.filledRectangle(rectangle);
        }
    }
    
    @Override
    public void destroy() {
        hitBoxWorld.remove(item);
    }
}
