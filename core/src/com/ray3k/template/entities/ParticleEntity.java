package com.ray3k.template.entities;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;

import static com.ray3k.template.JamGame.*;

public class ParticleEntity extends Entity {
    public ParticleEffect particleEffect;
    
    public ParticleEntity(ParticleEffect templateEffect) {
        particleEffect = new ParticleEffect(templateEffect);
    }
    
    @Override
    public void create() {
        particleEffect.setPosition(x, y);
        particleEffect.reset(false);
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
        particleEffect.setPosition(x, y);
        particleEffect.update(delta);
    }
    
    @Override
    public void draw(float delta) {
        particleEffect.setPosition(x + deltaX * delta, y + deltaY * delta);
        particleEffect.draw(batch);
    }
    
    @Override
    public void destroy() {
        particleEffect.dispose();
    }
}
