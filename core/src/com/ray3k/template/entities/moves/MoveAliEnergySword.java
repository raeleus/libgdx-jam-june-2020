package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveAliEnergySword extends MoveSpecialTemplate {
    public MoveAliEnergySword() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = ALI_ENERGY_SWORD.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
}
