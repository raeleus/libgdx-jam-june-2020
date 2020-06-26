package com.ray3k.template.entities.projectiles;

import com.esotericsoftware.spine.AnimationState.AnimationStateAdapter;
import com.esotericsoftware.spine.AnimationState.TrackEntry;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.moves.*;

public class Projectile extends Entity {
    public ProjectileSkinName skinName;
    public ProjectileAnimationName animationName;
    public PerformerEntity parent;
    public MoveSpecialTemplate parentMove;
    public float acceleration;
    public float accelerationH;
    public float gravity;
    public boolean killOnAnimationEnd;
    public boolean landOnGround;
    public float groundFriction;
    public float airFriction;
    public float lifeTimer = 10f;
    public boolean rotateWithDirection;
    public boolean bounce;
    
    @Override
    public void create() {
        setSkeletonData(Core.assetManager.get("spine/projectile.json"), Core.assetManager.get("spine/projectile.json-animation"));
        skeleton.setSkin(skinName.skin);
        animationState.setAnimation(0, animationName.animation, !killOnAnimationEnd);
        animationState.addListener(new AnimationStateAdapter() {
            @Override
            public void complete(TrackEntry entry) {
                if (killOnAnimationEnd) destroy = true;
            }
        });
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
        setSpeed(getSpeed() + acceleration * delta);
        
        deltaX += accelerationH * delta;
        
        gravityY = -gravity;
        if (landOnGround || bounce) {
            if (y < 0) {
                y = 0;
                
                if (landOnGround) deltaX = Utils.approach(deltaX, 0, groundFriction);
                if (bounce) deltaY = Math.abs(deltaY);
            }
        }
        
        if (lifeTimer > 0) {
            lifeTimer -= delta;
            if (lifeTimer <= 0) {
                destroy = true;
            }
        }
        
        if (rotateWithDirection) {
            skeleton.getRootBone().setRotation(getDirection());
        }
    }
    
    @Override
    public void draw(float delta) {
    
    }
    
    @Override
    public void destroy() {
        if (parentMove != null) {
            parentMove.projectileCount--;
            if (parentMove.projectileCount < 0) parentMove.projectileCount = 0;
        }
    }
}
