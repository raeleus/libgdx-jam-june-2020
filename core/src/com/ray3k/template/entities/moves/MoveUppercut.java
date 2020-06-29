package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveUppercut extends MoveAttackTemplate {
    public MoveUppercut() {
        friction = 500f;
        anim = GENERAL_UPPERCUT.animation;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 70f;
    }
}
