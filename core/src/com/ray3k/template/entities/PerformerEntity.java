package com.ray3k.template.entities;

import com.ray3k.template.*;
import com.ray3k.template.entities.steering.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.SkinName.*;

public class PerformerEntity extends Entity {
    public Steering steering;
    public final static float MOVE_SPEED = 200f;
    
    @Override
    public void create() {
        setSkeletonData(Core.assetManager.get("spine/fighter.json"), Core.assetManager.get("spine/fighter.json-animation"));
        skeleton.setSkin(ACE_SKELETON.name);
        animationState.setAnimation(0, GENERAL_STANCE.name, true);
        steering = new P1Steering();
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
        steering.update(delta);
        
        if (steering.left) setMotion(MOVE_SPEED, 180);
        else if (steering.right) setMotion(MOVE_SPEED, 0);
        else setSpeed(0);
    }
    
    @Override
    public void draw(float delta) {
    
    }
    
    @Override
    public void destroy() {
    
    }
}
