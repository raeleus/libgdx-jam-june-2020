package com.ray3k.template.entities;

import com.ray3k.template.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.SkinName.*;

public class PerformerEntity extends Entity {
    @Override
    public void create() {
        setSkeletonData(Core.assetManager.get("spine/fighter.json"), Core.assetManager.get("spine/fighter.json-animation"));
        skeleton.setSkin(ACE_SKELETON.name);
        animationState.setAnimation(0, GENERAL_STANCE.name, true);
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
