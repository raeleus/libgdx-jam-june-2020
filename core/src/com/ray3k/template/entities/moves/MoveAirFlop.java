package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveAirFlop extends MoveAttackAirTemplate {
    public MoveAirFlop() {
        friction = 0f;
        attackAnim = GENERAL_AIR_FLOP.animation;
        jumpDelay = 0f;
        gravity = 2000f;
    
        damage = 15f;
        force = 2000f;
        forceAngle = 30f;
    }
}
