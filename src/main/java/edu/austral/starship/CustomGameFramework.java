package edu.austral.starship;

import edu.austral.starship.base.Utils.ListConcatenator;
import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.interfaces.Storeable;
import edu.austral.starship.base.model.*;
import edu.austral.starship.base.model.guns.GunController;
import edu.austral.starship.base.model.meteor.Meteor;
import edu.austral.starship.base.model.meteor.MeteorController;
import edu.austral.starship.base.model.shot.Shot;
import edu.austral.starship.base.model.shot.ShotController;
import edu.austral.starship.base.model.shot.TypeSafeShotType;
import edu.austral.starship.base.model.starship.StarShip;
import edu.austral.starship.base.model.starship.StarshipController;
import edu.austral.starship.base.visual.VisualController;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class CustomGameFramework implements GameFramework {
    private Store store = new Store();
    CollisionEngine collisionEngine;

    private VisualController visualController = new VisualController();

    //STATE_CONTROLLERS
    private StarshipController starshipController;
    private MeteorController meteorController;
    private ShotController shotController;
    private GunController gunController;

    boolean mainMenu = true;

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(1000, 1000);

        //init engine
        collisionEngine = new CollisionEngine();
        //setUp images
        visualController.setup(imageLoader);
        this.starshipController = new StarshipController();
        this.meteorController = new MeteorController();
        this.shotController = new ShotController();
        this.gunController = new GunController();
    }


    @SuppressWarnings("unchecked")
    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
            //update game's time
            Store.incrementTime(timeSinceLastDraw);
            //call all position updates
            updateModel(keySet);
            //render all changes
            updateView(graphics);
            collisionEngine.checkCollisions(Store.getAllState());
    }

    private void updateModel(Set<Integer> keySet){
        starshipController.updatePositions(keySet);
        meteorController.updatePositions();
        shotController.updatePositions();
    }

    @SuppressWarnings("unchecked")
    private void updateView(PGraphics graphics){
        ((List<Storeable>) Store.getAllState()).forEach(starShip -> {
            graphics.image(visualController.getImage(starShip.getType()),starShip.getX(),starShip.getY());
        });
    }

    @Override
    public void keyPressed(KeyEvent event) {
    }

    @Override
    public void keyReleased(KeyEvent event) {
    }


}
