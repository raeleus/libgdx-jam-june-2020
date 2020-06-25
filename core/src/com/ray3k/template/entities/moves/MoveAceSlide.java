package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveAceSlide extends MoveSpecialTemplate {
    public MoveAceSlide() {
        airFriction = 0f;
        groundFriction = 1000f;
        attackAnim = ACE_SLIDE.animation;
        gravity = 2000f;
        hSpeed = 900f;
        vSpeed = 0f;
    }
}
