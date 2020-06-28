package com.ray3k.template.entities.movesets;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.*;
import com.ray3k.template.entities.moves.*;

import static com.ray3k.template.JamGame.*;

public class MoveSet {
    public Move goLeft;
    public Move goRight;
    public Move stance;
    public Move attackSide;
    public Move attackUp;
    public Move attackDown;
    public Move attackNeutral;
    public Move specialSide;
    public Move specialUp;
    public Move specialDown;
    public Move specialNeutral;
    public Move jump;
    public Move jumpAttack;
    public Move shield = new MoveShield();
    public Sound soundGrunt = assetManager.get("sfx/grunt1.mp3");
    public Sound soundDeath = assetManager.get("sfx/death1.mp3");
    public Sound soundHurt = assetManager.get("sfx/hurt1.mp3");
    public Sound soundWoosh = assetManager.get("sfx/woosh1.mp3");
}
