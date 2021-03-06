package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetTettinger extends MoveSet {
    public MoveSetTettinger() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirKick();
        attackNeutral = new MoveStraight();
        attackSide = new MoveKick();
        attackUp = new MoveUpKick();
        attackDown = new MoveSweepKick();
        specialNeutral = new MoveTettingerNet();
        specialSide = new MoveTettingerYarn();
        specialUp = new MoveTettingerBalloons();
        specialDown = new MoveTettingerCounter();
    }
}
