package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveAirPunch extends MoveAttackAirTemplate {
    public MoveAirPunch() {
        friction = 0f;
        attackAnim = GENERAL_AIR_PUNCH.animation;
        jumpDelay = 0f;
        gravity = 2000f;
    
        damage = 12f;
        force = 1800f;
        forceAngle = 30f;
    }
}
