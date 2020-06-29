package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveMarioUnblockablePunch extends MoveSpecialTemplate {
    public MoveMarioUnblockablePunch() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = MARIO_UNBLOCKABLE_PUNCH.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    
        damage = 25f;
        force = 2500f;
        forceAngle = 30f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/grunt2.mp3");
            sound.play();
        }
    }
}
