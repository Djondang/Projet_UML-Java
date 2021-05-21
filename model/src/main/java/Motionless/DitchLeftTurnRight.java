package Motionless;

import Element.Permeability;
import Element.Sprite;

class DitchLeftTurnRight extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('{', "DitchLeftTurnRight.jpg");

    /**
     * Instantiates a new ditch.
     */
    DitchLeftTurnRight() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
