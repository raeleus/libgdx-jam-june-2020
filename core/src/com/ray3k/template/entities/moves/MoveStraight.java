package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveStraight extends MoveAttackTemplate {
    public MoveStraight() {
        friction = 500f;
        anim = GENERAL_STRAIGHT.animation;
    
        damage = 8f;
        force = 2000f;
        forceAngle = 30f;
    }
}
