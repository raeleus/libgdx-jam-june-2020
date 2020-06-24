package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveGoRight implements Move {
    public final static float MOVE_SPEED = 400f;
    public final static float ACCELERATION = 2400f;
    
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return true;
    }
    
    @Override
    public void execute(PerformerEntity performer, float delta) {
        performer.deltaX = Utils.approach(performer.deltaX, MOVE_SPEED, ACCELERATION * delta);
        if (performer.animationState.getCurrent(0).getAnimation() != GENERAL_WALK.animation) performer.animationState.setAnimation(0, GENERAL_WALK.animation, true);
        performer.skeleton.getRootBone().setScaleX(1);
    }
}