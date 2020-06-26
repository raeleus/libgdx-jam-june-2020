package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveRaeleusHammer extends MoveSpecialTemplate {
    public MoveRaeleusHammer() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = RAELEUS_HAMMER.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
}
