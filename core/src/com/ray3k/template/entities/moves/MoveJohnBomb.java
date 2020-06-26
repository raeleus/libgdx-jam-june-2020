package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;

public class MoveJohnBomb extends MoveSpecialTemplate {
    private static final float PROJECTILE_ANGLE = 70;
    private static final float PROJECTILE_SPEED = 500f;
    private static final float PROJECTILE_ACCELERATION = 0f;
    private static final float PROJECTILE_GRAVITY = 2500f;
    
    public MoveJohnBomb() {
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
            projectile.skinName = ProjectileSkinName.JOHN_BOMB;
            projectile.animationName = ProjectileAnimationName.STATIC;
            GameScreen.gameScreen.entityController.add(projectile);
            projectile.parent = performer;
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.setMotion(PROJECTILE_SPEED, 180 - PROJECTILE_ANGLE);
            }
            else {
                projectile.setMotion(PROJECTILE_SPEED, PROJECTILE_ANGLE);
            }
            projectile.acceleration = PROJECTILE_ACCELERATION;
            projectile.gravity = PROJECTILE_GRAVITY;
            projectile.landOnGround = true;
            projectile.groundFriction = 800f;
            projectile.lifeTimer = 2f;
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    }
}
