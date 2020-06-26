package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetMgsx extends MoveSet {
    public MoveSetMgsx() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirDoubleKick();
        attackNeutral = new MoveJab();
        attackSide = new MoveHeadbutt();
        attackUp = new MoveBackFlip();
        attackDown = new MoveSplitPunch();
        specialNeutral = new MoveMgsxArrow();
        specialSide = new MoveMgsxShoulderDash();
        specialUp = new MoveMgsxLogo();
        specialDown = new MoveMgsxMetamorph();
    }
}
