package edu.austral.starship.base.model.shot;

import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.model.meteor.Meteor;

import java.util.ArrayList;
import java.util.List;

public class ShotController {

    public ShotController() {
    }

    @SuppressWarnings("unchecked")
    public void updatePositions(){
        List<Shot> toDelete = new ArrayList<>();
        ((List<Shot>) Store.getState(TypeSafeState.SHOTS)).forEach(shot -> {
            shot.move();
            if (shot.getVector().isOutOfBounds()) toDelete.add(shot);
        });
        toDelete.forEach( meteor -> Store.deleteFromState(TypeSafeState.SHOTS,meteor));
    }

    public void setup(Store store){
    }

}
