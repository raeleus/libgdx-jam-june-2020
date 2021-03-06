package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveLyzeForcePush extends MoveSpecialTemplate {
    public MoveLyzeForcePush() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = LYZE_FORCE_PUSH.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    
        damage = 0f;
        force = 3000f;
        forceAngle = 30f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/woosh.mp3");
            sound.play();
        }
    }
}
