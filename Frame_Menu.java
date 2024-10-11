import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame_Menu extends JFrame {
    JLabel name ;
    JLabel speed;
    JPanel first ;   
    JPanel second ;
    JButton start;
    JTextField field_of_speed;
    JTextField field_of_name;
    public static boolean found2 = false;
    public static String name2 ;
    public static int speed2;      
    public static int WIDTH = 700;
    public static int HEIGHT = 500;


    public Frame_Menu()
    {
        super();
        name = new JLabel("Name",SwingConstants.CENTER);
        speed = new JLabel("Speed",SwingConstants.CENTER);
        first = new JPanel();;   
        second = new JPanel();
        start = new JButton("Start");
        field_of_speed = new JTextField();
        field_of_name = new JTextField(); 
        setPreferredSize(new Dimension(WIDTH, HEIGHT));  
        setSize(WIDTH, HEIGHT);
        this.setLayout(new GridLayout(3,1));
        first.setLayout(new GridLayout(1,2));
        second.setLayout(new GridLayout(1,2));
        first.add(name);
        first.add(field_of_name);
        second.add(speed);
        second.add(field_of_speed);
        add(first);
        add(second);
        start.addActionListener(new ButtonListener());
        add(start);
      
    }    

    private class ButtonListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent event)
        {
            boolean found = true;
            for(int i = 0; i < field_of_speed.getText().length(); i++)
            {
                if(!Character.isDigit(field_of_speed.getText().charAt(i)))
                {
                    found = false;
                    
                }
            }
            if(!field_of_name.getText().isEmpty() && !field_of_speed.getText().isEmpty())
            {
                if(found)
                {
                    name2 = field_of_name.getText();
                    GameFrame play = new GameFrame(field_of_name.getText(), Integer.parseInt(field_of_speed.getText()));  
                    play.add(new GamePanel(play));
                    play.pack();
                    play.setVisible(true);
                    setVisible(false);                   
                                                       
                }
                else
                {
                    JOptionPane.showMessageDialog(Frame_Menu.this, "Speed should be only numbers");
                }
            }
            else
            {
                if(field_of_name.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(Frame_Menu.this, "Name connot be empty");
                }
                else if(field_of_speed.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(Frame_Menu.this, "Speed cannot be empty");
                }
    
            }
            
        }
        
    }
    
    
    
  
}
