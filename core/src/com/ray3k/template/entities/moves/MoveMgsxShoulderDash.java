package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveMgsxShoulderDash extends MoveSpecialTemplate {
    int mode;
    
    public MoveMgsxShoulderDash() {
        attackAnim = MGSX_SHOULDER_DASH.animation;
        vSpeed = 1f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        super.execute(performer);
        groundFriction = 400f;
        airFriction = 400f;
        gravity = 0f;
        mode = 0;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
    
        var tackleSpeed = 3000f;
        if (performer.moveEvent) {
            switch (mode) {
                case 0:
                    performer.deltaY = 0;
                    if (performer.facingRight()) {
                        performer.deltaX += tackleSpeed;
                    } else {
                        performer.deltaX -= tackleSpeed;
                    }
                    groundFriction = 8000f;
                    airFriction = 8000f;
                    break;
                default:
                    gravity = 2000f;
                    break;
            }
            
            mode++;
        }
    }
}