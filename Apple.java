import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;

public class Apple extends JPanel implements InterectableDrawing {
    Rectangle apple_rectangle;
    int apple_width = 30;
    int apple_length = 20;

    public Apple(int x, int y)
    {
        this.apple_rectangle = new Rectangle(x, y, apple_width, apple_length);
    }
    public boolean intersects(Ship s)
    {
        if (this.apple_rectangle.getx() > s.ship_rectangle.getx() + s.ship_width || s.ship_rectangle.getx() > this.apple_rectangle.getx() + this.apple_width) 
        {
        return false;
        }
        // If one rectangle is above the other
        if (this.apple_rectangle.gety() > s.ship_rectangle.gety() + s.ship_length || s.ship_rectangle.gety() > this.apple_rectangle.gety() + this.apple_length) 
        {
            return false;
        }
        // Rectangles intersect
        return true;
        }
    
    public void interact(Ship s)
    {
        s.ship_score++;
    } 
    public boolean moveLeft(int speed)
    {
        boolean found = false;
        apple_rectangle.setx2(speed);
        if(apple_rectangle.getx() < 0)
        {
            found = true;
        }
        return found;
        
    } 
    public void draw(Graphics g)
    {
        g.setColor(Color.red);       
        g.fillRect(apple_rectangle.getx(), apple_rectangle.gety(), apple_rectangle.getwidth(), apple_rectangle.getheight());
    }
}
