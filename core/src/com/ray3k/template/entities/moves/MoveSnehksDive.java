package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveSnehksDive extends MoveSpecialTemplate {
    @Override
    public void execute(PerformerEntity performer) {
        attackAnim = SNEHKS_DIVE.animation;
        hSpeed = 300f;
        vSpeed = 3000f;
        gravity = 8000f;
        airFriction = 800f;
        groundFriction = 1400f;
    
        damage = 20f;
        force = 2500f;
        forceAngle = 25f;
        
        super.execute(performer);
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/snake.mp3");
            sound.play();
        }
    }
}
