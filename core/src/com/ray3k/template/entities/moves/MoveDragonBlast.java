package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveDragonBlast extends MoveSpecialTemplate {
    private static final float PROJECTILE_SPEED = 1000f;
    private static final float PROJECTILE_ACCELERATION = 0f;
    
    public MoveDragonBlast() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = MARIO_BLAST.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.DRAGON_FIREBALL;
            projectile.animationName = ProjectileAnimationName.STATIC;
            projectile.parent = performer;
            
            projectile.damage = 10f;
            projectile.force = 1800f;
            projectile.forceAngle = 20f;
            
            GameScreen.gameScreen.entityController.add(projectile);
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.setMotion(PROJECTILE_SPEED, 180);
                projectile.skeleton.getRootBone().setScaleX(-1);
            }
            else projectile.setMotion(PROJECTILE_SPEED, 0);
            projectile.acceleration = PROJECTILE_ACCELERATION;
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/move-fireball.mp3");
            sound.play();
        }
    }
}
