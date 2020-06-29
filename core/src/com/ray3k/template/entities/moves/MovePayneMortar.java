package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MovePayneMortar extends MoveSpecialTemplate {
    private static final float PROJECTILE_ANGLE = 90;
    private static final float PROJECTILE_SPEED = 2000f;
    private static final float PROJECTILE_ACCELERATION = 0f;
    private static final float PROJECTILE_GRAVITY = 2500f;
    
    public MovePayneMortar() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = PAYNE_MORTAR.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    
        damage = 10f;
        force = 2000f;
        forceAngle = 90f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.PAYNE_MISSILE;
            projectile.animationName = ProjectileAnimationName.STATIC;
            projectile.parent = performer;
    
            projectile.damage = 10f;
            projectile.force = 2000f;
            projectile.forceAngle = 30f;
            
            GameScreen.gameScreen.entityController.add(projectile);
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.setMotion(PROJECTILE_SPEED, 180 - PROJECTILE_ANGLE);
            }
            else {
                projectile.setMotion(PROJECTILE_SPEED, PROJECTILE_ANGLE);
            }
            projectile.acceleration = PROJECTILE_ACCELERATION;
            projectile.gravity = PROJECTILE_GRAVITY;
            projectile.landOnGround = false;
            projectile.groundFriction = 800f;
            projectile.lifeTimer = 2f;
            projectile.rotateWithDirection = true;
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/mortar.mp3");
            sound.play();
        }
    }
}
