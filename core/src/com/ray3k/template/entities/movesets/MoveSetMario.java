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
        attackSide = new MoveLowKick();
        attackUp = new MoveUpKick();
        attackDown = new MoveSweepKick();
        specialNeutral = new MoveMarioBlast();
        specialSide = new MoveMarioHelicopter();
        specialUp = new MoveMarioFlyingUppercut();
        specialDown = new MoveMarioUnblockablePunch();
    }
}