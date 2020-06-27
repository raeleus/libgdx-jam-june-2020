package com.ray3k.template.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.ray3k.template.*;

import static com.ray3k.template.screens.GameScreen.*;

public class CameraEntity extends Entity {
    public static final float PADDING = 200;
    public static final float PLAYER_HEIGHT = 300;
    public static final float WINDOW_MIN_X = -1000;
    public static final float WINDOW_MAX_X = 3000;
    public static final float WINDOW_MIN_Y = 0;
    public static final float WINDOW_MAX_Y = 2000;
    
    @Override
    public void create() {
    
    }
    
    @Override
    public void actBefore(float delta) {
    
    }
    
    @Override
    public void act(float delta) {
        var performers = new Array<PerformerEntity>();
        var points = new Array<PointOfInterest>();
        
        var entities = gameScreen.entityController.entities;
        for (int i = 0; i < entities.size; i++) {
            var entity = entities.get(i);
            if (entity instanceof PerformerEntity) performers.add((PerformerEntity) entity);
        }
        
        points.add(new PointOfInterest(1000, 1000));
        for (int i = 0; i < performers.size; i++) {
            var performer = performers.get(i);
            points.add(new PointOfInterest(performer.x, performer.y));
        }
        
        var point = points.first();
        var lowX = point.x;
        var highX = point.x;
        var lowY = point.y;
        var highY = point.y;
    
        for (int i = 0; i < points.size; i++) {
            point = points.get(i);
            
            if (point.x < lowX) lowX = point.x;
            if (point.x > highX) highX = point.x;
        
            if (point.y < lowY) lowY = point.y;
            if (point.y > highY) highY = point.y;
        }
    
        var width = highX - lowX + PADDING * 2;
        var height = highY - lowY + PADDING * 2 + PLAYER_HEIGHT;
        var midPointX = width / 2 + lowX - PADDING;
        var midPointY = height / 2 + lowY - PADDING;
        setPosition(midPointX, midPointY);
        
        var zoomX = width / Gdx.graphics.getWidth();
        var zoomY = height / Gdx.graphics.getHeight();
        var maxZoomX = (WINDOW_MAX_X - WINDOW_MIN_X) / Gdx.graphics.getWidth();
        var maxZoomY = (WINDOW_MAX_Y - WINDOW_MIN_Y) / Gdx.graphics.getHeight();
        
        gameScreen.camera.zoom = Math.min(Math.min(maxZoomX, maxZoomY), Math.max(zoomX, zoomY));
        if (x - Gdx.graphics.getWidth() * gameScreen.camera.zoom / 2 < WINDOW_MIN_X) x = WINDOW_MIN_X + Gdx.graphics.getWidth() * gameScreen.camera.zoom / 2;
        if (x + Gdx.graphics.getWidth() * gameScreen.camera.zoom / 2 > WINDOW_MAX_X) x = WINDOW_MAX_X - Gdx.graphics.getWidth() * gameScreen.camera.zoom / 2;
    
        if (y - Gdx.graphics.getHeight() * gameScreen.camera.zoom / 2 < WINDOW_MIN_Y) y = WINDOW_MIN_Y + Gdx.graphics.getHeight() * gameScreen.camera.zoom / 2;
        if (y + Gdx.graphics.getHeight() * gameScreen.camera.zoom / 2 > WINDOW_MAX_Y) y = WINDOW_MAX_Y - Gdx.graphics.getHeight() * gameScreen.camera.zoom / 2;
        gameScreen.camera.position.set(x, y, 0);
    }
    
    @Override
    public void draw(float delta) {
    
    }
    
    @Override
    public void destroy() {
    
    }
    
    private static class PointOfInterest {
        float x;
        float y;
    
        public PointOfInterest(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}
