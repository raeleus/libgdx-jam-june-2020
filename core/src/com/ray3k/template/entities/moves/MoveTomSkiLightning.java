package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveTomSkiLightning extends MoveSpecialTemplate {
    public MoveTomSkiLightning() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = TOMSKI_LIGHTNING.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
}
