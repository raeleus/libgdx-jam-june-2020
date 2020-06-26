package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveAliLaser extends MoveSpecialTemplate {
    public MoveAliLaser() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = ALI_LASER.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
}
