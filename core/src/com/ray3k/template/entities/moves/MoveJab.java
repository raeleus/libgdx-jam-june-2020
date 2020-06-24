package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveJab extends MoveAttackTemplate {
    public MoveJab() {
        friction = 500f;
        anim = GENERAL_JAB.animation;
    }
}
