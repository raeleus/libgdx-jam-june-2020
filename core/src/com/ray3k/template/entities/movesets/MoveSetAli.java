package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetAli extends MoveSet {
    public MoveSetAli() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirKick();
        attackNeutral = new MoveJab();
        attackSide = new MoveKick();
        attackUp = new MoveUppercut();
        attackDown = new MoveLowPunch();
        specialNeutral = new MoveAliEnergySword();
        specialSide = new MoveAliKeyboard();
        specialUp = new MoveRaeleusKneeUppercut();
        specialDown = new MoveAliLaser();
    }
}
