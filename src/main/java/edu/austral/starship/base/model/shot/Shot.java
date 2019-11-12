package edu.austral.starship.base.model.shot;

import edu.austral.starship.base.interfaces.CollisionableVisitor;
import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.interfaces.Moveable;
import edu.austral.starship.base.interfaces.Storeable;
import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.model.meteor.Meteor;
import edu.austral.starship.base.model.starship.StarShip;
import edu.austral.starship.base.vector.Vector2;

public abstract class Shot implements CollisionableVisitor,Moveable, Storeable {

    Vector2 vector;
    double speed;
    double xSpeed;
    double ySpeed;
    double angle;
    float timeAlive;

    public Shot(Vector2 vector, double angle) {
        this.vector = vector;
        this.angle = angle;
        this.speed = 15;
        this.xSpeed = (Math.cos(angle) * speed);
        this.ySpeed = (Math.sin(angle) * speed);
        this.timeAlive = Store.getTime();
    }

    //getters
    public float getX(){
        return vector.getX();
    }
    public float getY(){
        return vector.getY();
    }
    float getXspeed(){ return (float) xSpeed ;}
    float getYspeed(){ return (float) ySpeed ;}
    public Vector2 getVector() {
        return vector;
    }

    @Override
    public void collisionedWith(CollisionableVisitor collisionable) {
        collisionable.collide(this);
    }

    @Override
    public void collide(StarShip starShip) {
        if ( Store.getTime() - timeAlive > 1500) {
            Store.deleteFromState(TypeSafeState.SHOTS, this);
        }
    }

    @Override
    public void collide(Shot shot) {
        Store.deleteFromState(TypeSafeState.SHOTS,this);
    }

    @Override
    public void collide(Meteor meteor) {
        Store.deleteFromState(TypeSafeState.SHOTS,this);
    }

    //Recognizable Methods
    @Override
    public EnumEqualable getType() {
        return TypeSafeState.SHOTS;
    }
}
