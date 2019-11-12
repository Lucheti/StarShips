package edu.austral.starship.base.model.meteor;

import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.model.TypeSafeState;

public enum TypeSafeMeteorType implements EnumEqualable {
    BIG_METEOR,
    SMALL_METEOR;

    @Override
    public boolean equals(EnumEqualable o) {
        return o.equals(this) || o.equals(TypeSafeState.METEORS);
    }
}
