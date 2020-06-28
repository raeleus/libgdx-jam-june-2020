package com.ray3k.template.entities.moves;

import com.badlogic.gdx.math.MathUtils;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveShield implements Move {
    public static float FRICTION = 1400f;
    public static float GRAVITY = 2000f;
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return (performer.mode == STANDING || performer.mode == MOVING) && performer.shield > 0;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        var current = performer.animationState.getCurrent(0);
        if (current == null || current.getAnimation() != GENERAL_SHIELD_START.animation) {
            performer.animationState.setAnimation(0, GENERAL_SHIELD_START.animation, false);
            performer.animationState.addAnimation(0, GENERAL_SHIELD.animation, true, 0);
        }
        performer.touchedGround = true;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        performer.deltaX = Utils.approach(performer.deltaX, 0, FRICTION * delta);
        performer.gravityY = -GRAVITY;
        
        if (!performer.steering.shield) {
            performer.mode = STANDING;
            performer.currentMove = performer.moveSet.stance;
            performer.animationState.setAnimation(0, GENERAL_SHIELD_END.animation, false);
            performer.animationState.addAnimation(0, GENERAL_STANCE.animation, true,0);
        } else {
            var scale = MathUtils.clamp(performer.shield / SHIELD_MAX, 0, 1);
            performer.shieldBone.setScale(scale, scale);
            performer.shield -= SHIELD_DECAY * delta;
            if (performer.shield < 0) {
                performer.shield = SHIELD_PENALTY;
                performer.mode = STANDING;
                performer.currentMove = performer.moveSet.stance;
                performer.animationState.setAnimation(0, GENERAL_SHIELD_END.animation, false);
                performer.animationState.addAnimation(0, GENERAL_STANCE.animation, true, 0);
            }
        }
    }
    
    @Override
    public void continueExecution(PerformerEntity performer) {
    
    }
}