package edu.austral.starship.base.model.shot;

import edu.austral.starship.base.interfaces.CollisionableVisitor;
import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public class Rocket extends Shot{

    public Rocket(Vector2 vector, double angle) {
        super(vector, angle);
        this.speed = 25;
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

    //Storable Methods
    @Override
    public EnumEqualable getType() {
        return TypeSafeShotType.ROCKET;
    }

    @Override
    public void collisionedWith(CollisionableVisitor collisionable) {
        if ( Store.getTime() - timeAlive >= 750) {
            collisionable.collide(this);
            Store.addToState(TypeSafeState.SHOTS, new Explotion(vector,100));
        }
    }
}
