package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveOneTwo extends MoveAttackTemplate {
    public MoveOneTwo() {
        friction = 500f;
        anim = GENERAL_ONE_TWO.animation;
    }
}
