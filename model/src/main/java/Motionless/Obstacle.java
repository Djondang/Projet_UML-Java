package Motionless;

import Element.Permeability;
import Element.Sprite;

class Obstacle extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('X', "Obstacle.jpg");

    /**
     * Instantiates a new obstacle.
     */
    Obstacle() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
