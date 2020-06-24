package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.PerformerEntity.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveStance implements Move {
    public static float FRICTION = 1400f;
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return performer.mode == STANDING || performer.mode == MOVING;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        if (performer.animationState.getCurrent(0).getAnimation() != GENERAL_STANCE.animation) performer.animationState.setAnimation(0, GENERAL_STANCE.animation, true);
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        performer.setSpeed(Utils.approach(performer.getSpeed(), 0, FRICTION * delta));
    }
}