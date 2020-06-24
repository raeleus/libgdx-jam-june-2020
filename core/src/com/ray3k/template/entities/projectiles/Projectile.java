package com.ray3k.template.entities.projectiles;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.transitions.*;

public class Projectile extends Entity {
    public ProjectileSkinName skinName;
    public ProjectileAnimationName animationName;
    public PerformerEntity parent;
    
    @Override
    public void create() {
        setSkeletonData(Core.assetManager.get("spine/projectile.json"), Core.assetManager.get("spine/projectile.json-animation"));
        skeleton.setSkin(skinName.skin);
        animationState.setAnimation(0, animationName.animation, true);
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
}
