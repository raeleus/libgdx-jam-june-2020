package com.ray3k.template.entities.moves;

import com.esotericsoftware.spine.Animation;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveJab implements Move {
    private Animation anim = GENERAL_JAB.animation;
    
    @Override
    public boolean canPerform(PerformerEntity performer) {
        return performer.animationState.getCurrent(0).getAnimation() != anim;
    }
    
    @Override
    public void execute(PerformerEntity performer, float delta) {
        performer.animationState.setAnimation(0, anim, false);
        performer.animationState.addAnimation(0, GENERAL_STANCE.animation, false, 0);
    }
}
