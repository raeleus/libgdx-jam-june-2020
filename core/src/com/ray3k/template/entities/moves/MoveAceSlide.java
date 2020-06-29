package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveAceSlide extends MoveSpecialTemplate {
    public MoveAceSlide() {
        airFriction = 0f;
        groundFriction = 1000f;
        attackAnim = ACE_SLIDE.animation;
        gravity = 2000f;
        hSpeed = 900f;
        vSpeed = 0f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        damage = 12f;
        force = 2500;
        forceAngle = 85;
        super.execute(performer);
        
        Sound sound = assetManager.get("sfx/slide.mp3");
        sound.play();
    }
}
