package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveDoublePunch extends MoveAttackTemplate {
    public MoveDoublePunch() {
        friction = 500f;
        anim = GENERAL_DOUBLE_PUNCH.animation;
    
        damage = 11f;
        force = 1500f;
        forceAngle = 30f;
    }
}
