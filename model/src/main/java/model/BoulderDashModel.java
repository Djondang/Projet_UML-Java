package model;

import model.element.Boulder;
import model.element.Diamond;
import model.element.Dirt;
import model.element.EmptySpace;
import model.element.ExitLocked;
import model.element.ExitOpen;
import model.element.Player;
import model.element.Wall;
import contract.*;
public class BoulderDashModel {       
    public static final int CAVE_SIZE = 20;
    private Cell[][] cave;  //The currently loaded level
    private int diamondsCount;
    private int diamondsFound;
    private int  playerX;
    private int playerY;
    private boolean levelCompleted;
    private boolean gameOver;
    private int stepsCounter;
    public BoulderDashModel(int[][] intCaveArray) {
         diamondsCount = 0;
         diamondsFound = 0;
         levelCompleted = false;
         gameOver = false;
         stepsCounter = 0;         
         cave = new Cell[CAVE_SIZE][CAVE_SIZE];
         for(int y = 0; y < CAVE_SIZE; y++) {
             for(int x = 0; x < CAVE_SIZE; x++) {
                 if(intCaveArray[x][y] == 7) {
                     cave[y][x] = new EmptySpace();
                 } else if(intCaveArray[x][y] == 1) {
                     cave[y][x] = new Player();
                     playerX = y;
                     playerY = x;
                 } else if(intCaveArray[x][y] == 4) {
                     cave[y][x] = new Diamond();
                     diamondsCount++;
                 } else if(intCaveArray[x][y] == 3) {
                     cave[y][x] = new Dirt();
                 } else if(intCaveArray[x][y] == 2) {
                     cave[y][x] = new Wall();
                 } else if(intCaveArray[x][y] == 0) {
                     cave[y][x] = new Boulder();
                 } else if(intCaveArray[x][y] == 5) {
                     cave[y][x] = new ExitLocked();
                 } else if(intCaveArray[x][y] == 6) {
                     cave[y][x] = new ExitOpen();      
                 }
             }
         }
    }
    public void moveUp() {
        if(gameOver || levelCompleted) {
            return;
        }
        if(playerY-1 < 0) {
            return;
        }
        if(cave[playerX][playerY-1] instanceof Wall) {
            return;
        }
        if(cave[playerX][playerY-1] instanceof Boulder) {
            return;
        }
        if(cave[playerX][playerY-1] instanceof ExitLocked) {
            return;
        }
        if(cave[playerX][playerY-1] instanceof Diamond) {
            diamondsFound++;
            cave[playerX][playerY-1] = cave[playerX][playerY];
            playerY--;
            cave[playerX][playerY+1] = new EmptySpace();
            stepsCounter++;
            if(diamondsFound == diamondsCount) {
                openDoor();
            }
            return;
        }
        if(cave[playerX][playerY-1] instanceof EmptySpace) {
            cave[playerX][playerY-1] = cave[playerX][playerY];
            playerY--;
            cave[playerX][playerY+1] = new EmptySpace();
            stepsCounter++;
            return;
        }
        if(cave[playerX][playerY-1] instanceof Dirt) {                                  
            cave[playerX][playerY-1] = cave[playerX][playerY];
            playerY--;
            cave[playerX][playerY+1] = new EmptySpace();
            stepsCounter++;
            return;
        }
        if(cave[playerX][playerY-1] instanceof ExitOpen) {
            cave[playerX][playerY-1] = cave[playerX][playerY];
            playerY--;
            cave[playerX][playerY+1] = new EmptySpace();
            stepsCounter++;
            levelCompleted = true;
            return;
        }
    }
    public void moveDown() {
        if(gameOver || levelCompleted) {
            return;
        }
        if(playerY+1 > CAVE_SIZE-1) {
            return;
        }
        if(cave[playerX][playerY+1] instanceof Wall) {
            return;
        }
        if(cave[playerX][playerY+1] instanceof Boulder) {
            return;
        }
        if(cave[playerX][playerY+1] instanceof ExitLocked) {
            return;
        }
        if(cave[playerX][playerY+1] instanceof Diamond) {
            diamondsFound++;
            cave[playerX][playerY+1] = cave[playerX][playerY];
            playerY++;
            cave[playerX][playerY-1] = new EmptySpace();
            stepsCounter++;
            if(diamondsFound == diamondsCount) {
                openDoor();
            }
            return;
        }
        if(cave[playerX][playerY+1] instanceof EmptySpace) {
            cave[playerX][playerY+1] = cave[playerX][playerY];
            playerY++;
            cave[playerX][playerY-1] = new EmptySpace();
            stepsCounter++;
            return;
        }
        if(cave[playerX][playerY+1] instanceof Dirt) {
            cave[playerX][playerY+1] = cave[playerX][playerY];
            playerY++;
            cave[playerX][playerY-1] = new EmptySpace();
            stepsCounter++;
            return;
        }
        if(cave[playerX][playerY+1] instanceof ExitOpen) {
            cave[playerX][playerY+1] = cave[playerX][playerY];
            playerY++;
            cave[playerX][playerY-1] = new EmptySpace();
            stepsCounter++;
            levelCompleted = true;
            return;
        }
    }
    public void moveLeft() {
        if(gameOver || levelCompleted) {
            return;
        }
        if(playerX-1 < 0) {
            return;
        }
        if(cave[playerX-1][playerY] instanceof Wall) {
            return;
        }
        if(cave[playerX-1][playerY] instanceof Boulder) {
            if(cave[playerX-2][playerY] instanceof EmptySpace) {
                cave[playerX-2][playerY] = cave[playerX-1][playerY];
                cave[playerX-1][playerY] = cave[playerX][playerY];
                cave[playerX][playerY] = new EmptySpace();
                playerX--;
                stepsCounter++;
            }
            return;
        }
        if(cave[playerX-1][playerY] instanceof ExitLocked) {
            return;
        }
        if(cave[playerX-1][playerY] instanceof Diamond) {
            diamondsFound++;
            cave[playerX-1][playerY] = cave[playerX][playerY];
            playerX--;
            cave[playerX+1][playerY] = new EmptySpace();
            stepsCounter++;
            if(diamondsFound == diamondsCount) {
                openDoor();
            }
            return;
        }
        if(cave[playerX-1][playerY] instanceof EmptySpace) {
            cave[playerX-1][playerY] = cave[playerX][playerY];
            playerX--;
            cave[playerX+1][playerY] = new EmptySpace();
            stepsCounter++;
            return;
        }
        if(cave[playerX-1][playerY] instanceof Dirt) {
            cave[playerX-1][playerY] = cave[playerX][playerY];
            playerX--;
            cave[playerX+1][playerY] = new EmptySpace();
            stepsCounter++;
            return;
        }
        if(cave[playerX-1][playerY] instanceof ExitOpen) {
            cave[playerX-1][playerY] = cave[playerX][playerY];
            playerX--;
            cave[playerX+1][playerY] = new EmptySpace();
            stepsCounter++;
            levelCompleted = true;
            return;
        }
    }
    public void moveRight() {
        if(gameOver || levelCompleted) {
            return;
        }
        if(playerX+1 > CAVE_SIZE-1) {
            return;
        }
        if(cave[playerX+1][playerY] instanceof Wall) {
            return;
        }
        if(cave[playerX+1][playerY] instanceof Boulder) {
            if(cave[playerX+2][playerY] instanceof EmptySpace) {
                cave[playerX+2][playerY] = cave[playerX+1][playerY];
                cave[playerX+1][playerY] = cave[playerX][playerY];
                cave[playerX][playerY] = new EmptySpace();
                playerX++;
                stepsCounter++;
            }
            return;
        }
        if(cave[playerX+1][playerY] instanceof ExitLocked) {
            return;
        }
        if(cave[playerX+1][playerY] instanceof Diamond) {
            diamondsFound++;
            cave[playerX+1][playerY] = cave[playerX][playerY];
            playerX++;
            cave[playerX-1][playerY] = new EmptySpace();
            stepsCounter++;
            if(diamondsFound == diamondsCount) {
                openDoor();
            }
            return;
        }
        if(cave[playerX+1][playerY] instanceof EmptySpace) {
            cave[playerX+1][playerY] = cave[playerX][playerY];
            playerX++;
            cave[playerX-1][playerY] = new EmptySpace();
            stepsCounter++;
            return;
        }
        if(cave[playerX+1][playerY] instanceof Dirt) {
            cave[playerX+1][playerY] = cave[playerX][playerY];
            playerX++;
            cave[playerX-1][playerY] = new EmptySpace();
            stepsCounter++;
            return;
        }
        if(cave[playerX+1][playerY] instanceof ExitOpen) {
            cave[playerX+1][playerY] = cave[playerX][playerY];
            playerX++;
            cave[playerX-1][playerY] = new EmptySpace();
            stepsCounter++;
            levelCompleted = true;
            return;
        }
    }
    public void showGameStatus() {
        for(int y = 0; y < CAVE_SIZE; y++) {
            for(int x = 0; x < CAVE_SIZE; x++) {
                if(cave[x][y] instanceof EmptySpace) {
                    System.out.print("7 ");
                } else if(cave[x][y] instanceof Player) {
                    System.out.print("1 ");
                } else if(cave[x][y] instanceof Diamond) {
                    System.out.print("4 ");
                } else if(cave[x][y] instanceof Dirt) {
                    System.out.print("3 ");
                } else if(cave[x][y] instanceof Wall) {
                    System.out.print("8 ");
                } else if(cave[x][y] instanceof Boulder) {
                    System.out.print("0 ");
                } else if(cave[x][y] instanceof ExitLocked) {
                    System.out.print("5 ");
                } else if(cave[x][y] instanceof ExitOpen) {
                    System.out.print("6 ");
                }
            }    
            System.out.println();
        }
        System.out.println();
        System.out.println("Diamonds Found: " + diamondsFound + " out of " + diamondsCount + ".");
        System.out.println("Level Completed: " + levelCompleted);
        System.out.println("Game Over: " + gameOver);
    }
    public int getDiamondsFound() {
        return diamondsFound;
    }
    public int getRockfordPosition(char c) {
        if(c == 'x') {
            return playerX;
        } else if(c == 'y') {
            return playerY;
        }
        return -1;
    } 
    public void openDoor() {
        for(int y = 0; y < CAVE_SIZE; y++) {
            for(int x = 0; x < CAVE_SIZE; x++) {
                if(cave[x][y] instanceof ExitLocked) {
                    cave[x][y] = new ExitOpen();
                }
            }
        }
    }
    public boolean getLevelCompleted() {
        return levelCompleted;
    }
    public boolean getGameOver() {
        return gameOver;
    }
    public String getDiamonds() {
        return diamondsFound+" out of "+diamondsCount+" diamonds collected.";
    }
    public String getSteps() {
        return stepsCounter+" steps made.";
    }
    public void tick() {
        if(gameOver || levelCompleted) {
            return;
        }
        for(int y = CAVE_SIZE-2; y >= 0; y--) {
            for(int x = CAVE_SIZE-1; x >= 0; x--) {
                if(cave[x][y] instanceof Boulder) {
                    if(cave[x][y+1] instanceof Player && ((Boulder)cave[x][y]).getFalling()) {
                        cave[x][y+1] = cave[x][y];
                        cave[x][y] = new EmptySpace();
                        gameOver = true;
                    }
                }
                if(cave[x][y] instanceof Diamond) {
                    if(cave[x][y+1] instanceof Player && ((Diamond)cave[x][y]).getFalling()) {
                        cave[x][y+1] = cave[x][y];
                        cave[x][y] = new EmptySpace();
                        gameOver = true;
                    }
                }
                if(cave[x][y] instanceof Boulder) {
                    if(cave[x][y+1] instanceof EmptySpace) {
                        ((Boulder)cave[x][y]).setFalling(true);
                        cave[x][y+1] = cave[x][y];
                        cave[x][y] = new EmptySpace();
                    } else {
                        ((Boulder)cave[x][y]).setFalling(false);
                    }
                }
                if(cave[x][y] instanceof Diamond) {
                    if(cave[x][y+1] instanceof EmptySpace) {
                        ((Diamond)cave[x][y]).setFalling(true);
                        cave[x][y+1] = cave[x][y];
                        cave[x][y] = new EmptySpace();
                    } else {
                        ((Diamond)cave[x][y]).setFalling(false);
                    }
                }
                if(cave[x][y] instanceof Boulder) {
                    if(cave[x][y+1] instanceof Boulder || cave[x][y+1] instanceof Diamond) {
                        if(x == CAVE_SIZE-1) {
                            if(cave[x-1][y] instanceof EmptySpace && cave[x-1][y+1] instanceof EmptySpace) {
                                cave[x-1][y+1] = cave[x][y];
                                cave[x][y] = new EmptySpace();
                                ((Boulder)cave[x-1][y+1]).setFalling(true);
                            } else {    
                                ((Boulder)cave[x][y]).setFalling(false);
                            }
                        } else if(x == 0) {
                            if(cave[x+1][y] instanceof EmptySpace && cave[x+1][y+1] instanceof EmptySpace) {
                                cave[x+1][y+1] = cave[x][y];
                                cave[x][y] = new EmptySpace();
                                ((Boulder)cave[x+1][y+1]).setFalling(true);
                            } else {    
                                ((Boulder)cave[x][y]).setFalling(false);
                            }
                        } else {
                            if(cave[x-1][y] instanceof EmptySpace && cave[x-1][y+1] instanceof EmptySpace) {
                                cave[x-1][y+1] = cave[x][y];
                                cave[x][y] = new EmptySpace();
                                ((Boulder)cave[x-1][y+1]).setFalling(true);
                            } else if(cave[x+1][y] instanceof EmptySpace && cave[x+1][y+1] instanceof EmptySpace) {
                                cave[x+1][y+1] = cave[x][y];
                                cave[x][y] = new EmptySpace();
                                ((Boulder)cave[x+1][y+1]).setFalling(true);
                            } else {   
                                ((Boulder)cave[x][y]).setFalling(false);
                            }
                        }
                    }
                }
            }
        }
    }
    public int[][] getCaveArray() {
        int[][] myArray = new int[CAVE_SIZE][CAVE_SIZE];
        for(int y = 0; y < CAVE_SIZE; y++) {
            for(int x = 0; x < CAVE_SIZE; x++) {
                if(cave[x][y] instanceof EmptySpace) {
                    myArray[x][y] = 7;
                } else if(cave[x][y] instanceof Player) {
                    myArray[x][y] = 1;
                } else if(cave[x][y] instanceof Diamond) {
                    myArray[x][y] = 4;
                } else if(cave[x][y] instanceof Dirt) {
                    myArray[x][y] = 3;
                } else if(cave[x][y] instanceof Wall) {
                    myArray[x][y] = 8;
                } else if(cave[x][y] instanceof Boulder) {
                    myArray[x][y] = 0;
                } else if(cave[x][y] instanceof ExitLocked) {
                    myArray[x][y] = 5;
                } else if(cave[x][y] instanceof ExitOpen) {
                    myArray[x][y] = 6;
                }
            }    
        }
        return myArray;
    }
}