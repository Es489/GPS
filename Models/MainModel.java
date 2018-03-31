package Models;
import java.awt.Container;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controllers.AboutController;
import Controllers.Controller;
import Controllers.MapController;
import Controllers.MenuController;
import Controllers.SpeechController;
import Controllers.TripComputerController;
import Controllers.WhereToController;
import Views.About;
import Views.Main;
import Views.Map;
import Views.Menu;
import Views.Satelite;
import Views.Speech;
import Views.TripCompute;
import Views.UbloxSat;
import Views.UbloxValue;
import Views.WhereTo;


public class MainModel implements Model{
	
	private  ArrayList<Controller> controllers = new ArrayList<Controller>(6);
	private  ArrayList<Model> models = new ArrayList<Model>(6);
	private ArrayList<JPanel> views = new ArrayList<JPanel>(6);
	
	public enum Buttons {
		POWER("Power","src/Images/power.png", 295, 156),
		SELECT("Select","src/Images/select.png", 76, 220),
		PLUS("Plus","src/Images/plus.png", 77,89),
		MINUS("Minus","src/Images/minus.png", 77, 147),
		MENU("Back","src/Images/menu.png", 389, 97);
		
		
		JButton btn;
		private Buttons(String name, String image, int x, int y) {
			this.btn = new JButton(name);
			ImageIcon im = new ImageIcon(image);
			this.btn.setIcon(im);
			this.btn.setBounds(x,y, im.getIconWidth(), im.getIconHeight());
			this.btn.setBorderPainted(false);
			
		}
		public JButton getBTN() {return this.btn;}
	}
	
	Buttons btns;
	Menu menuview;
	MenuModel menuModel;
	MenuController menu;
    JLabel backgroundImage = new JLabel( new ImageIcon("src/Images/trs.png"));
   
    int chosenPanel = 0;
   
	
    public MainModel() {
     
    	this.backgroundImage.setBounds(50, 0, 360, 650);
    
     
     
    	WhereTo whereview = new WhereTo("Where To?");
   
    	this.views.add(0, whereview);
    	WhereToModel whereModel = new WhereToModel();	
    	this.models.add(0, whereModel);
    	WhereToController where = new WhereToController(whereview, whereModel);
    this.controllers.add(0, where);
    
    TripComputerController tripcontr = new TripComputerController();
    this.controllers.add(1, tripcontr);
    TripComputerModel tmodel = new TripComputerModel();
	this.models.add(1, tmodel);
	TripCompute tview = new TripCompute("Trip Computer");
 	this.views.add(1, tview);
 	
    	MapModel mapmodel = new MapModel();
    	this.models.add(2, mapmodel);
    Map mapview = new Map(mapmodel);
	this.views.add(2, mapview);
    MapController mapcontr = new MapController(mapview, mapmodel);
    this.controllers.add(2, mapcontr);
    
    Speech speech = new Speech();
    this.views.add(3, speech);
    SpeechController scontr = new SpeechController();
    this.controllers.add(3, scontr);
    
    
    try {
    	     UbloxValue uvalue = new UbloxValue();
         UbloxSat usat = new UbloxSat(uvalue);
		 Satelite sat = new Satelite(uvalue);
		 this.views.add(4, sat);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    About aboutview = new About("About");
	this.views.add(5, aboutview);
	AboutController aboutController = new AboutController(aboutview);
	this.controllers.add(4, aboutController );
   
    
    	
    }
    
    
    public Menu getMenuView() {
    	   return this.menuview;
    }
    
    public MenuController getMenuController() { return this.menu;}
    public void setMenuController(MenuController m) { this.menu = m;}
    public void setMenuModel(MenuModel m) { this.menuModel = m;}
    public void setMenuView(Menu p) {this.menuview = p;}
    public  MenuModel getMenuModel() { return this.menuModel;}
    
    public Model getModel(int x) {
    	    return this.models.get(x);
    }
    
    public Controller getController(int x) { return this.controllers.get(x);}
    
    public JPanel getView(int x) { return this.views.get(x);}
    
    public void setChosenPanel(int x) { this.chosenPanel = x;}
    
    
	public JLabel getBackgroundImage() {return this.backgroundImage;}
	public Buttons getButton() {return this.btns;}
    
     public int getChosenPanelIndex() { return this.chosenPanel;}
    }
    
   
    
    
  

