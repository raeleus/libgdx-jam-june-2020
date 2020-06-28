package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;

public class MoveZebraRifle extends MoveSpecialTemplate {
    private static final float PROJECTILE_SPEED = 2000f;
    private static final float PROJECTILE_ACCELERATION = 0f;
    
    public MoveZebraRifle() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = ZEBRA_RIFLE.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.ZEBRA_BULLET;
            projectile.animationName = ProjectileAnimationName.STATIC;
            projectile.parent = performer;
            GameScreen.gameScreen.entityController.add(projectile);
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.setMotion(PROJECTILE_SPEED, 180);
                projectile.skeleton.getRootBone().setScaleX(-1);
            }
            else projectile.setMotion(PROJECTILE_SPEED, 0);
            projectile.acceleration = PROJECTILE_ACCELERATION;
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    }
}
