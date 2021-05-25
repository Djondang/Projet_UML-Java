package contract;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public interface IBoulderDashController{

	public void keyPressed(KeyEvent e); 
    public void keyReleased(KeyEvent e); 
    public void keyTyped(KeyEvent e);
    public void actionPerformed (ActionEvent e);
    public int[][] getLevel(int levelNumber); 
}
