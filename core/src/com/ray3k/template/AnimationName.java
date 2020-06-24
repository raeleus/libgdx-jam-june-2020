package com.ray3k.template;

public enum AnimationName {
    ACE_FLYING_UPPERCUT("ace-skeleton/ace-flying-uppercut"), ACE_GRAB("ace-skeleton/ace-grab"),
    ACE_PUNCH("ace-skeleton/ace-punch"), ACE_SLIDE("ace-skeleton/ace-slide"), ALI_ENERGY_SWORD("ali/ali-energy-sword"),
    ALI_LASER("ali/ali-laser"), ALI_TOSS("ali/ali-toss"), EVILENTITY_TELEPORT_UPPERCUT(
            "evilentity/evilentity-teleport-uppercut"), GENERAL_AIR("general/air"), GENERAL_AIR_KICK(
            "general/air-kick"), GENERAL_AIR_PUNCH("general/air-punch"), GENERAL_BACK_FLIP(
            "general/back-flip"), GENERAL_FRONT_FLIP("general/front-flip"), GENERAL_HURT1(
            "general/hurt1"), GENERAL_HURT2("general/hurt2"), GENERAL_JAB("general/jab"), GENERAL_JUMP(
            "general/jump"), GENERAL_KICK(
            "general/kick"), GENERAL_LOW_KICK("general/low-kick"), GENERAL_LOW_PUNCH("general/low-punch"), GENERAL_ROLL(
            "general/roll"), GENERAL_SPIN_KICK("general/spin-kick"), GENERAL_STANCE("general/stance"), GENERAL_STRAIGHT(
            "general/straight"), GENERAL_SWEEP_KICK("general/sweep-kick"), GENERAL_TEMPLATE(
            "general/template"), GENERAL_UP_KICK("general/up-kick"), GENERAL_UPPERCUT("general/uppercut"), GENERAL_WALK(
            "general/walk"), JOHN_ARROW("john-the-developer/john-arrow"), JOHN_WHIRLWIND(
            "john-the-developer/john-whirlwind"), LYZE_DIVE("lyze/lyze-dive"), LYZE_FORCE_PUSH(
            "lyze/lyze-force-push"), LYZE_TACKLE("lyze/lyze-tackle"), MARIO_BLAST(
            "mario/mario-blast"), MARIO_FLYING_UPPERCUT("mario/mario-flying-uppercut"), MARIO_HELICOPTER(
            "mario/mario-helicopter"), MARIO_UNBLOCKABLE_PUNCH("mario/mario-unblockable-punch"), MGSX_LOGO_ATTACK(
            "mgsx/mgsx-logo-attack"), MGSX_METAMORPH("mgsx/mgsx-metamorph"), MGSX_SHOULDER_DASH(
            "mgsx/mgsx-shoulder-dash"), PAYNE_MORTAR("payne/payne-mortar"), PAYNE_NIKITA(
            "payne/payne-nikita"), PAYNE_UAV("payne/payne-uav"), PANDA_COUNTER(
            "peanut-panda/panda-counter"), PANDA_PROPELLER("peanut-panda/panda-propeller"), RAELEUS_CHARGE_KICK(
            "raeleus/raeleus-charge-kick"), RAELEUS_CHARGE_PUNCH("raeleus/raeleus-charge-punch"), RAELEUS_HAMMER(
            "raeleus/raeleus-hammer"), RAELEUS_KNEE_UPPERCUT("raeleus/raeleus-uppercut"), SKIN_COMPOSER_ELECTRICITY(
            "skin-composer/skin-composer-electricity"), SKIN_COMPOSER_ROLL(
            "skin-composer/skin-composer-roll"), SNEHKS_DIVE("snehks/snehks-dive"), SNEHKS_INVISIBLE(
            "snehks/snehks-invisible"), SNEHKS_LUNGE("snehks/snehks-lunge"), SNEHKS_VENOM(
            "snehks/snehks-venom"), TETTINGER_BALLOON("tettinger/tettinger-balloon"), TETTINGER_COUNTER_ATTACK(
            "tettinger/tettinger-counter-attack"), TOMSKI_LIGHTNING("tomski/tomski-lightning"), GENERAL_DOUBLE_AXE_HANDLE("general/double-axe-handle");
    
    public String name;
    
    AnimationName(String name) {
        this.name = name;
    }
}