package edu.austral.starship.base.model.starship;

import edu.austral.starship.base.interfaces.CollisionableVisitor;
import edu.austral.starship.base.model.guns.Gun;
import edu.austral.starship.base.interfaces.Storeable;
import edu.austral.starship.base.interfaces.UserMoveable;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.model.guns.BasicGun;
import edu.austral.starship.base.model.guns.GunController;
import edu.austral.starship.base.model.meteor.Meteor;
import edu.austral.starship.base.model.shot.Shot;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;
//Collisionable Collisionable
public class StarShip implements CollisionableVisitor, UserMoveable, Storeable {
    Vector2 vector;
    float xAcceleration = 0;
    float yAcceleration = 0;
    Gun gun;
    int life;

    public StarShip(int x, int y) {
        this.vector = new Vector2(x,y);
        this.gun = new BasicGun();
        this.life = 10;
    }

    @Override
    public Shape getShape() {
        return new Rectangle((int)vector.getX(),(int)vector.getY(),100,100);
    }

    public float getX(){
        return vector.getX();
    }

    public float getY(){
        return vector.getY();
    }

    public void moveUp() { if (yAcceleration > -5) this.yAcceleration -= 0.5; }

    @Override
    public void moveDown() { if (yAcceleration < 5) this.yAcceleration += 0.5; }

    @Override
    public void moveLeft() { if (xAcceleration > -5) this.xAcceleration -= 0.5; }

    @Override
    public void moveRight() { if (xAcceleration < 5) this.xAcceleration += 0.5; }

    private double getAngle(){ return Math.atan2(yAcceleration,xAcceleration) - Math.atan2(0,1);}

    public void changeGun(){
        this.gun = GunController.nextGun(gun);
    }

    void move(){
        this.vector = new Vector2((vector.getX() + xAcceleration), (vector.getY() + yAcceleration));
    }

    void shoot() {
        gun.shootIfPossible(getOffsetedVector(),getAngle());
    }

    private Vector2 getOffsetedVector() {
        return new Vector2((float)(vector.getX() + getShape().getBounds().getWidth()/3), (float) (vector.getY() + getShape().getBounds().getHeight()/3));
    }

    @Override
    public TypeSafeState getType() {
        return TypeSafeState.STARSHIPS;
    }

    @Override
    public void collisionedWith(CollisionableVisitor collisionable) {
        collisionable.collide(this);
    }

    @Override
    public void collide(StarShip starShip) {

    }

    @Override
    public void collide(Shot shot) {

    }

    @Override
    public void collide(Meteor meteor) {
        System.out.println("auch");
    }

    public void loseLife() {
        this.life -= 1;
    }
}
