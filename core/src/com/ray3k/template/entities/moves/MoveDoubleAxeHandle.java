package com.ray3k.template.entities.moves;

import com.esotericsoftware.spine.Animation;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveDoubleAxeHandle extends MoveAttackTemplate {
    public MoveDoubleAxeHandle() {
        friction = 500f;
        anim = GENERAL_DOUBLE_AXE_HANDLE.animation;
    
        damage = 15f;
        force = 2000f;
        forceAngle = 30f;
    }
}
