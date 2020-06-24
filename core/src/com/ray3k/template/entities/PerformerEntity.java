package com.ray3k.template.entities;

import com.ray3k.template.*;
import com.ray3k.template.entities.moves.*;
import com.ray3k.template.entities.movesets.*;
import com.ray3k.template.entities.steering.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class PerformerEntity extends Entity {
    public SkinName skinName;
    public Steering steering;
    public MoveSet moveSet;
    public Move currentMove;
    public Mode mode;
    public static enum Mode {
        MOVING, ATTACKING, JUMPING, JUMP_ATTACKING, STANDING;
    }
    
    public PerformerEntity(SkinName skinName) {
        this.skinName = skinName;
    }
    
    @Override
    public void create() {
        setSkeletonData(Core.assetManager.get("spine/fighter.json"), Core.assetManager.get("spine/fighter.json-animation"));
        skeleton.setSkin(skinName.skin);
        steering = new P1Steering();
        moveSet = skinName.moveSet;
        mode = Mode.STANDING;
        currentMove = moveSet.stance;
        currentMove.execute(this);
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
        steering.update(delta);
        
        Move newMove = null;
        Mode newMode = null;
        if (steering.left) {
            newMode = MOVING;
            newMove = moveSet.goLeft;
        } else if (steering.right) {
            newMode = MOVING;
            newMove = moveSet.goRight;
        } else {
            newMode = STANDING;
            newMove = moveSet.stance;
        }
        
        if (steering.attack) {
            if (steering.right || steering.left) {
                newMode = ATTACKING;
                newMove = moveSet.attackSide;
            } else if (steering.up) {
                newMode = ATTACKING;
                newMove = moveSet.attackUp;
            } else if (steering.down) {
                newMode = ATTACKING;
                newMove = moveSet.attackDown;
            } else {
                newMode = ATTACKING;
                newMove = moveSet.attackNeutral;
            }
        } else if (steering.special) {
            if (steering.right || steering.left) {
                newMode = ATTACKING;
                newMove = moveSet.specialSide;
            } else if (steering.up) {
                newMode = ATTACKING;
                newMove = moveSet.specialUp;
            } else if (steering.down) {
                newMode = ATTACKING;
                newMove = moveSet.specialDown;
            } else {
                newMode = ATTACKING;
                newMove = moveSet.specialNeutral;
            }
        }
        
        if (newMove != null && newMove != currentMove && newMove.canPerform(this)) {
            currentMove = newMove;
            mode = newMode;
            currentMove.execute(this);
        }
        
        currentMove.update(this, delta);
    }
    
    @Override
    public void draw(float delta) {
    
    }
    
    @Override
    public void destroy() {
    
    }
}
