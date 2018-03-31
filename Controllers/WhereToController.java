package Controllers;
import Models.WhereToModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;

import Views.Main;
import Views.WhereTo;


public class WhereToController extends Observable implements ActionListener, Controller{
      WhereTo where;
      WhereToModel data;
      Main main;
      int current = -1;
  	  
    public WhereToController(WhereTo w, WhereToModel wm) {
  		  this.data = wm;
  		  this.where = w;
	      this.where.createLetKey("Letter Keyboard", this.data.getLetters()); 
	      this.where.createNumKey("Number Keyboard", this.data.getNumbers());
	      this.where.add(this.where.getLetterKeyboard());
	      this.where.add(this.where.getNumKeyboard());
	      this.where.getNumKeyboard().setVisible(false);
	      this.where.getLetterKeyboard().setVisible(false);
    }
  	  
  	  public void displayLetterKeyboard() {
  		 this.where.getLetterKeyboard().setVisible(true);
  		 this.data.setKeyboard(this.where.getLetterKeyboard());
  		 this.where.repaint();
  		 this.where.revalidate();
  		  
  	  }
  	  public void displayNumberKeyboard() {
  		  this.where.getNumKeyboard().setVisible(true);
  		  this.data.setKeyboard(this.where.getNumKeyboard());
  		  this.where.repaint();
 		  this.where.revalidate();
  		  
  	  }
  	public void connectMain(Main m) { this.main = m;}
	
  	public void addButtonsActions() {
		this.main.getPlus().addActionListener(this);
		this.main.getPlus().setActionCommand("plus");
		this.main.getMinus().addActionListener(this);
		this.main.getMinus().setActionCommand("minus");
		this.main.getSelect().addActionListener(this);
		this.main.getSelect().setActionCommand("select");
        this.main.getMenuBT().addActionListener(this);
        this.main.getMenuBT().setActionCommand("menu");
        this.main.getPower().addActionListener(this);
        this.main.getPower().setActionCommand("on");
		
	}
  	public void removeButtonsActions() {
		this.main.getPlus().removeActionListener(this);
		this.main.getMinus().removeActionListener(this);
		this.main.getSelect().removeActionListener(this);
		this.main.getMenuBT().removeActionListener(this);
		this.main.getPower().removeActionListener(this);
	}
  	public void recetCells() {
		for(Component i : this.data.getcurrentKeyboard().getComponents()) {
			i.setBackground(Color.WHITE);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()) {
		
		case "plus":
			this.current++;
			if (this.current > this.data.getcurrentKeyboard().getComponentCount()-1) {
				this.recetCells();
				this.current = 0;
				this.data.getcurrentKeyboard().getComponent(this.current).setBackground(Color.ORANGE);
				
			}
			else if (this.current == this.data.getcurrentKeyboard().getComponentCount()-1) {
				this.recetCells();
				this.data.getcurrentKeyboard().getComponent(this.current).setBackground(Color.ORANGE);
				this.current=this.data.getcurrentKeyboard().getComponentCount()-1;
			}
			else {
				this.recetCells();
				this.data.getcurrentKeyboard().getComponent(this.current).setBackground(Color.ORANGE);
			}
		    break;
		
		case "minus": 
			this.current--;
			if(this.current < 0) {
				this.recetCells();
				this.current = this.data.getcurrentKeyboard().getComponentCount()-1;
				this.data.getcurrentKeyboard().getComponent(this.current).setBackground(Color.ORANGE);
			}
			
			else {
				this.recetCells();
				this.data.getcurrentKeyboard().getComponent(this.current).setBackground(Color.ORANGE);
			}
			break;
			
		case "select":
			if (this.data.getcurrentKeyboard().getComponent(this.current).getName() == "space") {
				this.where.getTextField().setText(this.where.getTextField().getText() + " ");
			}
			else if (this.data.getcurrentKeyboard().getComponent(this.current).getName() == "numb") {
				this.recetCells();
				this.current = -1;
				this.data.getcurrentKeyboard().setVisible(false);
				this.displayNumberKeyboard();
				
			}
			else if(this.data.getcurrentKeyboard().getComponent(this.current).getName() =="back") {
				this.recetCells();
				this.current = -1;
				this.data.getcurrentKeyboard().setVisible(false);
				this.displayLetterKeyboard();
			}
			else if (this.data.getcurrentKeyboard().getComponent(this.current).getName() =="del") {
				this.where.getTextField().setText(this.where.getTextField().getText().substring(0, this.where.getTextField().getText().length()-1));
			}
			else {
			this.where.getTextField().setText(this.where.getTextField().getText() + this.data.getcurrentKeyboard().getComponent(this.current).getName());
			}
			break;
		case "menu":
			this.data.setAddress(this.where.getTextField().getText());
			this.where.getTextField().setText("");
			this.recetCells();
			this.current = -1;
			this.removeButtonsActions();
			setChanged();
			this.notifyObservers("menu");
			break;
		case "on": 
			   
			       this.where.setVisible(false);  
		           this.main.getPower().setActionCommand("off"); 
				   break;
		case "off": 
			        this.where.setVisible(true); 
					this.main.getPower().setActionCommand("on");
					break; 
		
	}
	}
  	  }
