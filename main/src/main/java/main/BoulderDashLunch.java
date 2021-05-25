package main;

import javax.swing.JFrame;
import javax.swing.Timer;

import controller.BoulderDashController;

public class BoulderDashLunch {
	
	   public static void main (String[] args) {
	        BoulderDashController boulderDashController = new BoulderDashController("Boulder Dash Game");
	        boulderDashController.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        boulderDashController.setLocation(500,220);
	        boulderDashController.pack();
	        boulderDashController.setVisible(true);
	        Timer t;
	        t = new Timer(750, boulderDashController);
	        t.start();
	    }

}
