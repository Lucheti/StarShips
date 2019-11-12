package edu.austral.starship.base.model.meteor;

import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.vector.Vector2;

public class SmallMeteor extends Meteor{

    public SmallMeteor(Vector2 vector, float speedX, float speedY) {
        super(vector, speedX, speedY);
    }

    //Storeable
    @Override
    public EnumEqualable getType() {
        return TypeSafeMeteorType.SMALL_METEOR;
    }
}
