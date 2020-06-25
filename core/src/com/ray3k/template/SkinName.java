package com.ray3k.template;

import com.esotericsoftware.spine.Skin;
import com.ray3k.template.entities.movesets.*;

public enum SkinName {
    ACE_SKELETON("ace-skeleton", new MoveSetAceSkeleton()),
    ALI("ali", new MoveSetAli()),
    EVILENTITY("evilentity", new MoveSetEvilentity()),
    FEROCIOUS_ZEBRA("ferocious-zebra", new MoveSetFerociousZebra()),
    GOODENTITY("goodentity", new MoveSetGoodentity()),
    JOHN_THE_DEVELOPER("john-the-developer", new MoveSetJohnTheDeveloper()),
    LYZE("lyze", new MoveSetLyze()),
    MGSX("mgsx", new MoveSetMgsx()),
    PARTYTIME_FOXY("partytime-foxy", new MoveSetAceSkeleton()),
    PAYNE("payne", new MoveSetPayne()),
    PEANUT_PANDA("peanut-panda", new MoveSetPeanutPanda()),
    RAELEUS("raeleus", new MoveSetRaeleus()),
    SKINCOMPOSER("skincomposer", new MoveSetSkinComposer()),
    SNEHKS("snehks", new MoveSetSnehks()),
    TANN("tann", new MoveSetTann()),
    TEMPLATE("template", new MoveSetTemplate()),
    TETTINGER("tettinger", new MoveSetTettinger()),
    TOM_SKI("tom-ski", new MoveSetTomSki());
    
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
