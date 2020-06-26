package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetEvilentity extends MoveSet {
    public MoveSetEvilentity() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirKick();
        attackNeutral = new MoveStraight();
        attackSide = new MoveFrontFlip();
        attackUp = new MoveUppercut();
        attackDown = new MoveSweepKick();
        specialNeutral = new MoveEvilentityDust();
        specialSide = new MoveEvilentityCloud();
        specialUp = new MoveEvilentityTeleportUppercut();
        specialDown = new MoveAceSlide();
    }
}
