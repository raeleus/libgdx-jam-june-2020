package com.ray3k.template.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
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
    
    public CharacterScreen(String title) {
        this.title = title;
    }
    
    @Override
    public void show() {
        super.show();
    
        final Music bgm = assetManager.get("bgm/music-test.mp3");
        if (!bgm.isPlaying()) {
            bgm.play();
            bgm.setVolume(core.bgm);
            bgm.setLooping(true);
        }
        
        stage = new Stage(new ScreenViewport(), batch);
        Gdx.input.setInputProcessor(stage);
    
        sceneBuilder.build(stage, skin, Gdx.files.internal("menus/character.json"));
        
        Label label = stage.getRoot().findActor("label");
        label.setText(title);
        
        var table = (Table) stage.getRoot().getChild(0);
        for (var child : table.getChildren()) {
            if (child instanceof ImageButton) {
                var imageButton = (ImageButton) child;
                imageButton.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        GameScreen.player1Skin = SkinName.getByName(imageButton.getName());
                        GameScreen.player2Skin = SkinName.getByName(imageButton.getName());
                        core.transition(new GameScreen());
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
