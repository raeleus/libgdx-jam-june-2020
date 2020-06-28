package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveSkincomposerElectiricity extends MoveSpecialTemplate {
    public MoveSkincomposerElectiricity() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = SKIN_COMPOSER_ELECTRICITY.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/electricity.mp3");
            sound.play();
        }
    }
}
