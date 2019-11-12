package edu.austral.starship.base.model.guns;

import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.model.shot.BasicShot;
import edu.austral.starship.base.model.shot.Rocket;
import edu.austral.starship.base.vector.Vector2;

public class RocketLauncher extends Gun{

    int shots;

    public RocketLauncher() {
        this.timeBetweenShots = 5000;
        this.lastTimeGunShot = Store.getTime();
    }

    @Override
    public TypeSafeGunType getType() {
        return TypeSafeGunType.ROCKET_LAUNCHER;
    }

    @Override
    public void shoot(Vector2 vector, double angle) {
        Store.addToState(TypeSafeState.SHOTS, new Rocket(vector, angle));
    }
}
