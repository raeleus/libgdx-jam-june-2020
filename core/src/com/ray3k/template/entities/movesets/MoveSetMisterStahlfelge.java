package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetMisterStahlfelge extends MoveSet {
    public MoveSetMisterStahlfelge() {
        stance = new MoveStance();
        shield = new MoveShield();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirPunch();
        attackNeutral = new MoveStraight();
        attackSide = new MoveSpinKick();
        attackUp = new MoveUppercut();
        attackDown = new MoveSweepKick();
        specialNeutral = new MoveStahlfelgeSkull();
        specialSide = new MoveStahlfelgeSpear();
        specialUp = new MoveStahlfelgeTeleportPunch();
        specialDown = new MoveTannAxe();
    }
}