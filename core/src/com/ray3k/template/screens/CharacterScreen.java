package com.ray3k.template.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ray3k.template.*;

import static com.ray3k.template.Core.*;

public class CharacterScreen extends JamScreen {
    private Stage stage;
    private final static Color BG_COLOR = new Color(Color.BLACK);
    public String title;
    public int playerIndex;
    
    public CharacterScreen(String title, int playerIndex) {
        this.title = title;
        this.playerIndex = playerIndex;
    }
    
    @Override
    public void show() {
        super.show();
        if (bgmMusic != null) bgmMusic.setVolume(bgm * .25f);
        
        stage = new Stage(new ScreenViewport(), batch);
        Gdx.input.setInputProcessor(stage);
    
        sceneBuilder.build(stage, skin, Gdx.files.internal("menus/character.json"));
        
        Label label = stage.getRoot().findActor("label");
        label.setText(title);
        
        var table = (Table) stage.getRoot().getChild(0);
        for (var child : table.getChildren()) {
            if (child instanceof ImageButton) {
                var imageButton = (ImageButton) child;
                imageButton.addListener(sndChangeListener);
                imageButton.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        String name = imageButton.getName();
                        Sound sound = assetManager.get("sfx/name-" + name + ".mp3");
                        sound.play();
                        
                        switch (playerIndex) {
                            case 1:
                                GameScreen.player1Skin = SkinName.getByName(name);
                                core.transition(new CharacterScreen("P2 Choose Your GDX Fighter", 2));
                                break;
                            case 2:
                                GameScreen.player2Skin = SkinName.getByName(name);
                                core.transition(new LevelScreen());
                                break;
                        }
                    }
                });
            }
        }
    }
    
    @Override
    public void act(float delta) {
        stage.act(delta);
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
}
