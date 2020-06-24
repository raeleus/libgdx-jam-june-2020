package com.ray3k.template.entities.moves;

import com.esotericsoftware.spine.Animation;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveSpecialTemplate implements Move {
    public float friction = 500f;
    public static float gravity = 2000f;
    public Animation attackAnim = GENERAL_AIR_PUNCH.animation;
    public float jumpDelay = 0f;
    public float jumpTime;
    public boolean continueJump;
    
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return performer.mode == STANDING || performer.mode == MOVING || performer.mode == JUMPING;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        performer.animationState.setAnimation(0, attackAnim, false);
        jumpTime = jumpDelay;
        continueJump = performer.mode == JUMPING;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        performer.deltaX = Utils.approach(performer.deltaX, 0, friction * delta);
    
        if (performer.animationState.getCurrent(0).isComplete()) {
            jumpTime -= delta;
            if (jumpTime < 0 && performer.steering.jump) {
                performer.mode = JUMPING;
                performer.currentMove = performer.moveSet.jump;
                if (continueJump) performer.currentMove.continueExecution(performer);
                else performer.currentMove.execute(performer);
            }
        }
    
        performer.deltaY -= gravity * delta;
        if (performer.y < 0) {
            performer.y = 0;
            if (performer.animationState.getCurrent(0).isComplete()) performer.mode = STANDING;
            performer.deltaY = 0;
        }
    }
    
    @Override
    public void continueExecution(PerformerEntity performer) {
    
    }
}
