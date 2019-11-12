package edu.austral.starship.base.model.starship;

import edu.austral.starship.base.abstracts.Observer;
import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;

public class StarshipObserver implements Observer<StarShip> {

    @Override
    public void update(StarShip starShip) {
        if (starShip.getLife() == 0) Store.deleteFromState(TypeSafeState.STARSHIPS,starShip);
    }
}
