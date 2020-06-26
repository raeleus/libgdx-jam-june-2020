package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveAceFlyingUppercut extends MoveSpecialTemplate {
    @Override
    public void execute(PerformerEntity performer) {
        attackAnim = ACE_FLYING_UPPERCUT.animation;
        hSpeed = 800f;
        vSpeed = 1200f;
        gravity = 2000f;
        airFriction = 800f;
        groundFriction = 1400f;
        super.execute(performer);
    }
}
