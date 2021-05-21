package Motionless;

import Element.Permeability;
import Element.Sprite;

class Macadam extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Macadam.jpg");

    /**
     * Instantiates a new macadam.
     */
    Macadam() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
