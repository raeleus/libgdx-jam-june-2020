package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveAliLaser extends MoveSpecialTemplate {
    public MoveAliLaser() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = ALI_LASER.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        super.execute(performer);
        Sound sound = assetManager.get("sfx/laser.mp3");
        sound.play();
    }
}
