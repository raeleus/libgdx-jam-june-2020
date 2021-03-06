package com.ray3k.template.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.dongbat.jbump.*;
import com.ray3k.template.*;

import java.util.Comparator;

import static com.ray3k.template.Core.*;
import static com.ray3k.template.JamGame.*;

public class EntityController {
    public Array<Entity> entities;
    public Comparator<Entity> depthComparator;
    private Array<Entity> sortedEntities;
    public World<Entity> world;
    
    public EntityController() {
        entities = new Array<>();
        sortedEntities = new Array<>();
        world = new World<>();
        
        depthComparator = (o1, o2) -> o2.depth - o1.depth;
    }
    
    public void add(Entity entity) {
        entities.add(entity);
        if (entity instanceof Bumpable) {
            var bump = (Bumpable) entity;
            bump.setItem(new Item<>(entity));
            world.add(bump.getItem(), bump.getBumpX(), bump.getBumpY(), bump.getBumpWidth(), bump.getBumpHeight());
        }
        entity.create();
    }
    
    public void remove(Entity entity) {
        entities.removeValue(entity, false);
    }
    
    public void act(float delta) {
        sortedEntities.clear();
        sortedEntities.addAll(entities);
        sortedEntities.sort(depthComparator);
        
        for (Entity entity : sortedEntities) {
            entity.actBefore(delta);
        }
        
        //simulate physics and call act methods
        for (Entity entity : sortedEntities) {
            entity.deltaX += entity.gravityX * delta;
            entity.deltaY += entity.gravityY * delta;
            
            entity.x += entity.deltaX * delta;
            entity.y += entity.deltaY * delta;
    
            if (entity.skeleton != null) {
                entity.skeleton.setPosition(entity.x, entity.y);
                entity.animationState.update(delta);
                entity.skeleton.updateWorldTransform();
                entity.animationState.apply(entity.skeleton);
                entity.skeletonBounds.update(entity.skeleton, true);
            }
    
            //update collisions
            if (entity instanceof Bumpable) {
                var bump = (Bumpable) entity;
                if (bump.isTeleporting()) {
                    world.update(bump.getItem(), bump.getBumpX(), bump.getBumpY());
                    bump.setTeleporting(false);
                } else {
    
                    var result = world.check(bump.getItem(), bump.getBumpX(), bump.getBumpY(), (item, other) -> {
                        if (other.userData instanceof PerformerEntity) return null;
                        return Response.slide;
                    });
                    var projectedCollisions = result.projectedCollisions;
    
                    var noCollisions = new Array<Entity>();
                    for (int i = 0; i < projectedCollisions.size(); i++) {
                        Collision col = projectedCollisions.get(i);
                        var otherEntity = (Entity) col.other.userData;
                        if (otherEntity instanceof PlatformEntity) {
    
                            if (col.overlaps) noCollisions.add(otherEntity);
                            else if (!MathUtils.isZero(col.normal.x)) noCollisions.add(otherEntity);
                            else if (!MathUtils.isZero(col.normal.y) && col.move.y > 0) noCollisions.add(otherEntity);
                        }
                    }
    
                    result = world.move(bump.getItem(), bump.getBumpX(), bump.getBumpY(), (item, other) -> {
                        if (other.userData instanceof PerformerEntity) return null;
                        return noCollisions.contains((Entity) other.userData, true) ? null : Response.slide;
                    });
                    projectedCollisions = result.projectedCollisions;
                    var rect = world.getRect(bump.getItem());
                    bump.updateEntityPosition(rect.x, rect.y);
                    var touched = new Array<Entity>();
                    var collisions = new Array<Collision>();
                    for (int i = 0; i < projectedCollisions.size(); i++) {
                        Collision col = projectedCollisions.get(i);
                        touched.add((Entity) col.other.userData);
                        collisions.add(col);
                        if (!MathUtils.isZero(col.normal.x)) entity.deltaX = 0;
                        if (!MathUtils.isZero(col.normal.y)) entity.deltaY = 0;
                    }
                    bump.collisions(touched, collisions);
                }
            }
            
            entity.act(delta);
        }
    
        //call destroy methods and remove the entities
        for (Entity entity : sortedEntities) {
            if (entity.destroy) {
                entity.destroy();
                entities.removeValue(entity, false);
    
                if (entity instanceof Bumpable) {
                    var bump = (Bumpable) entity;
                    world.remove(bump.getItem());
                }
            }
        }
    }
    
    public void draw(float delta) {
        //call draw methods
        for (Entity entity : sortedEntities) {
            if (entity.visible) {
                if (entity.skeleton != null) {
                    //interpolate position
                    entity.skeleton.setPosition(entity.x + entity.deltaX * delta, entity.y + entity.deltaY * delta);
                    entity.skeleton.updateWorldTransform();
                    skeletonRenderer.draw(batch, entity.skeleton);
                }
                
                entity.draw(delta);
            }
        }
    }
}
