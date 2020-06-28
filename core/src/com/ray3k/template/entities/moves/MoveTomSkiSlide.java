package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveTomSkiSlide extends MoveSpecialTemplate {
    public MoveTomSkiSlide() {
        airFriction = 0f;
        groundFriction = 200f;
        attackAnim = ACE_SLIDE.animation;
        gravity = 2000f;
        hSpeed = 900f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/slide.mp3");
            sound.play();
        }
    }
}
