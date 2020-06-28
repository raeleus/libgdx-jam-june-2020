package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveSnehksInvisible extends MoveSpecialTemplate {
    @Override
    public boolean canPerform(PerformerEntity performer) {
        if (performer.animationState.getCurrent(1) != null) return false;
        return super.canPerform(performer);
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = SNEHKS_INVISIBLE.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
        super.execute(performer);
        performer.animationState.setAnimation(1, SNEHKS_INVISIBLE_TIMED.animation, false);
        performer.animationState.addEmptyAnimation(1, 0, 0);
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/smoke.mp3");
            sound.play();
        }
    }
}
