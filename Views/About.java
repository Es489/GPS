package Views;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * 
 */
public class About extends JPanel{
    
    //ImageIcon icon;
    
    public About(String s) {
    	      
       this.setLayout(null);
       this.setBackground(Color.BLACK);
       this.setBounds(142,235, 220, 300);
        
     
        ImageIcon MyImg = new ImageIcon("src/Images/Logo.png");
        Image img = MyImg.getImage();
        Image newImg = img.getScaledInstance(this.getWidth()-50,this.getHeight()-110,Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(newImg));
        label.setText("<html> <center>Version 3"+" <br>"+ "<center>Team M </br></center> </html>");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial Black", Font.PLAIN, 14));
        label.setBounds(10, 0, 200, 280);
        
        this.add(label);
        this.repaint();
    }
    
  
}
