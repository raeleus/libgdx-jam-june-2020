package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetTann extends MoveSet {
    public MoveSetTann() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirDoubleKick();
        attackNeutral = new MoveOneTwo();
        attackSide = new MoveDoubleKick();
        attackUp = new MoveHeadbutt();
        attackDown = new MoveSweepKick();
        specialNeutral = new MoveAcePunch();
        specialSide = new MoveAceBone();
        specialUp = new MoveAceFlyingUppercut();
        specialDown = new MoveAceSlide();
    }
}
