package Motionless;

import Element.Permeability;
import Element.Sprite;

class DitchRight extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(']', "DitchRight.jpg");

    /**
     * Instantiates a new ditchRight.
     */
    DitchRight() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
