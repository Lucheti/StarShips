package edu.austral.starship.base.model.guns;
import edu.austral.starship.base.model.Store;

public class RapidFireGun extends Gun {

    int shots;

    public RapidFireGun() {
        this.timeBetweenShots = 1000;
        this.lastTimeGunShot = Store.getTime();
    }

    @Override
    public TypeSafeGunType getType() {
        return TypeSafeGunType.RAPID_FIRE;
    }
}
