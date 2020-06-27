package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;

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
            GameScreen.gameScreen.entityController.add(projectile);
            projectile.lifeTimer = 1f;
            projectile.setPosition(performer.projectileX, performer.projectileY);
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.skeleton.getRootBone().setScaleX(-1);
            }
        }
    }
}
