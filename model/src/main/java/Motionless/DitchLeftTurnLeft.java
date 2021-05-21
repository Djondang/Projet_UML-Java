package Motionless;

import Element.Permeability;
import Element.Sprite;

class DitchLeftTurnLeft extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('(', "DitchLeftTurnLeft.jpg");

    /**
     * Instantiates a new ditch.
     */
    DitchLeftTurnLeft() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
