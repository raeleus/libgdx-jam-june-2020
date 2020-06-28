package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveJump implements Move {
    public final static float H_SPEED = 400f;
    public final static float H_ACCELERATION = 2400f;
    public final static float JUMP_SPEED = 1200f;
    public final static float EXTRA_JUMP_SPEED = 900f;
    public final static float GRAVITY = 2000f;
    public final int TOTAL_JUMPS = 2;
    public final float EXTRA_JUMP_DELAY = .25f;
    public int jumps;
    public float extraJumpTime;
    
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return performer.mode == STANDING || performer.mode == MOVING;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        if (performer.animationState.getCurrent(0).getAnimation() != GENERAL_JUMP.animation) {
            performer.animationState.setAnimation(0, GENERAL_JUMP.animation, false);
            performer.animationState.addAnimation(0, GENERAL_AIR.animation, true, 0);
            performer.moveSet.soundGrunt.play();
        }
        
        performer.deltaY = JUMP_SPEED;
        jumps = 1;
        extraJumpTime = EXTRA_JUMP_DELAY;
        performer.onGround = false;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        extraJumpTime -= delta;
        
        if (extraJumpTime < 0 && jumps < TOTAL_JUMPS && performer.steering.jump) {
            jumps++;
            performer.deltaY = EXTRA_JUMP_SPEED;
            extraJumpTime = EXTRA_JUMP_DELAY;
    
            if (performer.animationState.getCurrent(0).getAnimation() != GENERAL_AIR.animation) {
                performer.animationState.setAnimation(0, GENERAL_AIR.animation, true);
            }
        }
        
        if (performer.steering.left) performer.deltaX = Utils.approach(performer.deltaX, -H_SPEED, H_ACCELERATION * delta);
        else if (performer.steering.right) performer.deltaX = Utils.approach(performer.deltaX, H_SPEED, H_ACCELERATION * delta);
    
        performer.gravityY = -GRAVITY;
        if (performer.onGround) {
            performer.mode = STANDING;
        }
    }
    
    @Override
    public void continueExecution(PerformerEntity performer) {
        if (extraJumpTime < 0 && jumps < TOTAL_JUMPS && performer.steering.jump) {
            jumps++;
            performer.deltaY = EXTRA_JUMP_SPEED;
            extraJumpTime = EXTRA_JUMP_DELAY;
        
            if (performer.animationState.getCurrent(0).getAnimation() != GENERAL_AIR.animation) {
                performer.animationState.setAnimation(0, GENERAL_AIR.animation, true);
            }
        }
    }
}
