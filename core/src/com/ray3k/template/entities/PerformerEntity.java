package com.ray3k.template.entities;

import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.spine.AnimationState.AnimationStateAdapter;
import com.esotericsoftware.spine.AnimationState.TrackEntry;
import com.esotericsoftware.spine.Event;
import com.ray3k.template.*;
import com.ray3k.template.entities.moves.*;
import com.ray3k.template.entities.movesets.*;
import com.ray3k.template.entities.steering.*;

import static com.ray3k.template.entities.PerformerEntity.Mode.*;

public class PerformerEntity extends Entity {
    public SkinName skinName;
    public Steering steering;
    public MoveSet moveSet;
    public Move currentMove;
    public Mode mode;
    public boolean touchedGround;
    public boolean fireProjectileEvent;
    public float projectileX;
    public float projectileY;
    public boolean moveEvent;
    public boolean animationCompleteEvent;
    public enum Mode {
        MOVING, ATTACKING, JUMPING, JUMP_ATTACKING, STANDING, SHIELDING;
    }
    public static final Vector2 temp = new Vector2();
    
    public PerformerEntity(SkinName skinName) {
        this.skinName = skinName;
    }
    
    @Override
    public void create() {
        setSkeletonData(Core.assetManager.get("spine/fighter.json"), Core.assetManager.get("spine/fighter.json-animation"));
        skeleton.setSkin(skinName.skin);
        steering = new P1Steering();
        moveSet = skinName.moveSet;
        mode = Mode.STANDING;
        currentMove = moveSet.stance;
        currentMove.execute(this);
        touchedGround = true;
        
        animationState.addListener(new AnimationStateAdapter() {
            @Override
            public void complete(TrackEntry entry) {
                super.end(entry);
                animationCompleteEvent = true;
            }
    
            @Override
            public void event(TrackEntry entry, Event event) {
                switch (event.getData().getName()) {
                    case "fire-projectile":
                        fireProjectileEvent = true;
                        temp.set(0, 0);
                        skeleton.findBone("projectile-origin").localToWorld(temp);
                        projectileX = temp.x;
                        projectileY = temp.y;
                        break;
                    case "move":
                        moveEvent = true;
                        break;
                }
            }
        });
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
        steering.update(delta);
        
        Move newMove = null;
        Mode newMode = null;
        if (steering.left) {
            newMode = MOVING;
            newMove = moveSet.goLeft;
        } else if (steering.right) {
            newMode = MOVING;
            newMove = moveSet.goRight;
        } else {
            newMode = STANDING;
            newMove = moveSet.stance;
        }
        
        if (steering.jump) {
            newMode = JUMPING;
            newMove = moveSet.jump;
        }
        
        if (steering.attack) {
            if (mode == JUMPING) {
                newMode = JUMP_ATTACKING;
                newMove = moveSet.jumpAttack;
            } else if (steering.right || steering.left) {
                newMode = ATTACKING;
                newMove = moveSet.attackSide;
            } else if (steering.up) {
                newMode = ATTACKING;
                newMove = moveSet.attackUp;
            } else if (steering.down) {
                newMode = ATTACKING;
                newMove = moveSet.attackDown;
            } else {
                newMode = ATTACKING;
                newMove = moveSet.attackNeutral;
            }
        } else if (steering.special) {
            if (steering.right || steering.left) {
                newMode = ATTACKING;
                newMove = moveSet.specialSide;
            } else if (steering.up) {
                newMode = ATTACKING;
                newMove = moveSet.specialUp;
            } else if (steering.down) {
                newMode = ATTACKING;
                newMove = moveSet.specialDown;
            } else {
                newMode = ATTACKING;
                newMove = moveSet.specialNeutral;
            }
        }
        
        if (newMove != null && newMove != currentMove && newMove.canPerform(this)) {
            currentMove = newMove;
            mode = newMode;
            currentMove.execute(this);
        }
        
        currentMove.update(this, delta);
        fireProjectileEvent = false;
        moveEvent = false;
        animationCompleteEvent = false;
    }
    
    @Override
    public void draw(float delta) {
    
    }
    
    @Override
    public void destroy() {
    
    }
    
    public boolean facingRight() {
        return skeleton.getRootBone().getScaleX() > 0;
    }
}
