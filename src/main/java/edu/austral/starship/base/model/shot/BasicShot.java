package edu.austral.starship.base.model.shot;

import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public class BasicShot extends Shot{

    public BasicShot(Vector2 vector, double angle) {
        super(vector, angle);
    }

    //Moveable Methods
    @Override
    public void move() {
        this.vector = new Vector2((vector.getX() + getXspeed()),(vector.getY() + getYspeed()));
    }

    //Collisionable Methods
    @Override
    public Shape getShape() {
        return new Rectangle((int)vector.getX(),(int)vector.getY(),50,50);
    }

    //Recognizable Methods
    @Override
    public EnumEqualable getType() {
        return TypeSafeShotType.BASIC;
    }
}
