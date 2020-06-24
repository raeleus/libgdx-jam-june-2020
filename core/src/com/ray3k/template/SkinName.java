package com.ray3k.template;

import com.esotericsoftware.spine.Skin;
import com.ray3k.template.entities.movesets.*;

public enum SkinName {
    ACE_SKELETON("ace-skeleton", new MoveSetAceSkeleton()),
    ALI("ali", new MoveSetAceSkeleton()),
    EVILENTITY("evilentity", new MoveSetAceSkeleton()),
    FEROCIOUS_ZEBRA("ferocious-zebra", new MoveSetAceSkeleton()),
    GOODENTITY("goodentity", new MoveSetAceSkeleton()),
    JOHN_THE_DEVELOPER("john-the-developer", new MoveSetAceSkeleton()),
    LYZE("lyze", new MoveSetAceSkeleton()),
    MGSX("mgsx", new MoveSetAceSkeleton()),
    PARTYTIME_FOXY("partytime-foxy", new MoveSetAceSkeleton()),
    PAYNE("payne", new MoveSetAceSkeleton()),
    PEANUT_PANDA("peanut-panda", new MoveSetAceSkeleton()),
    RAELEUS("raeleus", new MoveSetAceSkeleton()),
    SKINCOMPOSER("skincomposer", new MoveSetAceSkeleton()),
    SNEHKS("snehks", new MoveSetAceSkeleton()),
    TANN("tann", new MoveSetAceSkeleton()),
    TEMPLATE("template", new MoveSetAceSkeleton()),
    TETTINGER("tettinger", new MoveSetAceSkeleton()),
    TOM_SKI("tom-ski", new MoveSetAceSkeleton());
    
    public String name;
    public MoveSet moveSet;
    public Skin skin;
    SkinName(String name, MoveSet moveSet) {
        this.name = name;
        this.moveSet = moveSet;
    }
    
    public static SkinName getByName(String name) {
        for (var value : SkinName.values()) {
            if (value.name.equals(name)) return value;
        }
        return null;
    }
}
