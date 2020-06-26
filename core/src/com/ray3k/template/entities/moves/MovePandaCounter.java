package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MovePandaCounter extends MoveSpecialTemplate {
    public MovePandaCounter() {
        airFriction = 400f;
        groundFriction = 400f;
        attackAnim = PANDA_COUNTER.animation;
        gravity = 2000f;
        vSpeed = 0f;
    }
}
