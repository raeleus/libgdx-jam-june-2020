package com.ray3k.template.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.esotericsoftware.spine.*;
import com.esotericsoftware.spine.utils.SkeletonDrawable;
import com.ray3k.template.*;

import static com.ray3k.template.Core.*;

public class LibgdxScreen extends JamScreen {
    private Stage stage;
    private Array<SkeletonDrawable> skeletonDrawables;
    private final static Color BG_COLOR = new Color(Color.WHITE);
    private ObjectSet<Sound> sounds;
    
    @Override
    public void show() {
        super.show();

        skeletonDrawables = new Array<>();
        sounds = new ObjectSet<>();
        
        Skeleton skeleton = new Skeleton(assetManager.get("spine/libgdx.json", SkeletonData.class));
        AnimationState animationState = new AnimationState(assetManager.get("spine/libgdx.json-animation", AnimationStateData.class));
        SkeletonDrawable skeletonDrawable = new SkeletonDrawable(skeletonRenderer, skeleton, animationState);
        skeletonDrawable.setMinWidth(350);
        skeletonDrawable.setMinHeight(250);
        skeletonDrawable.getAnimationState().setAnimation(0, "stand", false);
        skeletonDrawable.getAnimationState().apply(skeletonDrawable.getSkeleton());
        skeletonDrawables.add(skeletonDrawable);
        
        stage = new Stage(new ScreenViewport(), batch);
        Gdx.input.setInputProcessor(stage);
        
        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);
    
        Image image = new Image(skeletonDrawable);
        image.setScaling(Scaling.none);
        root.add(image);
        skeletonDrawable.getAnimationState().setAnimation(0, "animation", false);
    
        skeletonDrawable.getAnimationState().addListener(new AnimationState.AnimationStateAdapter() {
            @Override
            public void complete(AnimationState.TrackEntry entry) {
                if (entry.getAnimation().getName().equals("animation")) {
                    core.transition(new LogoScreen());
                }
            }
    
            @Override
            public void event(AnimationState.TrackEntry entry, Event event) {
                if (event.getData().getAudioPath() != null && !event.getData().getAudioPath().equals("")) {
                    Sound sound = assetManager.get("sfx/" + event.getData().getAudioPath());
                    sound.play();
                    sounds.add(sound);
                }
            }
        });
        
        stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                core.transition(new LogoScreen());
                return true;
            }
    
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                core.transition(new LogoScreen());
                return true;
            }
        });
    }
    
    @Override
    public void act(float delta) {
        stage.act(delta);
        
        for (SkeletonDrawable skeletonDrawable : skeletonDrawables) {
            skeletonDrawable.update(delta);
        }
    }
    
    @Override
    public void draw(float delta) {
        Gdx.gl.glClearColor(BG_COLOR.r, BG_COLOR.g, BG_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        stage.draw();
    }
    
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
    
    @Override
    public void hide() {
        super.hide();
        for (Sound sound : sounds) {
            sound.stop();
        }
    }
}
