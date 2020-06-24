package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveStance implements Move {
    public static float FRICTION = 1400f;
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return true;
    }
    
    @Override
    public void execute(PerformerEntity performer, float delta) {
        performer.setSpeed(Utils.approach(performer.getSpeed(), 0, FRICTION * delta));
        performer.animationState.setAnimation(0, GENERAL_STANCE.animation, true);
    }
}