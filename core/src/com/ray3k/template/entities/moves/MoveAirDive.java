package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveAirDive extends MoveAttackAirTemplate {
    public MoveAirDive() {
        friction = 0f;
        attackAnim = GENERAL_AIR_DIVE.animation;
        jumpDelay = 0f;
        gravity = 2000f;
    
        damage = 11f;
        force = 2500f;
        forceAngle = 10f;
    }
}
