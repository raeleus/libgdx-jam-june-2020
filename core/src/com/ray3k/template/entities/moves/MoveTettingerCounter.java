package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveTettingerCounter extends MoveSpecialTemplate {
    public MoveTettingerCounter() {
        airFriction = 400f;
        groundFriction = 400f;
        attackAnim = TETTINGER_COUNTER_ATTACK.animation;
        gravity = 2000f;
        vSpeed = 0f;
    
        damage = 2f;
        force = 4000f;
        forceAngle = 50f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/meow.mp3");
            sound.play();
        }
    }
}
