package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveTomSkiSlide extends MoveSpecialTemplate {
    public MoveTomSkiSlide() {
        airFriction = 0f;
        groundFriction = 200f;
        attackAnim = ACE_SLIDE.animation;
        gravity = 2000f;
        hSpeed = 900f;
        vSpeed = 0f;
    }
}
