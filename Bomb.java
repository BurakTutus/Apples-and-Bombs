import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Bomb extends JPanel implements InterectableDrawing{
    Rectangle bomb_rectangle;
    int bomb_width = 30;
    int bomb_length = 20;
   

    public Bomb(int x , int y)
    {
        super();
        this.bomb_rectangle = new Rectangle(x, y, bomb_width, bomb_length);
    }

    public boolean intersects(Ship s)
    {
        if (this.bomb_rectangle.getx() > s.ship_rectangle.getx() + s.ship_width || s.ship_rectangle.getx() > this.bomb_rectangle.getx() + this.bomb_width) 
        {
        return false;
        }
        // If one rectangle is above the other
        if (this.bomb_rectangle.gety() > s.ship_rectangle.gety() + s.ship_length || s.ship_rectangle.gety() > this.bomb_rectangle.gety() + this.bomb_length) 
        {
            return false;
        }
        // Rectangles intersect
        return true;
        }    
    public void interact(Ship s)
    {
        s.Ship_health--;
    } 
    public boolean moveLeft(int speed)
    {
        boolean found = false;
        bomb_rectangle.setx2(speed);
        if(bomb_rectangle.getx() < 0)
        {
            found = true;
        }
        return found;

    } 
    public void draw(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(bomb_rectangle.getx(), bomb_rectangle.gety(), bomb_rectangle.getwidth(), bomb_rectangle.getheight());
    }

}
