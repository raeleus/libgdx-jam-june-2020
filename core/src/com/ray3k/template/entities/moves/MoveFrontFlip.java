package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveFrontFlip extends MoveAttackTemplate {
    public MoveFrontFlip() {
        friction = 500f;
        anim = GENERAL_FRONT_FLIP.animation;
    }
}
