package com.ray3k.template.entities.movesets;

import com.ray3k.template.entities.moves.*;

public class MoveSetLyze extends MoveSet {
    public MoveSetLyze() {
        stance = new MoveStance();
        goLeft = new MoveGoLeft();
        goRight = new MoveGoRight();
        jump = new MoveJump();
        jumpAttack = new MoveAirDoubleKick();
        attackNeutral = new MoveOneTwo();
        attackSide = new MoveDoubleKick();
        attackUp = new MoveUppercut();
        attackDown = new MoveSweepKick();
        specialNeutral = new MoveLyzeForcePush();
        specialSide = new MoveLyzeTackle();
        specialUp = new MoveAceFlyingUppercut();
        specialDown = new MoveLyzeDive();
    }
}
