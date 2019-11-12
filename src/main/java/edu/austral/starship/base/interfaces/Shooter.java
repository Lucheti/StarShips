package edu.austral.starship.base.interfaces;

import edu.austral.starship.base.model.guns.TypeSafeGunType;
import edu.austral.starship.base.vector.Vector2;

public interface Shooter {
    void shoot(Vector2 vector, double angle);
    TypeSafeGunType getType();

}
