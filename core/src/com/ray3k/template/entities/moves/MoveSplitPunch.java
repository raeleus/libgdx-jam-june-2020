package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveSplitPunch extends MoveAttackTemplate {
    public MoveSplitPunch() {
        friction = 500f;
        anim = GENERAL_SPLIT_PUNCH.animation;
    }
}
