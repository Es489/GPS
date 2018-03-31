package Views;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Container;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;

/**
 * Main Satelite class used to set up the display.
 * It will in term display the location dynamically.
 * @author Alexis Barabannaud
 */
public class Satelite extends JPanel implements Observer{
    JLabel satelite;
    String locationInfo = "";
    UbloxValue ubloxValue;
    public Satelite( UbloxValue u ) throws IOException, InterruptedException{

        
        this.displayInf(locationInfo);
        this.repaint();
        this.revalidate();
      
        this.ubloxValue = u;
        ubloxValue.addObserver(this);
        
    }

    
    /**
     *Checks if the coordinates are known and then Displays the required text.
     *Will later use threading with SwingUtilities.invokeLater to dynamically
     * change the text according to the known information.
     * Will use: https://www.javamex.com/tutorials/threads/invokelater.shtml
     * as a reference
     */
    public void displayInf(String coordinates){
        if (coordinates == "" || coordinates.contains(",,,")){
            this.satelite = new JLabel();
            this.satelite.setText("<html> The position cannot <br /> be determined</html>");
            this.satelite.setHorizontalTextPosition(JLabel.CENTER);
            this.satelite.setForeground(Color.white);
            this.satelite.setFont(new Font("Arial Black", Font.PLAIN, 16));
            
            this.satelite.setBounds(50, 10, 150, 150);
            this.add(satelite);
            this.repaint();
            this.revalidate();
            
            
           }else{
            String[] coordArr = ubloxValue.getCoordinates();
            this.satelite.setText("<html><div style = 'text-align: center;'>"+coordArr[0]+" <br />"+coordArr[1]+"</div></html>");
            this.repaint();
            this.revalidate();
            
           }
           
    }


	@Override
	public void update(Observable o, Object arg) {
            locationInfo = (String) arg;
            System.out.println(locationInfo);
            this.displayInf(locationInfo);
            this.repaint();
            this.revalidate();
	}
    

    
}
