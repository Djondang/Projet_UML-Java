package view;
import javax.swing.*;



import contract.IBoulderDashView;

import java.awt.GridLayout;

public class BoulderDashView extends JPanel implements IBoulderDashView {
    public static final int CAVE_SIZE = 20;
    private final ViewSound viewSound;
    private JLabel[][] labels;
    private Icon[] icons;
    public BoulderDashView(int[][] cave) {
    	this.viewSound = new ViewSound("C:\\Users\\kanaa\\git\\Projet_UML-Java\\main\\Sound\\y2mate.com-Super-Mario-Bros-Theme-Song.wav");
    	this.viewSound.start();
        icons = new Icon[9];
        icons[0] = new ImageIcon("./images/boulder.png");
        icons[1] = new ImageIcon("./images/rockford.png");
        icons[3] = new ImageIcon("./images/dirt.png");
        icons[4] = new ImageIcon("./images/diamond.png");
        icons[5] = new ImageIcon("./images/exitLocked.png");
        icons[6] = new ImageIcon("./images/exitOpen.png");
        icons[7] = new ImageIcon("./images/emptySpc.png");
        icons[2] = new ImageIcon("./images/wall.png");
        setLayout(new GridLayout(CAVE_SIZE,CAVE_SIZE));
        labels = new JLabel[CAVE_SIZE][CAVE_SIZE];
        for (int x = 0; x < CAVE_SIZE; x++) {
            for (int y = 0; y < CAVE_SIZE; y++) {
                labels[x][y] = new JLabel(icons[cave[y][x]]);
                add(labels[x][y]);
                
         
            }     
        }
    }
    public void updateCave(int[][] newCaveArray) {
        for (int x = 0; x < CAVE_SIZE; x++) {
            for (int y = 0; y < CAVE_SIZE; y++) {
                labels[x][y].setIcon(icons[newCaveArray[y][x]]);
            }
        }
    }
	
}
