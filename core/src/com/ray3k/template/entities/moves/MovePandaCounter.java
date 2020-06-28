package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MovePandaCounter extends MoveSpecialTemplate {
    public MovePandaCounter() {
        airFriction = 400f;
        groundFriction = 400f;
        attackAnim = PANDA_COUNTER.animation;
        gravity = 2000f;
        vSpeed = 0f;
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
