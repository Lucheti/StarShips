package edu.austral.starship.base.model.starship;

import edu.austral.starship.base.Utils.ConfigReader;
import edu.austral.starship.base.interfaces.NoParameterVoidFunction;
import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.vector.Vector2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StarshipController {

    private Map<Integer, NoParameterVoidFunction> keySet = new HashMap<>();

    public StarshipController() {
        setup();
    }

    @SuppressWarnings("unchecked")
    public void updatePositions(Set<Integer> pressedKeysSet){
        ((List<StarShip>) Store.getState(TypeSafeState.STARSHIPS)).forEach(starShip -> {
            pressedKeysSet.forEach(this::triggerAction);
            starShip.move();
        });
    }

    public void setup(){
        ConfigReader.readFile().forEach(keySet -> createStarship(keySet.getKeys()));
    }

    private void triggerAction(Integer action){
        if (keySet.containsKey(action)) keySet.get(action).apply();
    }

    private void createStarship(int ... keys){
        StarShip starShip = new StarShip(keys[0],keys[1]);
        Store.addToState(TypeSafeState.STARSHIPS,starShip);
        keySet.put(keys[2], starShip::moveUp);
        keySet.put(keys[3], starShip::moveLeft);
        keySet.put(keys[4], starShip::moveDown);
        keySet.put(keys[5], starShip::moveRight);
        keySet.put(keys[6], starShip::shoot);
        keySet.put(keys[7], starShip::changeGun);
    }
}
