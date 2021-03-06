package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetFerociousZebra extends MoveSet {
    public MoveSetFerociousZebra() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirPunch();
        attackNeutral = new MoveStraight();
        attackSide = new MoveHeadbutt();
        attackUp = new MoveUpKick();
        attackDown = new MoveSweepKick();
        specialNeutral = new MoveZebraShotgun();
        specialSide = new MoveZebraRifle();
        specialUp = new MoveZebraJetPack();
        specialDown = new MoveLyzeDive();
    }
}
