package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveLyzeTackle extends MoveSpecialTemplate {
    int mode;
    public MoveLyzeTackle() {
        attackAnim = LYZE_TACKLE.animation;
        vSpeed = 1f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        super.execute(performer);
        groundFriction = 400f;
        airFriction = 400f;
        gravity = 0f;
        mode = 0;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 30f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        var tackleSpeed = 1500f;
        if (performer.moveEvent) {
            switch (mode) {
                case 0:
                    performer.deltaY = 0;
                    if (performer.facingRight()) {
                        performer.deltaX += tackleSpeed;
                    } else {
                        performer.deltaX -= tackleSpeed;
                    }
                    groundFriction = 400f;
                    airFriction = 400f;
                    break;
                default:
                    gravity = 2000f;
                    break;
            }
            
            mode++;
        }
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/jet.mp3");
            sound.play();
        }
    }
}
