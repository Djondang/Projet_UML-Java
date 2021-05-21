package Motionless;


public abstract class MotionlessElementFactory {
	
    private static final DitchRight  ditchRight = new DitchRight();

    /** The Constant ditchLeft. */
    private static final DitchLeft  ditchLeft = new DitchLeft();

    /** The Constant ditchLeftTurnLeft. */
    private static final DitchLeftTurnLeft ditchLeftTurnLeft = new DitchLeftTurnLeft();

    /** The Constant ditchLeftTurnRight. */
    private static final DitchLeftTurnRight  ditchLeftTurnRight  = new DitchLeftTurnRight();

    /** The Constant ditchRightTurnLeft. */
    private static final DitchRightTurnLeft  ditchRightTurnLeft  = new DitchRightTurnLeft();

    /** The Constant ditchRightTurnRight. */
    private static final DitchRightTurnRight ditchRightTurnRight = new DitchRightTurnRight();

    /** The Constant TREE. */
    private static final Tree TREE = new Tree();

    /** The Constant MACADAM. */
    private static final Macadam MACADAM  = new Macadam();

    /** The Constant OBSTACLE. */
    private static final Obstacle  OBSTACLE  = new Obstacle();

    
    private static MotionlessElement[]  motionlessElements  = {
    		ditchRight, ditchLeft,
            ditchLeftTurnLeft,
            ditchLeftTurnRight,
            ditchRightTurnLeft,
            ditchRightTurnRight,
            MACADAM,
            OBSTACLE,
            TREE, };
   
    public static MotionlessElement createDitchRight() {
        return ditchRight;
    }

    public static MotionlessElement createDitchLeft() {
        return ditchLeft;
    }

    public static MotionlessElement createDitchLeftTurnLeft() {
        return ditchLeftTurnLeft;
    }

    public static MotionlessElement createDitchLeftTurnRight() {
        return ditchLeftTurnRight;
    }

    public static MotionlessElement createDitchRightTurnLeft() {
        return ditchRightTurnLeft;
    }

    public static MotionlessElement createDitchRightTurnRight() {
        return ditchRightTurnRight;
    }

    public static MotionlessElement createMacadam() {
        return MACADAM;
    }

    public static MotionlessElement createObstacle() {
        return OBSTACLE;
    }

    public static MotionlessElement createTree() {
        return TREE;
    }

    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return MACADAM;
    }
}
