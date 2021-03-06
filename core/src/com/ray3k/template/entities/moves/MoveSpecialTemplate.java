package com.ray3k.template.entities.moves;

import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.Animation;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class MoveSpecialTemplate implements Move {
    public final static float H_SPEED = 800f;
    public final static float H_ACCELERATION = 2400f;
    
    public float airFriction = 500f;
    public float groundFriction = 1400f;
    public static float gravity = 2000f;
    public Animation attackAnim = GENERAL_AIR_PUNCH.animation;
    public float hSpeed;
    public float vSpeed;
    public int projectileCountMax;
    public int projectileCount;
    public float damage = 10f;
    public float force = 2000f;
    public float forceAngle = 30f;
    
    @Override
    public boolean canPerform(PerformerEntity performer) {
        if (projectileCountMax > 0 && projectileCount >= projectileCountMax) return false;
        
        return performer.mode == STANDING || performer.mode == MOVING || performer.mode == JUMPING && performer.touchedGround;
    }
    
    @Override
    public void execute(PerformerEntity performer) {
        performer.animationState.setAnimation(0, attackAnim, false);
        
        if (!MathUtils.isZero(hSpeed)) {
            performer.deltaX = hSpeed;
            if (performer.skeleton.getRootBone().getScaleX() < 0) performer.deltaX *= -1f;
        }
    
        if (!MathUtils.isZero(vSpeed)) {
            performer.deltaY = vSpeed;
            performer.mode = JUMP_ATTACKING;
        }
        
        performer.touchedGround = false;
    
        performer.damage = damage;
        performer.force = force;
        performer.forceAngle = forceAngle;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        performer.gravityY = -gravity;
        if (performer.onGround) {
            performer.deltaX = Utils.approach(performer.deltaX, 0, groundFriction * delta);
            if (performer.animationState.getCurrent(0).isComplete()) performer.mode = STANDING;
        } else {
            performer.deltaX = Utils.approach(performer.deltaX, 0, airFriction * delta);
            if (performer.animationState.getCurrent(0).isComplete()) {
                if (performer.steering.left) performer.deltaX = Utils.approach(performer.deltaX, -H_SPEED, H_ACCELERATION * delta);
                else if (performer.steering.right) performer.deltaX = Utils.approach(performer.deltaX, H_SPEED, H_ACCELERATION * delta);
            }
        }
    }
    
    @Override
    public void continueExecution(PerformerEntity performer) {
    
    }
}
