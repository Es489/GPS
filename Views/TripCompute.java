package Views;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class TripCompute extends JPanel{
    
    int km = 0;
    float speed = 0.0f;
    int hours = 0;
    int min = 0;
    int sec = 0;
    
	public TripCompute(String s) {
		this.setName(s);
		this.createProgress();
		
	}
	
	public void createProgress() {
		Container grid = new Container();
	    grid.setLayout(new GridLayout(3,1,5,5));
		
			Label x = new Label("<html><center><b>Trip odem</b><br>" + km + " KM");
			x.setSize(210,75);
			x.setFont(new Font(null, Font.PLAIN, 27));
			x.setAlignment(Label.CENTER);
			x.setBackground(Color.WHITE);
			grid.add(x);
			
			Label y  = new Label("<html><center><b>Speed</b><br>" + speed + " KM/H");
			y.setSize(210,75);
			y.setFont(new Font(null, Font.PLAIN, 27));
			y.setAlignment(Label.CENTER);
			y.setBackground(Color.WHITE);
			grid.add(y);
			Label z = new Label("<html><center><b>Moving Time</b>" +"<br>"+ hours + " h " + min +" min "+ sec + " sec" );
			z.setSize(210,65);
			z.setFont(new Font(null, Font.PLAIN, 26));
			z.setAlignment(Label.CENTER);
			z.setBackground(Color.WHITE);
			grid.add(z);
			
		
		
	    grid.setBounds(5, 5, 210, 280);
		this.add( grid);
		
	}
	/*
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(null);
		f.setSize(500,700);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
	

}
