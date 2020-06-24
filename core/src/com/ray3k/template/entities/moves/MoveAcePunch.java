package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveAcePunch extends MoveSpecialTemplate {
    public MoveAcePunch() {
        airFriction = 0f;
        attackAnim = ACE_PUNCH.animation;
        jumpDelay = 0f;
        gravity = 2000f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        super.execute(performer);
        if (performer.y < 0) performer.y = 0;
    }
}
