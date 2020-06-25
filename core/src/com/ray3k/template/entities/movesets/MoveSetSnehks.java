package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetSnehks extends MoveSet {
    public MoveSetSnehks() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirPunch();
        attackNeutral = new MoveOneTwo();
        attackSide = new MoveSpinKick();
        attackUp = new MoveDoubleKick();
        attackDown = new MoveSweepKick();
        specialNeutral = new MoveAcePunch();
        specialSide = new MoveAceBone();
        specialUp = new MoveAceFlyingUppercut();
        specialDown = new MoveAceSlide();
    }
}
