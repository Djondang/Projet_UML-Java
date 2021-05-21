package Motionless;

import Element.Permeability;
import Element.Sprite;

class DitchLeft extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('[', "DitchLeft.jpg");

    /**
     * Instantiates a new ditchLeft.
     */
    DitchLeft() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
