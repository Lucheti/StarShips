package edu.austral.starship.base.Utils;

import edu.austral.starship.base.vector.Vector2;

public class StarshipKeySet {
    int x;
    int y;
    int keyUp;
    int keyLeft;
    int keyDown;
    int keyRight;
    int shoot;
    int changeGun;

    public StarshipKeySet(int ... keys) {
        this.x = keys[0];
        this.y = keys[1];
        this.keyUp = keys[2];
        this.keyLeft = keys[3];
        this.keyDown = keys[4];
        this.keyRight = keys[5];
        this.shoot = keys[6];
        this.changeGun = keys[7];
    }

    public int[] getKeys(){
        return new int[] {x,y,keyUp,keyLeft,keyDown,keyRight,shoot,changeGun};
    }
}
