import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import org.w3c.dom.events.Event;


public class Ship extends JPanel {
    
    Rectangle ship_rectangle;
    int ship_width = 60;
    int ship_length = 30;
    int Ship_health = 3;
    int ship_score = 0;
    int x = 300;
    int y = 300;
    
    public Ship()
    {
        this.ship_rectangle = new Rectangle(x, y, ship_width, ship_length); 
               
    }
    public void draw(Graphics g, String name)
    {
        
        g.setColor(Color.RED);
        g.fillRect(ship_rectangle.getx(), ship_rectangle.gety(), ship_rectangle.getwidth(), ship_rectangle.getheight());
        g.setColor(Color.WHITE);
        g.drawString(name, ship_rectangle.getx() + ship_width / 2, ship_rectangle.gety() + ship_length / 2);
    }
    public Rectangle getRectangle_ship()
    {
        return ship_rectangle;
    }
    
    public void setShipPosition(int x, int y) {
        int newX = x - ship_rectangle.getwidth() / 2;
        int newY = y - ship_rectangle.getheight() / 2;
        
        ship_rectangle.setx(newX);
        ship_rectangle.sety(newY);
    }
    public int getHealth()
    {
        return this.Ship_health;
    }
    
    
}
