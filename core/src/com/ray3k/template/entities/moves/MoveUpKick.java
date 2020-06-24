package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveUpKick extends MoveAttackTemplate {
    public MoveUpKick() {
        friction = 500f;
        anim = GENERAL_UP_KICK.animation;
    }
}
