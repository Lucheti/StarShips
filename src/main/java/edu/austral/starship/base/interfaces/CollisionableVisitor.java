package edu.austral.starship.base.interfaces;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.base.model.meteor.Meteor;
import edu.austral.starship.base.model.shot.Shot;
import edu.austral.starship.base.model.starship.StarShip;

public interface CollisionableVisitor extends Collisionable<CollisionableVisitor> {
    public void collide(StarShip starShip);
    public void collide(Shot shot);
    public void collide(Meteor meteor);
}
