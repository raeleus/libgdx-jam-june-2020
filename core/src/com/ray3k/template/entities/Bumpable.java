package com.ray3k.template.entities;

import com.dongbat.jbump.Item;

public interface Bumpable {
    public float getBumpX();
    public float getBumpY();
    public float getBumpWidth();
    public float getBumpHeight();
    public Item<Entity> getItem();
    public void setItem(Item<Entity> item);
    public void updateEntityPosition(float x, float y);
}
