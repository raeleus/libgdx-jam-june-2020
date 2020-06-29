package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveLowPunch extends MoveAttackTemplate {
    public MoveLowPunch() {
        friction = 500f;
        anim = GENERAL_LOW_PUNCH.animation;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 30f;
    }
}
