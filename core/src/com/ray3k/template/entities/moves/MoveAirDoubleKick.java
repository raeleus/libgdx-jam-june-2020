package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveAirDoubleKick extends MoveAttackAirTemplate {
    public MoveAirDoubleKick() {
        friction = 0f;
        attackAnim = GENERAL_AIR_DOUBLE_KICK.animation;
        jumpDelay = 0f;
        gravity = 2000f;
    
        damage = 13f;
        force = 2000f;
        forceAngle = 10f;
    }
}
