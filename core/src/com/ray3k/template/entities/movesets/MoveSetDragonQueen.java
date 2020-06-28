package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetDragonQueen extends MoveSet {
    public MoveSetDragonQueen() {
        stance = new MoveStance();
        shield = new MoveShield();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirPunch();
        attackNeutral = new MoveJab();
        attackSide = new MoveLowPunch();
        attackUp = new MoveUpKick();
        attackDown = new MovePlank();
        specialNeutral = new MoveDragonChargeKick();
        specialSide = new MoveDragonBlast();
        specialUp = new MoveDragonQueenSpirit();
        specialDown = new MoveDragonLowBlast();
    }
}