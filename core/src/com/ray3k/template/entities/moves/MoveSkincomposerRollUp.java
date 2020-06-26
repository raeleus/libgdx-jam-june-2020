package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveSkincomposerRollUp extends MoveSpecialTemplate {
    int mode;
    
    @Override
    public void execute(PerformerEntity performer) {
        attackAnim = SKIN_COMPOSER_ROLL.animation;
        vSpeed = 1f;
        groundFriction = 400f;
        airFriction = 400f;
        gravity = 0f;
        mode = 0;
        super.execute(performer);
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
    
        var tackleSpeed = 4000f ;
        if (performer.moveEvent) {
            switch (mode) {
                case 0:
                    performer.deltaY = 0;
                    if (performer.facingRight()) {
                        performer.deltaX += tackleSpeed;
                    } else {
                        performer.deltaX -= tackleSpeed;
                    }
                    break;
                default:
                    gravity = 2000f;
                    groundFriction = 4000f;
                    airFriction = 3000f;
                    break;
            }
            
            mode++;
        }
        
        if (mode == 1) {
            performer.deltaY += 1500f * delta;
            if (performer.facingRight()) {
                performer.deltaX -= 10000f * delta;
            } else {
                performer.deltaX += 10000f * delta;
            }
        }
    }
}
