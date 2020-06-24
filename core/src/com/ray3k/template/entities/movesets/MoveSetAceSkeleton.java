package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetAceSkeleton extends MoveSet {
    public MoveSetAceSkeleton() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        attackNeutral = new MoveJab();
        attackSide = new MoveSpinKick();
        attackUp = new MoveDoubleAxeHandle();
        attackDown = new MoveLowKick();
        specialNeutral = new MoveStraight();
        specialSide = new MoveFrontFlip();
        specialUp = new MoveUppercut();
        specialDown = new MoveSweepKick();
    }
}
