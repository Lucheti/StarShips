package edu.austral.starship.base.model.shot;

import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Explotion extends Shot{
    int radius;
    int lifeTime = 3000;

    public Explotion(Vector2 vector, int radius) {
        super(vector, 0);
        this.radius = radius;
        this.speed = 0;
        this.xSpeed = 0;
        this.ySpeed = 0;
    }

    //Moveable Methods
    @Override
    public void move() {
        if (timeAlive + lifeTime <= Store.getTime()) this.vector = vector.multiply((float)1000);
    }

    //Collisionable Methods
    @Override
    public Shape getShape() {
            return new Ellipse2D.Double(vector.getX(),vector.getY(),200,200);
    }

    //Recognizable Methods
    @Override
    public EnumEqualable getType() {
        return TypeSafeShotType.EXPLOTION;
    }

}
