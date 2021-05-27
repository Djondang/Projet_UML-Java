package contract;

public interface IBoulderDashModel {

	public void moveUp();
    public void moveDown(); 
    public void moveLeft(); 
    public void moveRight(); 
    public void showGameStatus(); 
    public int getDiamondsFound(); 
    public void openDoor(); 
    public boolean getLevelCompleted(); 
    public boolean getGameOver(); 
    public String getDiamonds(); 
    public String getSteps(); 
    public void tick();
    public int[][] getCaveArray();
    
}
