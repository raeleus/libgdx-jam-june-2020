package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveDragonQueenSpirit extends MoveSpecialTemplate {
    @Override
    public void execute(PerformerEntity performer) {
        attackAnim = DRAGON_QUEEN_SPIRIT.animation;
        hSpeed = 800f;
        vSpeed = 1200f;
        gravity = 2000f;
        airFriction = 800f;
        groundFriction = 1400f;
    
        damage = 18f;
        force = 2200f;
        forceAngle = 70f;
        
        super.execute(performer);
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/flame.mp3");
            sound.play();
        }
    }
}
