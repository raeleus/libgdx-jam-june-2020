package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MovePandaCrown extends MoveSpecialTemplate {
    public MovePandaCrown() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = ALI_TOSS.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        super.execute(performer);
        projectileCountMax = 1;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.PANDA_CROWN;
            projectile.animationName = ProjectileAnimationName.JOHN_BOOMERANG;
            projectile.parent = performer;
    
            projectile.damage = 10f;
            projectile.force = 2000f;
            projectile.forceAngle = 30f;
            
            GameScreen.gameScreen.entityController.add(projectile);
            projectile.parentMove = this;
            projectile.lifeTimer = 2f;
            var projectileSpeed = 1500f;
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.setMotion(projectileSpeed, 180);
                projectile.skeleton.getRootBone().setScaleX(-1);
                projectile.accelerationH = 2000f;
            }
            else {
                projectile.setMotion(projectileSpeed, 0);
                projectile.accelerationH = -2000f;
            }
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/woosh1.mp3");
            sound.play();
        }
    }
}
