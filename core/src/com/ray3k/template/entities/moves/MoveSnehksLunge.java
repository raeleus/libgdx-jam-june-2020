package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveSnehksLunge extends MoveSpecialTemplate {
    public MoveSnehksLunge() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = SNEHKS_LUNGE.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
}
