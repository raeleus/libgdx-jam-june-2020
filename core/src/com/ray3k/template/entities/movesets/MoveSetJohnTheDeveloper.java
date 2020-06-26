package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetJohnTheDeveloper extends MoveSet {
    public MoveSetJohnTheDeveloper() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirFlop();
        attackNeutral = new MoveStraight();
        attackSide = new MoveDoublePunch();
        attackUp = new MoveDoubleAxeHandle();
        attackDown = new MoveLowPunch();
        specialNeutral = new MoveJohnArrow();
        specialSide = new MoveJohnBoomerang();
        specialUp = new MoveJohnWhirlwind();
        specialDown = new MoveJohnBomb();
    }
}
