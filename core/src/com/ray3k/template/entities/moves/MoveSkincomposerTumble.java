package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveSkincomposerTumble extends MoveSpecialTemplate {
    int mode;
    
    @Override
    public void execute(PerformerEntity performer) {
        attackAnim = SKIN_COMPOSER_TUMBLE.animation;
        vSpeed = 1f;
        groundFriction = 400f;
        airFriction = 400f;
        gravity = 2000f;
        mode = 0;
        super.execute(performer);
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
    
        var tackleSpeed = -1000f;
        if (performer.moveEvent) {
            switch (mode) {
                case 0:
                    performer.deltaY = 0;
                    if (performer.facingRight()) {
                        performer.deltaX += tackleSpeed;
                    } else {
                        performer.deltaX -= tackleSpeed;
                    }
                    gravity = 4000f;
                    break;
            }
            
            mode++;
        }
    }
}
