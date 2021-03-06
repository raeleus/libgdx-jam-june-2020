package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveEvilentityTeleportUppercut extends MoveSpecialTemplate {
    private float timer;
    private static final float DISTANCE = 400f;
    public MoveEvilentityTeleportUppercut() {
        airFriction = 800f;
        groundFriction = 1400f;
        attackAnim = EVILENTITY_TELEPORT_UPPERCUT.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 1200f;
    
        damage = 18f;
        force = 2200f;
        forceAngle = 70f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        super.execute(performer);
        timer = .25f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        if (timer > 0) {
            timer -= delta;
            if (timer <= 0) {
                if (performer.skeleton.getRootBone().getScaleX() < 0) performer.x -= DISTANCE;
                else performer.x += DISTANCE;
            }
        }
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/woosh.mp3");
            sound.play();
        }
    }
}
