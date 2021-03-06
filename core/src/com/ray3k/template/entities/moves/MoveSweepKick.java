package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveSweepKick extends MoveAttackTemplate {
    public MoveSweepKick() {
        friction = 500f;
        anim = GENERAL_SWEEP_KICK.animation;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 70f;
    }
}
