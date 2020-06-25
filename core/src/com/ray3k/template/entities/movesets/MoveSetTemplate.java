package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetTemplate extends MoveSet {
    public MoveSetTemplate() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirPunch();
        attackNeutral = new MoveJab();
        attackSide = new MoveLowPunch();
        attackUp = new MoveUppercut();
        attackDown = new MoveSplitPunch();
        specialNeutral = new MoveAcePunch();
        specialSide = new MoveAceBone();
        specialUp = new MoveAceFlyingUppercut();
        specialDown = new MoveAceSlide();
    }
}
