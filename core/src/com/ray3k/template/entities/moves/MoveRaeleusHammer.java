package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveRaeleusHammer extends MoveSpecialTemplate {
    public MoveRaeleusHammer() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = RAELEUS_HAMMER.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 30f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/move-hammer.mp3");
            sound.play();
        }
    }
}
