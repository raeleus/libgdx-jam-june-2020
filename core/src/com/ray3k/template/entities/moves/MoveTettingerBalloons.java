package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveTettingerBalloons extends MoveSpecialTemplate {
    public MoveTettingerBalloons() {
        attackAnim = TETTINGER_BALLOON.animation;
        hSpeed = 0f;
        vSpeed = 10f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        super.execute(performer);
        airFriction = 0f;
        groundFriction = 0f;
        gravity = -500f;
        performer.animationCompleteEvent = false;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.animationCompleteEvent) {
            gravity = 2000f;
        }
    }
}
