package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveTettingerCounter extends MoveSpecialTemplate {
    public MoveTettingerCounter() {
        airFriction = 400f;
        groundFriction = 400f;
        attackAnim = TETTINGER_COUNTER_ATTACK.animation;
        gravity = 2000f;
        vSpeed = 0f;
    }
}
