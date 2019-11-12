package edu.austral.starship.base.model.meteor;

import edu.austral.starship.base.interfaces.CollisionableVisitor;
import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.interfaces.Moveable;
import edu.austral.starship.base.interfaces.Storeable;
import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.model.shot.Shot;
import edu.austral.starship.base.model.starship.StarShip;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public abstract class Meteor implements CollisionableVisitor, Moveable, Storeable {
    Vector2 vector;
    float speedX;
    float speedY;
    int lives;


    public Meteor(Vector2 vector, float speedX, float speedY) {
        this.vector = vector;
        this.speedX = speedX;
        this.speedY = speedY;
        this.lives = 1;
    }

    @Override
    public Shape getShape() {
        return new Rectangle((int)vector.getX(),(int)vector.getY(),50,50);
    }

    @Override
    public void move() {
        vector = vector.add(new Vector2(speedX,speedY));
    }

    public float getX() {
        return vector.getX();
    }

    public float getY() {
        return vector.getY();
    }

    public Vector2 getVector() {
        return vector;
    }

    //Storeable
    @Override
    public EnumEqualable getType() {
        return TypeSafeState.METEORS;
    }

    @Override
    public void collisionedWith(CollisionableVisitor collisionable) {
        collisionable.collide(this);
    }

    @Override
    public void collide(StarShip starShip) {
        Store.deleteFromState(TypeSafeState.METEORS,this);
    }

    @Override
    public void collide(Shot shot) {
        Store.deleteFromState(TypeSafeState.METEORS,this);
    }

    @Override
    public void collide(Meteor meteor) {

    }
}
