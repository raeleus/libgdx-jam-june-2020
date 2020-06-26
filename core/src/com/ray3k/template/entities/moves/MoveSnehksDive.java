package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveSnehksDive extends MoveSpecialTemplate {
    @Override
    public void execute(PerformerEntity performer) {
        attackAnim = SNEHKS_DIVE.animation;
        hSpeed = 300f;
        vSpeed = 3000f;
        gravity = 8000f;
        airFriction = 800f;
        groundFriction = 1400f;
        super.execute(performer);
    }
}
