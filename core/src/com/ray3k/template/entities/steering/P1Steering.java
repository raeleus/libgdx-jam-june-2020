package com.ray3k.template.entities.steering;

import com.ray3k.template.Core.*;

public class P1Steering extends PlayerSteering {
    public P1Steering() {
        super(Binding.P1_UP, Binding.P1_DOWN, Binding.P1_LEFT, Binding.P1_RIGHT, Binding.P1_SPECIAL, Binding.P1_ATTACK, Binding.P1_SHIELD, Binding.P1_JUMP);
    }
}
