package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveMgsxLogo extends MoveSpecialTemplate {
    public MoveMgsxLogo() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = MGSX_LOGO_ATTACK.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.MGSX_LOGO;
            projectile.animationName = ProjectileAnimationName.STATIC;
            projectile.parent = performer;
    
            projectile.damage = 20f;
            projectile.force = 3000f;
            projectile.forceAngle = 75f;
            
            GameScreen.gameScreen.entityController.add(projectile);
            projectile.lifeTimer = 1f;
            projectile.setPosition(performer.projectileX, performer.projectileY);
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.skeleton.getRootBone().setScaleX(-1);
            }
        }
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/energy-sword.mp3");
            sound.play();
        }
    }
}
