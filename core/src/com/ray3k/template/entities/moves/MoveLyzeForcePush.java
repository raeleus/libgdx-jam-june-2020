package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveLyzeForcePush extends MoveSpecialTemplate {
    public MoveLyzeForcePush() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = LYZE_FORCE_PUSH.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
}
