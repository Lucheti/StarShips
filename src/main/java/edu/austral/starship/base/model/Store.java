package edu.austral.starship.base.model;

import edu.austral.starship.base.Utils.ListConcatenator;
import edu.austral.starship.base.interfaces.*;
import edu.austral.starship.base.model.meteor.Meteor;
import edu.austral.starship.base.model.shot.Shot;
import edu.austral.starship.base.model.starship.StarShip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@SuppressWarnings("SuspiciousMethodCalls")
public class Store {
    private static List<List> state = new ArrayList<>();
    static Map<TypeSafeState, NoParameterFunction<List>> getters = new HashMap<>();
    static Map<TypeSafeState, VoidFunction> adders = new HashMap<>();
    static Map<TypeSafeState, VoidFunction> deleters = new HashMap<>();
    static Map<TypeSafeAction, Function> actions = new HashMap<>();
    static float time = 0;

    public Store() {
        addEntity(new ArrayList<StarShip>(),TypeSafeState.STARSHIPS);
        addEntity(new ArrayList<Meteor>(),TypeSafeState.METEORS);
        addEntity(new ArrayList<Shot>(),TypeSafeState.SHOTS);
    }


    void addEntity(List entityList, TypeSafeState typeSafeState){
        state.add(entityList);
        getters.put(typeSafeState, () -> entityList);
        adders.put(typeSafeState, entityList::add);
        deleters.put(typeSafeState, entityList::remove);
    }

    @SuppressWarnings("unchecked")
    public static void addToState(TypeSafeState state, CollisionableVisitor o){
        adders.get((state)).aplly(o);
    }
    @SuppressWarnings("unchecked")
    public static void deleteFromState(TypeSafeState state, CollisionableVisitor o){
            deleters.get((state)).aplly(o);
    }
    public static List getState(TypeSafeState value){
            return getters.get(value).apply();
    }
    public static List getAllState(){
        return ListConcatenator.concatenate(
                Store.getState(TypeSafeState.STARSHIPS),
                Store.getState(TypeSafeState.METEORS),
                Store.getState(TypeSafeState.SHOTS)
        );
    }
    public void addAction(TypeSafeAction typeSafeAction, Function function){
        actions.put(typeSafeAction, function);
    }
    public static float getTime(){return time;}
    public static void incrementTime(float f){ time+=f; }

}