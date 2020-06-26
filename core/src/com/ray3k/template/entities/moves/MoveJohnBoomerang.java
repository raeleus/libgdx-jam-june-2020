package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;

public class MoveJohnBoomerang extends MoveSpecialTemplate {
    public MoveJohnBoomerang() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = ALI_TOSS.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.JOHN_BOOMERANG;
            projectile.animationName = ProjectileAnimationName.JOHN_BOOMERANG;
            GameScreen.gameScreen.entityController.add(projectile);
            projectile.parent = performer;
            var projectileSpeed = 1500f;
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.setMotion(projectileSpeed, 170);
                projectile.skeleton.getRootBone().setScaleX(-1);
                projectile.accelerationH = 2000f;
            }
            else {
                projectile.setMotion(projectileSpeed, 10);
                projectile.accelerationH = -2000f;
            }
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    }
}
