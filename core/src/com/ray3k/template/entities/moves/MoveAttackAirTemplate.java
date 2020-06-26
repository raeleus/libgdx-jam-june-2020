package com.ray3k.template.entities.moves;

import com.esotericsoftware.spine.Animation;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveAttackAirTemplate implements Move {
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
    
        performer.deltaY -= gravity * delta;
        if (performer.onGround) {
            performer.mode = STANDING;
        }
    }
    
    @Override
    public void continueExecution(PerformerEntity performer) {
    
    }
}
