package model.element;

public class Boulder implements contract.Cell{
    private boolean falling;
    public Boulder() {
        falling = false;
    }
    public boolean getFalling() {
        return falling;
    }
    public void setFalling(boolean b) {
        falling = b;
    }
}
