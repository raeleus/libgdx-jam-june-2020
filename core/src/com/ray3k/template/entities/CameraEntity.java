package com.ray3k.template.entities;

import com.ray3k.template.screens.*;

public class CameraEntity extends Entity {
    @Override
    public void create() {
    
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
        GameScreen.gameScreen.camera.position.set(x, y + 150, 0);
    }
    
    @Override
    public void draw(float delta) {
    
    }
    
    @Override
    public void destroy() {
    
    }
}
