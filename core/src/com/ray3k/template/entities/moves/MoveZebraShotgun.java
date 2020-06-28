package com.ray3k.template.entities.moves;

import com.badlogic.gdx.math.MathUtils;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;

public class MoveZebraShotgun extends MoveSpecialTemplate {
    private static final float PROJECTILE_SPEED = 2000f;
    private static final float PROJECTILE_ACCELERATION = 0f;
    
    public MoveZebraShotgun() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = ZEBRA_SHOTGUN.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            for (int i = 0; i < 6; i++) {
                var projectile = new Projectile();
                projectile.skinName = ProjectileSkinName.ZEBRA_BULLET;
                projectile.animationName = ProjectileAnimationName.STATIC;
                projectile.rotateWithDirection = true;
                projectile.parent = performer;
                GameScreen.gameScreen.entityController.add(projectile);
                if (performer.skeleton.getRootBone().getScaleX() < 0) {
                    projectile.setMotion(PROJECTILE_SPEED, 145 + MathUtils.random(90));
                    projectile.skeleton.getRootBone().setScaleX(-1);
                } else {
                    projectile.setMotion(PROJECTILE_SPEED, 315 + MathUtils.random(90));
                }
                projectile.acceleration = PROJECTILE_ACCELERATION;
                projectile.setPosition(performer.projectileX, performer.projectileY);
            }
        }
    }
}
