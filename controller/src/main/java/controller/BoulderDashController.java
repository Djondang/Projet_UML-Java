package controller;
 

import javax.swing.*;

import contract.IBoulderDashController;
import model.BoulderDashModel;
import view.BoulderDashView;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;


public class BoulderDashController extends JFrame implements KeyListener, ActionListener, IBoulderDashController {
    private BoulderDashView view;
    private BoulderDashModel boulderDashModel;
    private JPanel infoPanel;
    private JLabel diamonds;
    private JLabel steps;
    private int currentLevel;
    public  static final int MAX_LEVELS = 5;
    public BoulderDashController(String title) {
        super(title);
        currentLevel = 1;
        boulderDashModel = new BoulderDashModel(getLevel(currentLevel));
        view = new BoulderDashView(boulderDashModel.getCaveArray());
        this.setLayout(new BorderLayout());
        JButton click = new JButton("Restart Level");
        click.addActionListener(this);
        click.addKeyListener(this);
        click.setBackground(new Color(0, 255, 0) );
        click.setFont(new Font("Times New ", Font.BOLD, 14));
        click.setActionCommand("restart");
        infoPanel = new JPanel();
        diamonds = new JLabel(boulderDashModel.getDiamonds());
        steps = new JLabel(boulderDashModel.getSteps());
        infoPanel.add(diamonds);
        infoPanel.add(steps);
        this.add(infoPanel,BorderLayout.NORTH);
        this.add(click,BorderLayout.SOUTH);
        this.add(view,BorderLayout.CENTER);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
    }
 
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_DOWN) {
            keyDown();
        } else if(key == KeyEvent.VK_UP) {
            keyUp();
        } else if(key == KeyEvent.VK_LEFT) {
            keyLeft();
        } else if(key == KeyEvent.VK_RIGHT) {
            keyRight();
        } else if(key == KeyEvent.VK_R) {
            boulderDashModel = new BoulderDashModel(getLevel(currentLevel));
            view.updateCave(boulderDashModel.getCaveArray());
            diamonds.setText(boulderDashModel.getDiamonds());
            steps.setText(boulderDashModel.getSteps());
        }    
    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    private void update() {
        view.updateCave(boulderDashModel.getCaveArray());
        diamonds.setText(boulderDashModel.getDiamonds());
        steps.setText(boulderDashModel.getSteps());
        if(boulderDashModel.getLevelCompleted()) {
            if(currentLevel == MAX_LEVELS) {
                JOptionPane.showMessageDialog(this, "Congratulations! You've completed the game.\nClick OK to return to level 1.");
                currentLevel = 1;
                boulderDashModel = new BoulderDashModel(getLevel(currentLevel));
                view.updateCave(boulderDashModel.getCaveArray());
                diamonds.setText(boulderDashModel.getDiamonds());
                steps.setText(boulderDashModel.getSteps());
            } else {
                JOptionPane.showMessageDialog(this, "Congratulations! You've completed the level.\nClick OK to move on to the next one.");
                currentLevel++;
                boulderDashModel = new BoulderDashModel(getLevel(currentLevel));
                view.updateCave(boulderDashModel.getCaveArray());
                diamonds.setText(boulderDashModel.getDiamonds());
                steps.setText(boulderDashModel.getSteps());
            }
        }
    }
    private void keyUp() {
        boulderDashModel.moveUp();
        update();
    }
    private void keyDown() {
        boulderDashModel.moveDown();
        update();
    }
    private void keyLeft() {
        boulderDashModel.moveLeft();
        update();
    }
    private void keyRight() {
        boulderDashModel.moveRight();
        update();
    }
    public void actionPerformed (ActionEvent e) {
        if("restart".equals(e.getActionCommand())) {
            boulderDashModel = new BoulderDashModel(getLevel(currentLevel));
            view.updateCave(boulderDashModel.getCaveArray());
            diamonds.setText(boulderDashModel.getDiamonds());
            steps.setText(boulderDashModel.getSteps());
        }
        boulderDashModel.tick();
        view.updateCave(boulderDashModel.getCaveArray());
        if(boulderDashModel.getGameOver()) {
            JOptionPane.showMessageDialog(this, "Oh no, Rockford has been crushed!\nClick OK to restart the level.");
            boulderDashModel = new BoulderDashModel(getLevel(currentLevel));
            view.updateCave(boulderDashModel.getCaveArray());
            diamonds.setText(boulderDashModel.getDiamonds());
            steps.setText(boulderDashModel.getSteps());
        }
    }
    public int[][] getLevel(int levelNumber) {
    	 int[][] level0 = {{7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},  
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7}, 
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {1,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
                 {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7}};
      
int[][] level1 = {{2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2},
                 {2,3,3,3,3,3,3,3,7,3,3,3,3,4,3,3,3,3,3,2},
                 {2,3,3,3,3,3,3,3,3,3,3,3,3,4,3,3,3,3,3,2},
                 {2,3,3,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
                 {2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,4,2,2,2,2},
                 {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
                 {2,3,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
                 {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
                 {2,3,3,3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                 {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
                 {2,3,3,3,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
                 {2,3,4,3,3,3,3,3,3,3,3,3,3,3,3,3,4,3,3,2},
                 {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,2},
                 {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,4,3,3,2},
                 {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,2},
                 {2,3,3,3,4,2,4,3,3,2,3,3,3,3,3,3,3,3,3,2},
                 {2,3,3,3,2,2,2,3,3,2,3,4,3,3,3,3,3,3,3,2},
                 {2,3,3,3,4,2,4,3,3,2,3,3,3,3,3,3,3,3,3,2},
                 {2,3,3,3,3,3,3,3,3,3,3,3,3,4,3,3,3,3,3,5},
                 {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};

int[][] level2 = {{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
	  {2,1,3,3,3,3,3,3,3,3,0,3,3,3,3,3,3,3,3,2},
	  {2,3,3,3,3,3,3,3,3,3,3,3,3,2,4,3,3,3,3,2},
	  {2,3,3,3,3,3,3,3,3,3,3,3,2,2,2,2,2,2,2,2},
	  {2,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,2},
	  {2,2,2,2,2,2,3,3,3,3,2,2,2,2,2,2,2,2,2,2},
	  {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
	  {2,3,3,3,3,3,0,0,3,3,3,3,3,3,3,0,3,3,4,2},
	  {2,3,3,0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
	  {2,4,3,3,0,3,3,3,3,3,3,3,0,3,3,3,3,3,3,2},
	  {2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,2,2},
	  {2,4,3,3,3,3,3,3,3,3,3,2,3,4,3,3,3,3,3,2},
	  {2,3,3,3,0,0,3,3,3,3,2,3,3,3,3,0,3,3,3,2},
	  {2,3,3,3,2,3,3,2,2,2,2,0,3,3,3,2,3,3,4,2},
	  {2,3,3,3,3,3,3,3,3,2,3,3,3,3,3,2,3,3,3,2},
	  {2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,2,3,3,3,2},
	  {2,4,3,3,3,3,2,3,3,3,0,0,3,3,2,4,3,3,3,2},
	  {2,3,3,3,3,3,2,3,3,3,3,3,3,3,3,2,3,3,3,2},
	  {5,3,3,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
	  {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};

int[][] level3 = {{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
	  {2,3,3,3,3,3,1,3,3,3,3,3,3,3,3,3,3,3,3,2},
	  {2,0,0,3,3,3,3,3,0,3,3,0,0,3,3,4,0,3,3,2},
	  {2,3,3,3,0,3,3,4,2,2,2,2,3,3,3,3,3,3,3,2},
	  {2,3,3,0,3,3,3,3,3,4,2,3,3,3,3,4,3,3,3,2},
	  {2,2,3,3,3,3,3,3,2,3,3,2,2,2,2,2,3,3,3,2},
	  {2,4,3,3,3,3,3,3,2,4,3,3,3,2,0,3,3,0,4,2},
	  {2,2,2,3,3,2,2,3,0,0,3,3,3,2,2,2,3,3,3,2},
	  {2,4,0,3,2,3,3,3,0,3,3,3,3,0,3,3,3,3,4,2},
	  {2,3,0,3,3,3,3,3,3,3,3,3,3,4,0,4,0,3,3,2},
	  {2,3,3,3,3,0,2,2,2,2,2,5,2,2,2,2,2,2,2,2},
	  {2,3,4,0,3,3,2,4,3,3,2,3,3,3,3,3,0,4,3,2},
	  {2,3,3,3,3,2,3,3,0,3,0,3,3,0,3,3,3,3,4,2},
	  {2,3,3,3,3,2,3,3,3,3,3,3,0,4,0,3,3,3,3,2},
	  {2,3,3,3,3,2,3,3,3,3,3,3,2,2,4,3,3,3,2,2},
	  {2,3,3,3,3,2,3,3,3,3,2,3,3,3,2,2,3,3,3,2},
	  {2,3,3,3,0,3,3,3,3,0,3,3,4,2,2,4,3,3,3,2},
	  {2,0,3,3,3,0,0,3,3,3,3,3,3,3,2,0,0,0,0,2},
	  {2,4,3,3,3,3,3,3,3,3,3,3,0,3,3,3,4,3,2,2},
	  {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};

      int[][] level4 = {{2,2,5,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
      		  {2,3,3,3,3,3,0,0,3,3,3,3,3,3,3,3,3,2,2,2},
      		  {2,3,3,3,0,0,3,3,3,3,3,0,4,3,3,3,3,2,2,2},
      		  {2,2,3,2,2,0,0,3,2,3,0,0,3,2,3,3,3,3,3,2},
      		  {2,3,3,4,2,4,3,1,2,3,3,3,3,2,3,3,3,3,3,2},
      		  {2,2,3,3,2,2,2,2,2,2,2,2,2,2,3,3,3,2,3,2},
      		  {2,3,3,3,3,3,3,3,3,0,3,3,3,3,3,3,4,2,3,2},
      		  {2,3,3,3,3,3,3,3,0,3,3,3,3,3,0,3,3,2,4,2},
      		  {2,3,3,3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2},
      		  {2,3,3,3,3,3,3,2,3,3,3,3,3,3,3,3,3,3,3,2},
      		  {2,3,3,3,0,3,0,2,3,3,3,3,0,3,3,3,2,3,3,2},
      		  {2,3,3,3,3,3,3,2,2,2,2,3,3,3,4,3,2,3,3,2},
      		  {2,3,3,2,2,2,2,2,4,0,3,3,3,3,3,3,2,3,3,2},
      		  {2,3,3,3,0,3,3,2,3,3,3,3,3,3,3,3,3,3,3,2},
      		  {2,3,3,3,3,3,3,2,2,2,2,2,2,2,2,3,3,0,3,2},
      		  {2,3,3,3,0,3,3,3,3,4,2,4,3,3,3,3,3,3,3,2},
      		  {2,3,3,2,2,2,2,2,2,2,2,3,3,3,2,0,0,3,0,2},
      		  {2,3,3,3,3,3,3,3,3,3,3,3,0,3,2,3,4,3,3,2},
      		  {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
      		  {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
      
      int[][] level5 = {{2,2,2,2,2,2,2,2,5,2,2,2,2,2,2,2,2,2,2,2},
      	{2,3,4,3,3,3,3,3,3,2,1,3,3,3,3,3,3,3,3,2},
      	{2,3,3,3,3,3,3,3,3,2,3,3,3,0,0,3,3,0,3,2},
      	{2,3,3,3,3,3,0,3,3,2,3,3,3,3,3,0,3,4,3,2},
      	{2,3,3,3,3,3,3,3,3,2,3,0,2,2,2,2,2,4,3,2},
      	{2,3,0,0,0,3,3,3,3,2,3,3,3,0,3,3,3,2,2,2},
      	{2,3,4,3,0,3,3,3,3,3,3,3,3,3,2,3,3,3,4,2},
      	{2,3,3,3,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,2},
      	{2,3,0,3,3,3,3,3,3,3,3,0,3,0,3,0,3,3,3,2},
      	{2,3,3,0,0,0,3,0,3,3,2,0,3,3,3,3,3,3,3,2},
      	{2,4,3,3,3,3,3,3,3,3,2,0,3,3,3,0,3,3,3,2},
      	{2,0,0,3,3,3,2,2,2,2,2,0,3,3,3,3,3,3,4,2},
      	{2,3,3,3,3,3,2,3,3,3,3,3,3,3,3,3,3,3,3,2},
      	{2,4,3,3,3,3,2,2,2,2,2,3,2,2,2,3,3,3,3,2},
      	{2,3,3,3,3,3,3,3,3,0,0,3,3,3,3,3,3,2,2,2},
      	{2,3,0,3,3,5,3,3,3,0,4,3,2,2,2,2,3,3,3,2},
      	{2,3,3,3,3,2,3,3,3,3,2,3,2,4,3,3,3,3,3,2},
      	{2,3,3,4,3,2,3,3,3,3,3,3,2,3,3,3,3,4,3,2},
      	{2,3,3,3,3,0,3,3,3,3,3,3,3,3,3,4,3,3,3,2},
      	{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
      
      if(levelNumber == 1) {
          return level1;
      } else if(levelNumber == 2) {
          return level2;
      } else if(levelNumber == 3) {
          return level3;
      } else if(levelNumber == 4) {
          return level4;
      } else if(levelNumber == 5) {
          return level5;
      } else {
          return level0;
      }
    } 
    
}