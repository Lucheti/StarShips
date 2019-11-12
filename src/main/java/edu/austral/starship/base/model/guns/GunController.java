package edu.austral.starship.base.model.guns;

import com.sun.tools.javac.util.List;
import edu.austral.starship.base.interfaces.NoParameterFunction;
import edu.austral.starship.base.model.Store;

import java.util.HashMap;
import java.util.Map;

public class GunController {

    static Map<TypeSafeGunType, NoParameterFunction<Gun>> gunGenerator = new HashMap<>();
    static List<TypeSafeGunType> gunTypes = List.from(TypeSafeGunType.values());
    private static float lastSwapTime = Store.getTime();
    private static int timeBetweenSwaps = 10000;

    public GunController() {
        gunGenerator.put(TypeSafeGunType.BASIC, BasicGun::new);
        gunGenerator.put(TypeSafeGunType.RAPID_FIRE, RapidFireGun::new);
        gunGenerator.put(TypeSafeGunType.ROCKET_LAUNCHER, RocketLauncher::new);
    }

    public static TypeSafeGunType getNextType(TypeSafeGunType gunType){
        return gunTypes.get((gunTypes.indexOf(gunType)+ 1) % gunTypes.size());
    }


    public static Gun nextGun(Gun gun) {
        if (lastSwapTime + timeBetweenSwaps <= Store.getTime()) {
            lastSwapTime = Store.getTime();
            return gunGenerator.get(getNextType(gun.getType())).apply();
        }
        return gun;
    }
}
