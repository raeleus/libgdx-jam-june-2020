package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetTomSki extends MoveSet {
    public MoveSetTomSki() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirDoubleKick();
        attackNeutral = new MoveJab();
        attackSide = new MoveDoubleKick();
        attackUp = new MoveFrontFlip();
        attackDown = new MoveLowPunch();
        specialNeutral = new MoveTomSkiBolt();
        specialSide = new MoveTomSkiTackle();
        specialUp = new MoveTomSkiLightning();
        specialDown = new MoveTomSkiSlide();
    }
}
