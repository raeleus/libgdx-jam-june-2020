package com.ray3k.template;

import com.esotericsoftware.spine.Skin;

public enum SkinName {
    ACE_SKELETON("ace-skeleton"), ALI("ali"), EVILENTITY("evilentity"), FEROCIOUS_ZEBRA("ferocious-zebra"), GOODENTITY("goodentity"), JOHN_THE_DEVELOPER("john-the-developer"), LYZE("lyze"), MGSX("mgsx"), PARTYTIME_FOXY("partytime-foxy"), PAYNE("payne"), PEANUT_PANDA("peanut-panda"), RAELEUS("raeleus"), SKINCOMPOSER("skincomposer"), SNEHKS("snehks"), TANN("tann"), TEMPLATE("template"), TETTINGER("tettinger"), TOM_SKI("tom-ski");
    
    public String name;
    public Skin skin;
    SkinName(String name) {
        this.name = name;
    }
}
