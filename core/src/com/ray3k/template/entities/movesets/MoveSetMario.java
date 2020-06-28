package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetMario extends MoveSet {
    public MoveSetMario() {
        stance = new MoveStance();
        shield = new MoveShield();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirPunch();
        attackNeutral = new MoveJab();
        attackSide = new MoveSpinKick();
        attackUp = new MoveDoubleAxeHandle();
        attackDown = new MoveLowKick();
        specialNeutral = new MoveAcePunch();
        specialSide = new MoveAceBone();
        specialUp = new MoveAceFlyingUppercut();
        specialDown = new MoveAceSlide();
    }
}