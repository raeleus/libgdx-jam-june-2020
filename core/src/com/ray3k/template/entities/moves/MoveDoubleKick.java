package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveDoubleKick extends MoveAttackTemplate {
    public MoveDoubleKick() {
        friction = 500f;
        anim = GENERAL_DOUBLE_KICK.animation;
    }
}
