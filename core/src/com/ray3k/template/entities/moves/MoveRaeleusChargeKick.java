package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveRaeleusChargeKick extends MoveSpecialTemplate {
    public MoveRaeleusChargeKick() {
        attackAnim = RAELEUS_CHARGE_KICK.animation;
        vSpeed = 1f;
    
        damage = 20f;
        force = 2100f;
        forceAngle = 0f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        super.execute(performer);
        performer.deltaY = 0;
        gravity = 500f;
        airFriction = 0f;
        groundFriction = 1400f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.moveEvent) {
            performer.deltaY = -2000f;
        }
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/move-hammer.mp3");
            sound.play();
        }
    }
}
