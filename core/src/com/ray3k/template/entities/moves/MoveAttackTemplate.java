package com.ray3k.template.entities.moves;

import com.esotericsoftware.spine.Animation;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveAttackTemplate implements Move {
    public float friction = 500f;
    public Animation anim = GENERAL_JAB.animation;
    public static float GRAVITY = 2000f;
    
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return performer.mode == STANDING || performer.mode == MOVING;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        performer.animationState.setAnimation(0, anim, false);
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        performer.deltaX = Utils.approach(performer.deltaX, 0, friction * delta);
        if (performer.animationState.getCurrent(0).isComplete()) performer.mode = STANDING;
        performer.gravityY = -GRAVITY;
    }
    
    @Override
    public void continueExecution(PerformerEntity performer) {
    
    }
}
