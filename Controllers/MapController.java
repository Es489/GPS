package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import Models.MapModel;
import Views.Main;
import Views.Map;

public class MapController extends Observable implements ActionListener, Controller {
	
	private Map mapview;
	private MapModel mapmodel;
	Main main;
	
	public MapController(Map p, MapModel m) {
		this.mapview = p;
		this.mapmodel = m;
	}

	
	public void connectMain(Main m) {this.main = m;}
	
	public void addButtonsActions() {
		this.main.getPlus().addActionListener(this);
		this.main.getPlus().setActionCommand(this.mapmodel.getCurrentMode().getPlusCommand());
		this.main.getMinus().addActionListener(this);
		this.main.getMinus().setActionCommand(this.mapmodel.getCurrentMode().getMinusCommand());
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


	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "zoomin": 
			this.mapview.remove(this.mapview.getMap());
			this.mapview.setZoom(this.mapview.getZoom() + 1);
			this.mapview.MainMapCreator();
			
			this.mapview.repaint();
			mapview.revalidate();
			break;
		case "zoomout":
			this.mapview.remove(this.mapview.getMap());
			this.mapview.setZoom(this.mapview.getZoom() - 1);
			this.mapview.MainMapCreator();
			this.mapview.repaint();
			mapview.revalidate();
			break;
		case "clockwise": 
			
			this.mapview.setRotation(this.mapview.getRotation() + 5);
			break;
		case "unticlockwise": 
			this.mapview.setRotation(this.mapview.getRotation() - 5);
			break;
		case "select": 
			this.mapmodel.changeCurrentMode();
			this.main.getPlus().setActionCommand(this.mapmodel.getCurrentMode().getPlusCommand());
			this.main.getMinus().setActionCommand(this.mapmodel.getCurrentMode().getMinusCommand());
			break;
		case "on": 
			this.mapview.setVisible(false);
			this.main.getPower().setActionCommand("off");
			break;
		case "off": 
			this.mapview.setVisible(true);
			this.main.getPower().setActionCommand("on");
			break;
		case "menu": 
			this.removeButtonsActions();
			setChanged();
			this.notifyObservers("menu");
			break;
		}
		
	}
}
