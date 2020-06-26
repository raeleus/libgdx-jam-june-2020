package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveJohnWhirlwind extends MoveSpecialTemplate {
    public MoveJohnWhirlwind() {
        airFriction = 400f;
        groundFriction = 400f;
        attackAnim = JOHN_WHIRLWIND.animation;
        gravity = 2000f;
        hSpeed = 700f;
        vSpeed = 200f;
    }
}
