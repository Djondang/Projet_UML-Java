package Motionless;

import Element.Permeability;
import Element.Sprite;

class Tree extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('^', "Tree.jpg");

    /**
     * Instantiates a new tree.
     */
    Tree() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
