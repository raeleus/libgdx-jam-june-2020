package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetPeanutPanda extends MoveSet {
    public MoveSetPeanutPanda() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirDoublePunch();
        attackNeutral = new MoveOneTwo();
        attackSide = new MoveHeadbutt();
        attackUp = new MoveSplitKick();
        attackDown = new MoveLowPunch();
        specialNeutral = new MoveAcePunch();
        specialSide = new MoveAceBone();
        specialUp = new MoveAceFlyingUppercut();
        specialDown = new MoveAceSlide();
    }
}
