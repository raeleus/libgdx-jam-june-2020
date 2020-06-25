package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveAirDoublePunch extends MoveAttackAirTemplate {
    public MoveAirDoublePunch() {
        friction = 0f;
        attackAnim = GENERAL_AIR_DOUBLE_PUNCH.animation;
        jumpDelay = 0f;
        gravity = 2000f;
    }
}
