package edu.austral.starship.base.model.meteor;

import edu.austral.starship.base.interfaces.EnumEqualable;
import edu.austral.starship.base.model.Store;
import edu.austral.starship.base.model.TypeSafeState;
import edu.austral.starship.base.model.shot.Shot;
import edu.austral.starship.base.model.starship.StarShip;
import edu.austral.starship.base.vector.Vector2;

public class BigMeteor extends Meteor{
    public BigMeteor(Vector2 vector, float speedX, float speedY) {
        super(vector, speedX, speedY);
        this.lives = 2;
    }

    @Override
    public void collide(StarShip starShip) {
        starShip.loseLife();
        this.looseLife();
        if (lives == 0)
            Store.deleteFromState(TypeSafeState.METEORS,this);
    }

    @Override
    public void collide(Shot shot) {
        this.looseLife();
        if (lives == 0)
            Store.deleteFromState(TypeSafeState.METEORS,this);
    }

    private void looseLife() {
        lives--;
    }

    @Override
    public EnumEqualable getType() {
        return lives > 1? TypeSafeMeteorType.BIG_METEOR : TypeSafeMeteorType.SMALL_METEOR;
    }

}
