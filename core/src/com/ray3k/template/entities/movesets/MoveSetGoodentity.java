package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetGoodentity extends MoveSet {
    public MoveSetGoodentity() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirPunch();
        attackNeutral = new MoveStraight();
        attackSide = new MoveFrontFlip();
        attackUp = new MoveUppercut();
        attackDown = new MoveSweepKick();
        specialNeutral = new MoveGoodentityDust();
        specialSide = new MoveGoodentityCloud();
        specialUp = new MoveEvilentityTeleportUppercut();
        specialDown = new MoveAceSlide();
    }
}
