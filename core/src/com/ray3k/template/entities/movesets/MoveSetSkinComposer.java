package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetSkinComposer extends MoveSet {
    public MoveSetSkinComposer() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirDive();
        attackNeutral = new MoveJab();
        attackSide = new MoveFrontFlip();
        attackUp = new MoveUppercut();
        attackDown = new MovePlank();
        specialNeutral = new MoveAcePunch();
        specialSide = new MoveAceBone();
        specialUp = new MoveAceFlyingUppercut();
        specialDown = new MoveAceSlide();
    }
}
