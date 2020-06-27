package com.ray3k.template.entities;

import com.badlogic.gdx.utils.Array;
import com.dongbat.jbump.Collision;
import com.dongbat.jbump.Item;

interface Bumpable {
    float getBumpX();
    float getBumpY();
    float getBumpWidth();
    float getBumpHeight();
    Item<Entity> getItem();
    void setItem(Item<Entity> item);
    void updateEntityPosition(float x, float y);
    void collisions(Array<Entity> touched, Array<Collision> collisions);
    default boolean isTeleporting() {
        return false;
    }
    default void setTeleporting(boolean teleporting) {
    
    }
}
