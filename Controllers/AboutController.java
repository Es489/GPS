package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import Views.About;
import Views.Main;

public class AboutController extends Observable implements ActionListener, Controller {
       About view;
       Main main;
       
       public AboutController(About a) {
    	       this.view = a;
       }
       
       public void connectMain(Main m) { this.main = m;}
       
       public  void addButtonsActions() {
    	       this.main.getMenuBT().addActionListener(this);
    	       this.main.getMenuBT().setActionCommand("menu");
    	       this.main.getPower().addActionListener(this);
    	       this.main.getPower().setActionCommand("off");
    	   
       }
      
       public void removeButtonsActions() {
    	   	this.main.getMenuBT().removeActionListener(this);
   		this.main.getPower().removeActionListener(this);
       }
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		
		case "menu":
			this.removeButtonsActions();
			setChanged();
			this.notifyObservers("menu");
			break;
		case "on": 
			view.setVisible(true);
			this.main.getPower().setActionCommand("off");
			break;
		case "off":
			view.setVisible(false);
			this.main.getPower().setActionCommand("on");
			break;
		}
	}
       
       
       
       
}
