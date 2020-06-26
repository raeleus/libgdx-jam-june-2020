package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;

public class MovePayneNikita extends MoveSpecialTemplate {
    public MovePayneNikita() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = PAYNE_NIKITA.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.PAYNE_MISSILE;
            projectile.animationName = ProjectileAnimationName.STATIC;
            GameScreen.gameScreen.entityController.add(projectile);
            projectile.parent = performer;
            float projectileSpeed = 10f;
            if (!performer.facingRight()) {
                projectile.setMotion(projectileSpeed, 180);
                projectile.skeleton.getRootBone().setScaleX(-1);
            }
            else projectile.setMotion(projectileSpeed, 0);
            projectile.acceleration = 2000f;
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    }
}
