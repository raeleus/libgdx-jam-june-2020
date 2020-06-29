package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveSplitKick extends MoveAttackTemplate {
    public MoveSplitKick() {
        friction = 500f;
        anim = GENERAL_SPLIT_KICK.animation;
    
        damage = 10f;
        force = 1000f;
        forceAngle = 30f;
    }
}
