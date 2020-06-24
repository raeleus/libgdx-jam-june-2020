package com.ray3k.template.entities;

import com.esotericsoftware.spine.Animation;
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
        skeleton.setSkin(ACE_SKELETON.skin);
        animationState.setAnimation(0, GENERAL_STANCE.animation, true);
        steering = new P1Steering();
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
        steering.update(delta);
    
        Animation anim = null;
        
        if (steering.left) {
            setMotion(MOVE_SPEED, 180);
            
            anim = GENERAL_WALK.animation;
        }
        else if (steering.right) {
            setMotion(MOVE_SPEED, 0);
    
            anim = GENERAL_WALK.animation;
        }
        else {
            setSpeed(0);
            
            anim = GENERAL_STANCE.animation;
        }
    
        if (animationState.getCurrent(0).getAnimation() != anim) animationState.setAnimation(0, anim, true);
    }
    
    @Override
    public void draw(float delta) {
    
    }
    
    @Override
    public void destroy() {
    
    }
}
