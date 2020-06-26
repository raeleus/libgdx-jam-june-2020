package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;
import com.ray3k.template.entities.PerformerEntity.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveLyzeDive extends MoveSpecialTemplate {
    public MoveLyzeDive() {
        airFriction = 400f;
        groundFriction = 400f;
        attackAnim = LYZE_DIVE.animation;
        gravity = 2000f;
        vSpeed = 600f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        if (performer.y < 0) {
            performer.mode = STANDING;
        }
        
        super.update(performer, delta);
        
        if (performer.moveEvent) {
            performer.deltaY = -2000f;
        }
    }
}
