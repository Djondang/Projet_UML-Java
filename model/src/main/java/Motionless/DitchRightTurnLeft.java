package Motionless;

import Element.Permeability;
import Element.Sprite;

class DitchRightTurnLeft extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('}', "DitchRightTurnLeft.jpg");

    /**
     * Instantiates a new ditch.
     */
    DitchRightTurnLeft() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
