package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveAceFlyingUppercut extends MoveSpecialTemplate {
    public static final float H_SPEED = 800f;
    public static final float JUMP_SPEED = 1200f;
    
    public MoveAceFlyingUppercut() {
        friction = 800f;
        attackAnim = ACE_FLYING_UPPERCUT.animation;
        jumpDelay = 0f;
        gravity = 2000f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        super.execute(performer);
        performer.deltaY = JUMP_SPEED;
        performer.deltaX = H_SPEED;
        if (performer.skeleton.getRootBone().getScaleX() < 0) performer.deltaX *= -1f;
        performer.mode = JUMP_ATTACKING;
        if (performer.y < 0) performer.y = 0;
    }
}
