package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveRaeleusChargeKick extends MoveSpecialTemplate {
    public MoveRaeleusChargeKick() {
        attackAnim = RAELEUS_CHARGE_KICK.animation;
        vSpeed = 1f;
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
    }
}
