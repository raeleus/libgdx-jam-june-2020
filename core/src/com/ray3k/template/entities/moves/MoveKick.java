package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveKick extends MoveAttackTemplate {
    public MoveKick() {
        friction = 500f;
        anim = GENERAL_KICK.animation;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 30f;
    }
}
