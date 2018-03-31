package Controllers;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import Models.MenuModel;
import Views.Main;
import Views.Menu;

public class MenuController extends Observable implements ActionListener, Controller{
	MenuModel model; 
	Menu view; 
	Main main; 
	int current = -1;
	
	
	public MenuController(Menu a, MenuModel b) {
		this.view = a;
		this.model = b;
	
		
	}

	public void displayMenu() {
		this.main.add(this.view);
		this.main.repaint();
		this.main.revalidate();
	}
	
	public void connectMain(Main m) {
		this.main= m;
		
	}
	
	public void addButtonsActions() {
		this.main.getPlus().addActionListener(this);
		this.main.getPlus().setActionCommand(this.model.getButtons().PLUS.getCommand());
		this.main.getMinus().addActionListener(this);
		this.main.getMinus().setActionCommand(this.model.getButtons().MINUS.getCommand());
		this.main.getSelect().addActionListener(this);
		this.main.getSelect().setActionCommand(this.model.getButtons().SELECT.getCommand());
        this.main.getMenuBT().addActionListener(this);
        this.main.getMenuBT().setActionCommand(this.model.getButtons().MENU.getCommand());
        this.main.getPower().addActionListener(this);
        this.main.getPower().setActionCommand(this.model.getButtons().ON.getCommand());
	}
	public void removeButtonsActions() {
		this.main.getPlus().removeActionListener(this);
		this.main.getMinus().removeActionListener(this);
		this.main.getSelect().removeActionListener(this);
		this.main.getMenuBT().removeActionListener(this);
		this.main.getPower().removeActionListener(this);
	}
	
	public void recetCells() {
		for(Component i : this.view.getMenuContainer().getComponents() ) {
			i.setBackground(Color.WHITE);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action in Menu");
		switch(e.getActionCommand()) {
		
		case "plus":
			this.current++;
			if (this.current > this.view.getMenuContainer().getComponentCount()-1) {
				this.recetCells();
				this.current = 0;
				this.view.getMenuContainer().getComponent(this.current).setBackground(Color.ORANGE);
				
			}
			else if (this.current == this.view.getMenuContainer().getComponentCount()-1) {
				this.recetCells();
				this.view.getMenuContainer().getComponent(this.current).setBackground(Color.ORANGE);
				this.current=this.view.getMenuContainer().getComponentCount()-1;
			}
			else {
				this.recetCells();
				this.view.getMenuContainer().getComponent(this.current).setBackground(Color.ORANGE);
			}
		    break;
		
		case "minus": 
			this.current--;
			if(this.current < 0) {
				this.recetCells();
				this.current = this.view.getMenuContainer().getComponentCount()-1;
				this.view.getMenuContainer().getComponent(this.current).setBackground(Color.ORANGE);
			}
			
			else {
				this.recetCells();
				this.view.getMenuContainer().getComponent(this.current).setBackground(Color.ORANGE);
			}
			break;
			
		case "select":
			
		    this.model.setCurrentPanelIndex(this.current);
		    this.setChanged();
   	        this.notifyObservers(this.current);
			break;
		case "back":
			this.recetCells();
			this.view.setVisible(true);
			current = -1;
			break;
		case "on": this.view.setVisible(false);  
				   this.main.getPower().setActionCommand(this.model.getButtons().OFF.getCommand()); 
				   break;
		case "off": this.view.setVisible(true); 
					this.main.getPower().setActionCommand(this.model.getButtons().ON.getCommand());
					break;
		
	}
	

}

	
}
