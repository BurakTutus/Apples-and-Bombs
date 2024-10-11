import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GamePanel extends JPanel {
    private GameFrame gameFrame;
    Ship player;
    ArrayList<InterectableDrawing> enemies;
    Timer timer;
    Random rand = new Random();

    int counter = 0;
    int max_count;

    public GamePanel(GameFrame gameFrame)
    {      
        this.gameFrame = gameFrame;        
        this.setBackground(Color.BLUE);
        player = new Ship();
        addMouseMotionListener(new DotListener());
        enemies =  new ArrayList<InterectableDrawing>();
        timer = new Timer(50, new TimerListener(this));
        max_count = 35/gameFrame.getspeed();
     
        timer.start();
        
     }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);        
        player.draw(g,Frame_Menu.name2);
        for(int i = 0; i < enemies.size(); i++)
        {
            enemies.get(i).draw(g);
        }
        repaint();     
        
    }
    private class TimerListener implements ActionListener
    {
        private GamePanel gamepanel;

        public TimerListener(GamePanel game)
        {
            this.gamepanel = game;                      

        }
        
        public void actionPerformed(ActionEvent event)
        {
            counter++;

            int chooser = rand.nextInt(2);
            Random r = new Random();    

            int result2 = r.nextInt(gamepanel.getHeight() + 1) + gamepanel.getY();
            int result4 = r.nextInt(gamepanel.getHeight() + 1) + gamepanel.getY();            
           
            if(chooser == 0)
            {   
                if (counter >= max_count) {
                    enemies.add(new Apple(gamepanel.getWidth()+ gamepanel.getX(), result2));
                    counter = 0;
                }
            }
            else if(chooser == 1)
            {
                if (counter >= max_count) {
                    enemies.add(new Bomb(gamepanel.getWidth() , result4));
                    counter = 0;
                }
                
            }
            for(int i = 0; i < enemies.size(); i++)
            {                               
                enemies.get(i).moveLeft(gameFrame.getspeed());
                if(enemies.get(i).intersects(player))
                {
                    enemies.get(i).interact(player);
                    enemies.remove(i);
                }
            }         
            repaint();
            if(player.Ship_health <= 0)
            {
                int choice = JOptionPane.showConfirmDialog(null,"Score" + player.ship_score + "Do you want to play again");
                if(choice == JOptionPane.YES_OPTION)
                {
                    player.Ship_health = 3;
                    enemies.clear();
                }
                else
                {
                    System.out.println("Exiting the game");
                    System.exit(0);
                }
            }
        }
    }
    private class DotListener implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent event)
        {           
            player.setShipPosition(event.getX(), event.getY()); 
            repaint();
            
        }
        public void mouseDragged(MouseEvent event)
        {

        }
    }
    
}
