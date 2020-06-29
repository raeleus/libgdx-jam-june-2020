package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveAceBone extends MoveSpecialTemplate {
    private static final float PROJECTILE_SPEED = 10f;
    private static final float PROJECTILE_ACCELERATION = 2000f;
    
    public MoveAceBone() {
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
        Sound sound = assetManager.get("sfx/move-bone.mp3");
        sound.play();
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.ACE_BONE;
            projectile.animationName = ProjectileAnimationName.JOHN_BOOMERANG;
            projectile.parent = performer;
            projectile.damage = 15f;
            projectile.force = 2000f;
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
