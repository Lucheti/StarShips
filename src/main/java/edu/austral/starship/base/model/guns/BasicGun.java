package edu.austral.starship.base.model.guns;

import edu.austral.starship.base.model.Store;

public class BasicGun extends Gun {

    int shots;

    public BasicGun() {
        this.timeBetweenShots = 8000;
        this.lastTimeGunShot = Store.getTime();
    }

    @Override
    public TypeSafeGunType getType() {
        return TypeSafeGunType.BASIC;
    }
}
