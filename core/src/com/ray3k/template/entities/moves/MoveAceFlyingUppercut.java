package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveAceFlyingUppercut extends MoveSpecialTemplate {
    public MoveAceFlyingUppercut() {
        airFriction = 800f;
        groundFriction = 1400f;
        attackAnim = ACE_FLYING_UPPERCUT.animation;
        gravity = 2000f;
        hSpeed = 800f;
        vSpeed = 1200f;
    }
}
