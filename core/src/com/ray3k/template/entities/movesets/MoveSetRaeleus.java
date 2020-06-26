package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetRaeleus extends MoveSet {
    public MoveSetRaeleus() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirFlop();
        attackNeutral = new MoveStraight();
        attackSide = new MoveSpinKick();
        attackUp = new MoveDoubleAxeHandle();
        attackDown = new MoveKick();
        specialNeutral = new MoveRaeleusHammer();
        specialSide = new MoveRaeleusChargePunch();
        specialUp = new MoveRaeleusKneeUppercut();
        specialDown = new MoveRaeleusChargeKick();
    }
}