package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveGoLeft implements Move {
    public final static float MOVE_SPEED = 400f;
    public final static float ACCELERATION = 2400f;
    
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return performer.mode == STANDING || performer.mode == MOVING;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        if (performer.animationState.getCurrent(0).getAnimation() != GENERAL_WALK.animation) performer.animationState.setAnimation(0, GENERAL_WALK.animation, true);
        performer.skeleton.getRootBone().setScaleX(-1);
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        performer.deltaX = Utils.approach(performer.deltaX, -MOVE_SPEED, ACCELERATION * delta);
    }
}
