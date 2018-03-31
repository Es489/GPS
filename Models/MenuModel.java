package Models;


import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controllers.Controller;



public class MenuModel implements Model {
	
	public enum Buttons{
		ON("on"), OFF("off"), PLUS("plus"), MINUS("minus"), SELECT("select"), MENU("back");
		
		private String command;
		private Buttons(String c) {
			this.command = c;
		}
		
		public String getCommand() {
			return this.command;
		}
		
	}
	public enum Modes { 
		WHERE("Where To?","src/Images/Where To?.png"), 
		TRIP("Trip Computer", "src/Images/Trip Computer.png"), 
		MAP("Map", "src/Images/Map.png"), 
		SPEECH("Speech", "src/Images/Speech.png"), 
		SATELITE("Satelite", "src/Images/Satelite.png"), 
		ABOUT("About", "src/Images/About.png");
		private String name;
		private String url;
		
		private Modes(String n, String u) {
			this.name = n;
			this.url = u;
		}
		public String getUrl() { return this.url;}
		
		public String getName() {return this.name;}
		
		}
	private Modes mode; 
	private Buttons btn;
	private int mode_width = 50;
	private int mode_hight = 70; 
    private int horisontalTextPosition = SwingConstants.CENTER;
    private int verticalTextPosition = SwingConstants.BOTTOM;
    private int horizontalAlignment = SwingConstants.CENTER;
    private GridLayout menuLayout = new GridLayout(3,2,5,5);
    private Rectangle menuBounds = new Rectangle(10,10,210,280); 
    private Rectangle panelBounds = new Rectangle(142,235, 230, 300);
	private java.awt.Color backGround = java.awt.Color.BLACK;
	private int currentPanelIndex = 0;
	
	
	
	public MenuModel() {
			
	}
    public Modes[] getModes() {
    		return Modes.values();
    	}
    public void setCurrentPanelIndex(int x) {
    	     this.currentPanelIndex = x;
    	     
    	     
    }
    public int getCurrentIndex() { return this.currentPanelIndex;}
    public Buttons getButtons() {
    	    return this.btn;
    }
    public int getModeWidth() { 
    		return this.mode_width;
    	}
     
    public int getModeHight() {
		return this.mode_hight;
	}
	public int getHorisontalTextPosition() {
		return this.horisontalTextPosition;
	}
	public int getVerticalTextPosition() {
		return this.verticalTextPosition;
	}
	public int getHorizontalAlignment() {
		return this.horizontalAlignment;
	}
	public GridLayout getMenuLayout() {
		return this.menuLayout;
	}
    
	public Rectangle getMenuBounds() { return this.menuBounds;}
	
	public Rectangle getPanelBounds() { return this.panelBounds;}
	
	public java.awt.Color getBackgroundColor() { return this.backGround;}

	
}
