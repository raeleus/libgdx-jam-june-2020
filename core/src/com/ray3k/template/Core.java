package com.ray3k.template;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.esotericsoftware.spine.AnimationStateData;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonRenderer;
import com.ray3k.template.AnimationStateDataLoader.*;
import com.ray3k.template.screens.*;
import com.ray3k.template.transitions.*;

public class Core extends JamGame {
    public static final String PROJECT_NAME = "LIBGDX VS RAY3K";
    public static Core core;
    public static Skin skin;
    public static SkeletonRenderer skeletonRenderer;
    public static ChangeListener sndChangeListener;
    public static CrossPlatformWorker crossPlatformWorker;
    public enum Binding {
        P1_LEFT, P1_RIGHT, P1_UP, P1_DOWN, P1_JUMP, P1_ATTACK, P1_SHIELD, P1_SPECIAL, P2_LEFT, P2_RIGHT, P2_UP, P2_DOWN, P2_JUMP, P2_ATTACK, P2_SHIELD, P2_SPECIAL;
    }
    public static float bgm;
    public static float sfx;
    public static Preferences preferences;
    
    @Override
    public void create() {
        super.create();
        core = this;
        
        preferences = Gdx.app.getPreferences(PROJECT_NAME);
        
        bgm = preferences.getFloat("bgm", 1.0f);
        sfx = preferences.getFloat("sfx", 1.0f);
        
        setDefaultBindings();
        JamScreen.loadBindings();
        
        skeletonRenderer = new SkeletonRenderer();
        skeletonRenderer.setPremultipliedAlpha(true);
        
        sndChangeListener = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                assetManager.get("sfx/click.mp3", Sound.class).play();
            }
        };
        
        setScreen(new LoadScreen(() -> {
            skin = assetManager.get("skin/libgdx vs ray3k.json");
        }));
        defaultTransition = Transitions.colorFade(Color.BLACK);
        defaultTransitionDuration = .5f;
    }
    
    @Override
    public void render() {
        super.render();
    }
    
    @Override
    public void loadAssets() {
        assetManager.setLoader(Skin.class, new SkinFreeTypeLoader(assetManager.getFileHandleResolver()));
        assetManager.setLoader(SkeletonData.class, new SkeletonDataLoader(assetManager.getFileHandleResolver()));
        assetManager.setLoader(AnimationStateData.class, new AnimationStateDataLoader(assetManager.getFileHandleResolver()));
        
        String textureAtlasPath = null;
        var fileHandle = Gdx.files.internal("textures.txt");
        if (fileHandle.exists()) for (String path : fileHandle.readString().split("\\n")) {
            assetManager.load(path, TextureAtlas.class);
            textureAtlasPath = path;
        }
        
        fileHandle = Gdx.files.internal("skin.txt");
        if (fileHandle.exists()) for (String path : fileHandle.readString().split("\\n")) {
            assetManager.load(path, Skin.class, new SkinParameter(textureAtlasPath));
        }
    
        fileHandle = Gdx.files.internal("bgm.txt");
        if (fileHandle.exists()) for (String path : fileHandle.readString().split("\\n")) {
            assetManager.load(path, Music.class);
        }
    
        fileHandle = Gdx.files.internal("sfx.txt");
        if (fileHandle.exists()) for (String path : fileHandle.readString().split("\\n")) {
            assetManager.load(path, Sound.class);
        }
    
        
        fileHandle = Gdx.files.internal("spine.txt");
        if (fileHandle.exists()) for (String path2 : fileHandle.readString().split("\\n")) {
            assetManager.load(path2 + "-animation", AnimationStateData.class, new AnimationStateDataParameter(path2, textureAtlasPath));
        }
    }
    
    public void setDefaultBindings() {
        JamScreen.addKeyBinding(Binding.P1_LEFT, Keys.A);
        JamScreen.addKeyBinding(Binding.P1_RIGHT, Keys.D);
        JamScreen.addKeyBinding(Binding.P1_UP, Keys.W);
        JamScreen.addKeyBinding(Binding.P1_DOWN, Keys.S);
        JamScreen.addKeyBinding(Binding.P1_JUMP, Keys.G);
        JamScreen.addKeyBinding(Binding.P1_SHIELD, Keys.H);
        JamScreen.addKeyBinding(Binding.P1_ATTACK, Keys.F);
        JamScreen.addKeyBinding(Binding.P1_SPECIAL, Keys.T);
        JamScreen.addKeyBinding(Binding.P2_LEFT, Keys.LEFT);
        JamScreen.addKeyBinding(Binding.P2_RIGHT, Keys.RIGHT);
        JamScreen.addKeyBinding(Binding.P2_UP, Keys.UP);
        JamScreen.addKeyBinding(Binding.P2_DOWN, Keys.DOWN);
        JamScreen.addKeyBinding(Binding.P2_JUMP, Keys.NUMPAD_5);
        JamScreen.addKeyBinding(Binding.P2_SHIELD, Keys.NUMPAD_6);
        JamScreen.addKeyBinding(Binding.P2_ATTACK, Keys.NUMPAD_4);
        JamScreen.addKeyBinding(Binding.P2_SPECIAL, Keys.NUMPAD_8);
    }
}
