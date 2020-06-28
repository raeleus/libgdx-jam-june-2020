package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveAliEnergySword extends MoveSpecialTemplate {
    public MoveAliEnergySword() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = ALI_ENERGY_SWORD.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/energy-sword.mp3");
            sound.play();
        }
    }
}
