package com.ray3k.template.entities.moves;

import com.esotericsoftware.spine.Animation;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveLowKick extends MoveAttackTemplate {
    public MoveLowKick() {
        friction = 500f;
        anim = GENERAL_LOW_KICK.animation;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 70f;
    }
}
