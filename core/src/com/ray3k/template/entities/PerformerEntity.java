package com.ray3k.template.entities;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.dongbat.jbump.Collision;
import com.dongbat.jbump.Item;
import com.esotericsoftware.spine.AnimationState.AnimationStateAdapter;
import com.esotericsoftware.spine.AnimationState.TrackEntry;
import com.esotericsoftware.spine.Event;
import com.esotericsoftware.spine.Slot;
import com.esotericsoftware.spine.attachments.BoundingBoxAttachment;
import com.ray3k.template.*;
import com.ray3k.template.entities.moves.*;
import com.ray3k.template.entities.movesets.*;
import com.ray3k.template.entities.steering.*;

import static com.ray3k.template.entities.PerformerEntity.Mode.*;
import static com.ray3k.template.screens.GameScreen.*;

public class PerformerEntity extends Entity implements Bumpable {
    public SkinName skinName;
    public Steering steering;
    public MoveSet moveSet;
    public Move currentMove;
    public Mode mode;
    public boolean touchedGround;
    public boolean onGround;
    public boolean fireProjectileEvent;
    public float projectileX;
    public float projectileY;
    public boolean moveEvent;
    public boolean animationCompleteEvent;
    public float width;
    public float height;
    public Item<Entity> item;
    public Slot hitBoxSlot;
    public HitboxEntity hitbox;
    public HurtboxEntity hurtbox;
    public Slot hurtBoxSlot;
    public float health;
    public int lives;
    public boolean onPlatform;
    public float platformTimer;
    public static final float PLATFORM_DELAY = .25f;
    public enum Mode {
        MOVING, ATTACKING, JUMPING, JUMP_ATTACKING, STANDING, SHIELDING;
    }
    public static final Vector2 temp = new Vector2();
    private boolean teleporting;
    
    public PerformerEntity(SkinName skinName, Steering steering, int lives) {
        this.skinName = skinName;
        width = 100;
        height = 300;
        item = new Item<>();
        item.userData = this;
        this.steering = steering;
        this.lives = lives;
    }
    
    @Override
    public void create() {
        setSkeletonData(Core.assetManager.get("spine/fighter.json"), Core.assetManager.get("spine/fighter.json-animation"));
        skeleton.setSkin(skinName.skin);
        hitBoxSlot = skeleton.findSlot("hitbox");
        hurtBoxSlot = skeleton.findSlot("bbox");
        moveSet = skinName.moveSet;
        mode = Mode.STANDING;
        currentMove = moveSet.stance;
        currentMove.execute(this);
        touchedGround = true;
        hitbox = new HitboxEntity();
        gameScreen.entityController.add(hitbox);
        hurtbox = new HurtboxEntity();
        gameScreen.entityController.add(hurtbox);
        hitBoxWorld.add(new Item<>(hurtbox), 0, 0, 0, 0);
        
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
        
        hitbox.active = hitBoxSlot.getAttachment() != null;
        if (hitbox.active) {
            hitbox.rectangle.set(Utils.verticesToAABB(skeletonBounds.getPolygon((BoundingBoxAttachment) hitBoxSlot.getAttachment())));
        }
    
        hurtbox.active = hurtBoxSlot.getAttachment() != null;
        if (hurtbox.active) {
            hurtbox.rectangle.set(Utils.verticesToAABB(skeletonBounds.getPolygon((BoundingBoxAttachment) hurtBoxSlot.getAttachment())));
        }
        
        if (y < -400) {
            lives--;
            if (lives < 0) destroy = true;
            else {
                setPosition(1000, 3500);
                teleporting = true;
                deltaX = 0;
                deltaY = 0;
            }
        }
    }
    
    @Override
    public void draw(float delta) {
//        var g = gameScreen.shapeDrawer;
//        g.setColor(DEBUG_COLOR);
//        var rect = gameScreen.entityController.world.getRect(item);
//        g.setDefaultLineWidth(5f);
//        g.rectangle(rect.x, rect.y, rect.w, rect.h);
        
//        var g = gameScreen.shapeDrawer;
//        if (hitBoxSlot.getAttachment() != null) {
//            var hitbox = (BoundingBoxAttachment) hitBoxSlot.getAttachment();
//            g.setColor(Color.RED);
//            g.filledRectangle(Utils.verticesToAABB(skeletonBounds.getPolygon(hitbox)));
//        }
        
//        if (hurtBoxSlot.getAttachment() != null) {
//            var hurtbox = (BoundingBoxAttachment) hurtBoxSlot.getAttachment();
//            g.setColor(Color.GREEN);
//            g.filledRectangle(Utils.verticesToAABB(skeletonBounds.getPolygon(hurtbox)));
//        }
    }
    
    @Override
    public void destroy() {
        hitbox.destroy = true;
        hurtbox.destroy = true;
    }
    
    public boolean facingRight() {
        return skeleton.getRootBone().getScaleX() > 0;
    }
    
    
    @Override
    public float getBumpX() {
        return x - 50;
    }
    
    @Override
    public float getBumpY() {
        return y;
    }
    
    @Override
    public float getBumpWidth() {
        return width;
    }
    
    @Override
    public float getBumpHeight() {
        return height;
    }
    
    @Override
    public Item<Entity> getItem() {
        return item;
    }
    
    @Override
    public void setItem(Item<Entity> item) {
        this.item = item;
    }
    
    @Override
    public void updateEntityPosition(float x, float y) {
        setPosition(x + 50, y);
    }
    
    @Override
    public void collisions(Array<Entity> touched, Array<Collision> collisions) {
        for (int i = 0; i < touched.size; i++) {
            if (!MathUtils.isZero(collisions.get(i).normal.y) && collisions.get(i).move.y < 0) {
                onGround = true;
                gravityY = 0;
                
                if (!onPlatform) platformTimer = PLATFORM_DELAY;
                onPlatform = touched.get(i) instanceof PlatformEntity;
            }
        }
    }
    
    @Override
    public boolean isTeleporting() {
        return teleporting;
    }
    
    @Override
    public void setTeleporting(boolean teleporting) {
        this.teleporting = teleporting;
    }
}
