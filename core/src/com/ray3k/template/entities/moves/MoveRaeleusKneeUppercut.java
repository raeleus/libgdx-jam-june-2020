package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveRaeleusKneeUppercut extends MoveSpecialTemplate {
    @Override
    public void execute(PerformerEntity performer) {
        attackAnim = RAELEUS_KNEE_UPPERCUT.animation;
        hSpeed = 800f;
        vSpeed = 1200f;
        gravity = 2000f;
        airFriction = 800f;
        groundFriction = 1400f;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 50f;
        
        super.execute(performer);
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/move-knee.mp3");
            sound.play();
        }
    }
}
