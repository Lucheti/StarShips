package edu.austral.starship.base.model;

import edu.austral.starship.base.interfaces.EnumEqualable;

public enum TypeSafeState implements EnumEqualable {
    STARSHIPS,
    METEORS,
    SHOTS,
    GUN;

    @Override
    public boolean equals(EnumEqualable o) {
        return this == o;
    }
    public static boolean contains(EnumEqualable o){
        for (TypeSafeState state: TypeSafeState.values())
            if (state.equals(o)) return true;
            return false;
    }
}


