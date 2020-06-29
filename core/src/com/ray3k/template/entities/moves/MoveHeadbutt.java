package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveHeadbutt extends MoveAttackTemplate {
    public MoveHeadbutt() {
        friction = 500f;
        anim = GENERAL_HEADBUTT.animation;
        
        damage = 13f;
        force = 2000f;
        forceAngle = 30f;
    }
}
