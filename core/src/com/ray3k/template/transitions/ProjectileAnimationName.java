package com.ray3k.template.transitions;

import com.esotericsoftware.spine.Animation;

public enum ProjectileAnimationName {
    EVILENTITY_DUST("evilentity-dust"),
    JOHN_BOOMERANG("john-boomerang"),
    STATIC("static"),
    TANN_AXE("tann-axe");
    
    public String name;
    public Animation animation;
    
    ProjectileAnimationName(String name) {
        this.name = name;
    }
}
