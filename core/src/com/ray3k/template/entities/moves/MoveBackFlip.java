package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveBackFlip extends MoveAttackTemplate {
    public MoveBackFlip() {
        friction = 500f;
        anim = GENERAL_BACK_FLIP.animation;
    
        damage = 15f;
        force = 2000f;
        forceAngle = 85f;
    }
}
