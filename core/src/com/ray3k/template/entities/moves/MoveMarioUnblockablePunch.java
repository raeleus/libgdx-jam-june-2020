package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveMarioUnblockablePunch extends MoveSpecialTemplate {
    public MoveMarioUnblockablePunch() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = MARIO_UNBLOCKABLE_PUNCH.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
}
