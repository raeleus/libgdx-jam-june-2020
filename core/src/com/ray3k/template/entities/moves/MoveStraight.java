package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveStraight extends MoveAttackTemplate {
    public MoveStraight() {
        friction = 500f;
        anim = GENERAL_STRAIGHT.animation;
    }
}
