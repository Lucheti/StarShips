package edu.austral.starship.base.model.guns;

import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.model.TypeSafeState;

public enum TypeSafeGunType implements EnumEqualable {

    BASIC,
    RAPID_FIRE,
    ROCKET_LAUNCHER;

    public boolean equals(EnumEqualable o){
        return o.equals(this) || o.equals(TypeSafeState.GUN);
    }

}
