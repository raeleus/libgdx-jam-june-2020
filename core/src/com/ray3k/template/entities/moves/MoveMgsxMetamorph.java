package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveMgsxMetamorph extends MoveSpecialTemplate {
    public MoveMgsxMetamorph() {
        airFriction = 400f;
        groundFriction = 400f;
        attackAnim = MGSX_METAMORPH.animation;
        gravity = 2000f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.moveEvent) {
            performer.deltaY = -2000f;
        }
    }
}
