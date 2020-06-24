package com.ray3k.template.entities;

import com.esotericsoftware.spine.Animation;
import com.ray3k.template.*;
import com.ray3k.template.entities.movesets.*;
import com.ray3k.template.entities.steering.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.SkinName.*;

public class PerformerEntity extends Entity {
    public Steering steering;
    public MoveSet moveSet;
    
    @Override
    public void create() {
        setSkeletonData(Core.assetManager.get("spine/fighter.json"), Core.assetManager.get("spine/fighter.json-animation"));
        skeleton.setSkin(ACE_SKELETON.skin);
        animationState.setAnimation(0, GENERAL_STANCE.animation, true);
        steering = new P1Steering();
        moveSet = new MoveSetAceSkeleton();
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
        steering.update(delta);
        
        if (steering.left && moveSet.goLeft.canPerform(this)) {
            moveSet.goLeft.execute(this, delta);
        } else if (steering.right && moveSet.goRight.canPerform(this)) {
            moveSet.goRight.execute(this, delta);
        } else if (moveSet.stance.canPerform(this)) {
            moveSet.stance.execute(this, delta);
        }
        
        if (steering.attack && moveSet.attackNeutral.canPerform(this)) {
            moveSet.attackNeutral.execute(this, delta);
        }
    }
    
    @Override
    public void draw(float delta) {
    
    }
    
    @Override
    public void destroy() {
    
    }
}
