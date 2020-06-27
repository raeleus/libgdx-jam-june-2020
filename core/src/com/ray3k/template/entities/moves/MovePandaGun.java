package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;

public class MovePandaGun extends MoveSpecialTemplate {
    public MovePandaGun() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = MGSX_ARROW.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        super.execute(performer);
        projectileCountMax = 2;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.PANDA_PEANUT;
            projectile.animationName = ProjectileAnimationName.STATIC;
            projectile.parent = performer;
            GameScreen.gameScreen.entityController.add(projectile);
            projectile.parentMove = this;
            projectile.lifeTimer = 1.5f;
            var projectileSpeed = 700f;
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.setMotion(projectileSpeed, 180);
                projectile.skeleton.getRootBone().setScaleX(-1);
            }
            else projectile.setMotion(projectileSpeed, 0);
            projectile.acceleration = 0;
            projectile.setPosition(performer.projectileX, performer.projectileY);
            projectileCount++;
        }
    }
}
