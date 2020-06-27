package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;

public class MoveTettingerYarn extends MoveSpecialTemplate {
    private static final float PROJECTILE_ANGLE = 80;
    private static final float PROJECTILE_SPEED = 800f;
    private static final float PROJECTILE_ACCELERATION = 0f;
    private static final float PROJECTILE_GRAVITY = 2000f;
    
    public MoveTettingerYarn() {
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
            projectile.skinName = ProjectileSkinName.TETTINGER_YARN;
            projectile.animationName = ProjectileAnimationName.STATIC;
            projectile.parent = performer;
            GameScreen.gameScreen.entityController.add(projectile);
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.setMotion(PROJECTILE_SPEED, 180 - PROJECTILE_ANGLE);
                projectile.skeleton.getRootBone().setScaleX(-1);
            }
            else {
                projectile.setMotion(PROJECTILE_SPEED, PROJECTILE_ANGLE);
            }
            projectile.acceleration = PROJECTILE_ACCELERATION;
            projectile.gravity = PROJECTILE_GRAVITY;
            projectile.groundFriction = 800f;
            projectile.lifeTimer = 5f;
            projectile.bounce = true;
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    }
}
