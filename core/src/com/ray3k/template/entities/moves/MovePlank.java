package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MovePlank extends MoveAttackTemplate {
    public MovePlank() {
        friction = 500f;
        anim = GENERAL_PLANK.animation;
    }
}
