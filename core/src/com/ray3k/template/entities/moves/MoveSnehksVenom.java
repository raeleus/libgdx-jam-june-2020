package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveSnehksVenom extends MoveSpecialTemplate {
    @Override
    public void execute(PerformerEntity performer) {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = SNEHKS_VENOM.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    
        damage = 5f;
        force = 2000f;
        forceAngle = 30f;
        
        super.execute(performer);
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.SNEHKS_VENOM;
            projectile.animationName = ProjectileAnimationName.STATIC;
            projectile.parent = performer;
            GameScreen.gameScreen.entityController.add(projectile);
            float projectileSpeed = 1500f;
            if (!performer.facingRight()) {
                projectile.setMotion(projectileSpeed, 180);
                projectile.skeleton.getRootBone().setScaleY(-1);
            }
            else projectile.setMotion(projectileSpeed, 0);
            projectile.acceleration = 0f;
            projectile.gravity = 2000f;
            projectile.rotateWithDirection = true;
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/snake.mp3");
            sound.play();
        }
    }
}
