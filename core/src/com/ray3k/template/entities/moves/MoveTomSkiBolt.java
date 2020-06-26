package com.ray3k.template.entities.moves;

import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;

public class MoveTomSkiBolt extends MoveSpecialTemplate {
    public MoveTomSkiBolt() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = MARIO_BLAST.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.TOM_SKI_BOLT;
            projectile.animationName = ProjectileAnimationName.STATIC;
            GameScreen.gameScreen.entityController.add(projectile);
            projectile.parent = performer;
            var projectileSpeed = 1200f;
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.setMotion(projectileSpeed, 180);
                projectile.skeleton.getRootBone().setScaleX(-1);
            }
            else projectile.setMotion(projectileSpeed, 0);
            projectile.acceleration = 0;
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    }
}
