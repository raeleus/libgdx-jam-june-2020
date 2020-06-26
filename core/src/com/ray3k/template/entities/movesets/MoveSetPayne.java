package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetPayne extends MoveSet {
    public MoveSetPayne() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirDive();
        attackNeutral = new MoveStraight();
        attackSide = new MoveDoublePunch();
        attackUp = new MoveUpKick();
        attackDown = new MovePlank();
        specialNeutral = new MovePayneGrenade();
        specialSide = new MovePayneNikita();
        specialUp = new MovePayneUav();
        specialDown = new MovePayneMortar();
    }
}
