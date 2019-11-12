package edu.austral.starship.base.model.guns;

import edu.austral.starship.base.interfaces.Shooter;
import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.model.guns.TypeSafeGunType;
import edu.austral.starship.base.model.shot.BasicShot;
import edu.austral.starship.base.model.shot.Shot;
import edu.austral.starship.base.vector.Vector2;

public abstract class Gun implements Shooter {

    float timeBetweenShots;
    float lastTimeGunShot;

    public void shootIfPossible(Vector2 vector,double angle) {
        if (lastTimeGunShot + timeBetweenShots < Store.getTime()){
            lastTimeGunShot = Store.getTime();
            shoot(vector , angle);
        }
    }


    @Override
    public void shoot(Vector2 vector, double angle) {
        Store.addToState(TypeSafeState.SHOTS, new BasicShot(vector, angle));
    }

}
