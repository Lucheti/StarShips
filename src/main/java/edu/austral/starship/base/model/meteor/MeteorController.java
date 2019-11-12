package edu.austral.starship.base.model.meteor;

import edu.austral.starship.base.Utils.RandomGenerator;
import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

public class MeteorController {

    Vector2 center = new Vector2(500,500);

    public MeteorController() {
        setup();
    }

    @SuppressWarnings("unchecked")
    public void updatePositions(){
        spawnMeteor();
        List<Meteor> toDelete = new ArrayList<>();
        ((List<Meteor>) Store.getState(TypeSafeState.METEORS)).forEach(meteor -> {
            meteor.move();
            if (meteor.getVector().isOutOfBounds()) toDelete.add(meteor);
        });
        toDelete.forEach( meteor -> Store.deleteFromState(TypeSafeState.METEORS,meteor));
    }

    private void spawnMeteor(){
//        if (RandomGenerator.getRandom(1) < Store.getTime() / 5000000){
        if (RandomGenerator.getRandom() < 0.001){
            if (RandomGenerator.getBoolean(.5)){
                if(RandomGenerator.getBoolean(.5)) createMeteor(1005,RandomGenerator.getRandom(1005));
                else createMeteor(-5,RandomGenerator.getRandom(1005));
            }else{
                if(RandomGenerator.getBoolean(.5)) createMeteor(RandomGenerator.getRandom(1005),1005);
                else createMeteor(RandomGenerator.getRandom(1005),-5);
            }
        }

    }

    private void createMeteor(int x,int y){
        Vector2 initPosition = new Vector2(x,y);
        Vector2 resultant = center.substract(initPosition).divide(RandomGenerator.getRandom(100,300));
        if (RandomGenerator.getBoolean(.5))
            Store.addToState(TypeSafeState.METEORS, new SmallMeteor(initPosition, (int) resultant.getX(), (int) resultant.getY()));
        else
            Store.addToState(TypeSafeState.METEORS,new BigMeteor(initPosition,(int)resultant.getX(),(int)resultant.getY()));

    }

    public void setup(){
    }
}
