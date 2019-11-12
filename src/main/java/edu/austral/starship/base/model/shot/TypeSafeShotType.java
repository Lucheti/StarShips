package edu.austral.starship.base.model.shot;

import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.model.TypeSafeState;

public enum TypeSafeShotType implements EnumEqualable {

    BASIC,
    ROCKET,
    EXPLOTION;

    @Override
    public boolean equals(EnumEqualable o) {
        return o.equals(this) || o.equals(TypeSafeState.SHOTS);
    }
}
