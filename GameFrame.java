import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;

public class GameFrame extends JFrame{
    private String name;
    private int speed;
    public static int frameWidth;
    public static int frameHeight;
    
    
    public GameFrame(String name, int speed)
    {
                 
        this.speed =  speed;    
        this.name = name;       
        add(new GamePanel(this));

        setPreferredSize(new Dimension(Frame_Menu.WIDTH , Frame_Menu.HEIGHT));
        setVisible(true);
        
    }
    public int getspeed()
    {
        return this.speed;
    }
    public String getname()
    {
        return this.name;
    }
  
}
