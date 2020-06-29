package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveJohnWhirlwind extends MoveSpecialTemplate {
    public MoveJohnWhirlwind() {
        airFriction = 400f;
        groundFriction = 400f;
        attackAnim = JOHN_WHIRLWIND.animation;
        gravity = 2000f;
        hSpeed = 700f;
        vSpeed = 200f;
    
        damage = 12f;
        force = 2000f;
        forceAngle = 30f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/grunt1.mp3");
            sound.play();
        }
    }
}
