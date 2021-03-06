package com.ray3k.template;

import com.esotericsoftware.spine.Skin;
import com.ray3k.template.entities.movesets.*;

public enum ProjectileSkinName {
    ACE_BONE("ace-bone"),
    ALI_KEYBAORD("ali-keyboard"),
    EVILENTITY_CLOUD("evilentity-cloud"),
    EVILENTITY_DUST("evilentity-dust"),
    GOODENTITY_CLOUD("goodentity-cloud"),
    GOODENTITY_DUST("goodentity-dust"),
    JOHN_ARROW("john-arrow"),
    JOHN_BOMB("john-bomb"),
    JOHN_BOOMERANG("john-boomerang"),
    MGSX_ARROW("mgsx-arrow"),
    MGSX_LOGO("mgsx-logo"),
    PANDA_CROWN("panda-crown"),
    PANDA_PEANUT("panda-peanut"),
    PAYNE_GRENADE("payne-grenade"),
    PAYNE_MISSILE("payne-missile"),
    SNEHKS_VENOM("snehks-venom"),
    TANN_AXE("tann-axe"),
    TETTINGER_NET("tettinger-net"),
    TETTINGER_YARN("tettinger-yarn"),
    TOM_SKI_BOLT("tom-ski-bolt"),
    DRAGON_FIREBALL("dragon-fireball"),
    ICEFILL_ICEBALL("icefill-iceball"),
    MARIO_FIREBALL("mario-fireball"),
    NATE_FIREBALL("nate-fireball"),
    ZEBRA_BULLET("zebra-bullet"),
    STAHLFELGE_SPEAR("stahlfelge-spear");
    
    public String name;
    public Skin skin;
    ProjectileSkinName(String name) {
        this.name = name;
    }
    
    public static ProjectileSkinName getByName(String name) {
        for (var value : ProjectileSkinName.values()) {
            if (value.name.equals(name)) return value;
        }
        return null;
    }
}
