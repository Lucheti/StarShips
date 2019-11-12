package edu.austral.starship.base.visual;

import com.jcraft.jsch.SftpATTRS;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.model.meteor.TypeSafeMeteorType;
import edu.austral.starship.base.model.shot.TypeSafeShotType;
import processing.core.PImage;

import java.util.HashMap;
import java.util.Map;

public class VisualController {
    private final Map<EnumEqualable, PImage> imageMap = new HashMap<>();

    public void addImage(EnumEqualable key, PImage value){
        imageMap.put(key,value);
    }

    public void setup(ImageLoader imageLoader){
        PImage starship =  imageLoader.load("src/main/resources/starship.png");
        PImage basicShot = imageLoader.load("src/main/resources/simpleShot.png");
        PImage rocket = imageLoader.load("src/main/resources/misile.png");
        PImage explosion = imageLoader.load("src/main/resources/explosion.png");
        PImage meteor = imageLoader.load("src/main/resources/meteor.png");
        PImage bigMeteor = imageLoader.load("src/main/resources/meteor.png");
        starship.resize(100,100);
        basicShot.resize(50,50);
        rocket.resize(50,50);
        explosion.resize(200,200);
        meteor.resize(50,50);
        bigMeteor.resize(100,100);
        addImage(TypeSafeState.STARSHIPS,starship);
        addImage(TypeSafeMeteorType.SMALL_METEOR,meteor);
        addImage(TypeSafeMeteorType.BIG_METEOR, bigMeteor);
        addImage(TypeSafeState.METEORS,meteor);
        addImage(TypeSafeShotType.BASIC,basicShot);
        addImage(TypeSafeShotType.ROCKET,rocket);
        addImage(TypeSafeShotType.EXPLOTION,explosion);
        addImage(TypeSafeState.SHOTS,basicShot);
    }

    public PImage getImage(EnumEqualable value){

        return imageMap.get(value);
    }
}


