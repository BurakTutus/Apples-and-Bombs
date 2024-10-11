import java.awt.Graphics;
public interface InterectableDrawing {
    boolean intersects(Ship s); 
    void interact(Ship s); 
    boolean moveLeft(int speed); 
    void draw(Graphics g);
}
