package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveFrontFlip extends MoveAttackTemplate {
    public MoveFrontFlip() {
        friction = 100f;
        anim = GENERAL_FRONT_FLIP.animation;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 5f;
    }
}
