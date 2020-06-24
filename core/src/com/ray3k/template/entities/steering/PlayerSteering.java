package com.ray3k.template.entities.steering;

import com.ray3k.template.Core.*;
import com.ray3k.template.screens.*;

public class PlayerSteering extends Steering {
    private GameScreen gameScreen = GameScreen.gameScreen;
    private Binding bindingUp;
    private Binding bindingDown;
    private Binding bindingLeft;
    private Binding bindingRight;
    private Binding bindingSpecial;
    private Binding bindingAttack;
    private Binding bindingShield;
    private Binding bindingJump;
    
    public PlayerSteering(Binding bindingUp, Binding bindingDown, Binding bindingLeft,
                          Binding bindingRight, Binding bindingSpecial, Binding bindingAttack,
                          Binding bindingShield, Binding bindingJump) {
        this.bindingUp = bindingUp;
        this.bindingDown = bindingDown;
        this.bindingLeft = bindingLeft;
        this.bindingRight = bindingRight;
        this.bindingSpecial = bindingSpecial;
        this.bindingAttack = bindingAttack;
        this.bindingShield = bindingShield;
        this.bindingJump = bindingJump;
    }
    
    @Override
    public void update(float delta) {
        super.update(delta);
        
        up = gameScreen.isBindingPressed(bindingUp);
        down = gameScreen.isBindingPressed(bindingDown);
        left = gameScreen.isBindingPressed(bindingLeft);
        right = gameScreen.isBindingPressed(bindingRight);
        special = gameScreen.isBindingJustPressed(bindingSpecial);
        jump = gameScreen.isBindingJustPressed(bindingJump);
        attack = gameScreen.isBindingJustPressed(bindingAttack);
        shield = gameScreen.isBindingJustPressed(bindingShield);
    }
}
