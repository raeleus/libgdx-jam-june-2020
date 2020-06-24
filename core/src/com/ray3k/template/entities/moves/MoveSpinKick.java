package com.ray3k.template.entities.moves;

import com.esotericsoftware.spine.Animation;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveSpinKick extends MoveAttackTemplate {
    public MoveSpinKick() {
        friction = 1400f;
        anim = GENERAL_SPIN_KICK.animation;
    }
}
