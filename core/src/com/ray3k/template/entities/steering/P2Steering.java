package com.ray3k.template.entities.steering;

import com.ray3k.template.Core.*;

public class P2Steering extends PlayerSteering {
    public P2Steering() {
        super(Binding.P2_UP, Binding.P2_DOWN, Binding.P2_LEFT, Binding.P2_RIGHT, Binding.P2_SPECIAL, Binding.P2_ATTACK, Binding.P2_SHIELD, Binding.P2_JUMP);
    }
}
