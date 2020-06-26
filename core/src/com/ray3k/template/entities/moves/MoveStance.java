package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.PerformerEntity.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveStance implements Move {
    public static float FRICTION = 1400f;
    public static float GRAVITY = 2000f;
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return performer.mode == STANDING || performer.mode == MOVING;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        var current = performer.animationState.getCurrent(0);
        if (current == null || current.getAnimation() != GENERAL_STANCE.animation) performer.animationState.setAnimation(0, GENERAL_STANCE.animation, true);
        performer.touchedGround = true;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        performer.deltaX = Utils.approach(performer.deltaX, 0, FRICTION * delta);
        performer.gravityY = -GRAVITY;
    }
    
    @Override
    public void continueExecution(PerformerEntity performer) {
    
    }
}