package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveAirKick extends MoveAttackAirTemplate {
    public MoveAirKick() {
        friction = 0f;
        attackAnim = GENERAL_AIR_KICK.animation;
        jumpDelay = 0f;
        gravity = 2000f;
    }
}
