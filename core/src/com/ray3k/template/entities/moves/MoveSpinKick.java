package com.ray3k.template.entities.moves;

import com.esotericsoftware.spine.Animation;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveSpinKick implements Move {
    public static float FRICTION = 500f;
    private Animation anim = GENERAL_SPIN_KICK.animation;
    
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
        performer.setSpeed(Utils.approach(performer.getSpeed(), 0, FRICTION * delta));
        if (performer.animationState.getCurrent(0).isComplete()) performer.mode = STANDING;
    }
}
