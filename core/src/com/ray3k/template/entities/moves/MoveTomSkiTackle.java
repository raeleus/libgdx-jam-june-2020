package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveTomSkiTackle extends MoveSpecialTemplate {
    int mode;
    
    public MoveTomSkiTackle() {
        attackAnim = LYZE_TACKLE.animation;
        vSpeed = 1f;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 30f;
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
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/move-hammer.mp3");
            sound.play();
        }
    }
}
