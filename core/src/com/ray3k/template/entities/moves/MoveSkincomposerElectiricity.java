package com.ray3k.template.entities.moves;

import static com.ray3k.template.AnimationName.*;

public class MoveSkincomposerElectiricity extends MoveSpecialTemplate {
    public MoveSkincomposerElectiricity() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = SKIN_COMPOSER_ELECTRICITY.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
}
