package com.ray3k.template.entities.moves;

import com.esotericsoftware.spine.Animation;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveAttackAirTemplate implements Move {
    public final static float H_SPEED = 800f;
    public final static float H_ACCELERATION = 2400f;
    
    public float friction = 500f;
    public static float gravity = 2000f;
    public Animation attackAnim = GENERAL_AIR_PUNCH.animation;
    public float jumpDelay = 0f;
    public float jumpTime;
    
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return performer.mode == JUMPING;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        performer.animationState.setAnimation(0, attackAnim, false);
        jumpTime = jumpDelay;
        performer.moveSet.soundWoosh.play();
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        performer.deltaX = Utils.approach(performer.deltaX, 0, friction * delta);
        
        if (performer.animationState.getCurrent(0).isComplete()) {
            jumpTime -= delta;
            if (jumpTime < 0 && performer.steering.jump) {
                performer.mode = JUMPING;
                performer.currentMove = performer.moveSet.jump;
                performer.currentMove.continueExecution(performer);
            }
        }
        
        performer.gravityY = -gravity;
        if (performer.onGround) {
            performer.mode = STANDING;
        }
    
        if (performer.animationState.getCurrent(0).isComplete()) {
            if (performer.steering.left) performer.deltaX = Utils.approach(performer.deltaX, -H_SPEED, H_ACCELERATION * delta);
            else if (performer.steering.right) performer.deltaX = Utils.approach(performer.deltaX, H_SPEED, H_ACCELERATION * delta);
        }
    }
    
    @Override
    public void continueExecution(PerformerEntity performer) {
    
    }
}
