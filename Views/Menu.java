package Views;


import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Models.MenuModel;
import Models.MenuModel.Modes;

@SuppressWarnings("serial")
public class Menu extends JPanel{
	   private MenuModel m;
	   private Container modes;
	   
	   	public Menu(String s, MenuModel m) {
	   		
	   		this.modes = new Container(); 
	   		this.m = m;
	   		this.setLayout(null);
	   		this.setBounds(m.getPanelBounds());
	   		this.setBackground(this.m.getBackgroundColor());
	   		this.createMenuContainer();
	   		
	   	}
	   	
	  
		public void createMenuContainer() {
			
			this.modes.setLayout(this.m.getMenuLayout());
			
			for (Modes i: this.m.getModes()) {
				
				JLabel item = new JLabel(i.getName());
				ImageIcon p = new ImageIcon(i.getUrl());
				item.setIcon(p);
				item.setName(i.getName());
				item.setOpaque(true);
				item.setBackground(Color.WHITE);
				item.setSize(50, 70);
				item.setText(i.getName());
				item.setHorizontalTextPosition(this.m.getHorisontalTextPosition());
		        item.setVerticalTextPosition(this.m.getVerticalTextPosition());
		        
		        item.setHorizontalAlignment(this.m.getHorizontalAlignment());
				this.modes.add(item);
		}
			this.modes.setBounds(this.m.getMenuBounds());
			
			this.add(this.modes);
  
	
	
}
        
	   	public Container getMenuContainer() {return this.modes;}
   

}