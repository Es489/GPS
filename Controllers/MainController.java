package Controllers;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import Models.MainModel;
import Models.MenuModel;
import Views.Main;

public class MainController implements Observer, Controller{
	Main mainview;
	MainModel data;
	
	int currentPanel;
	
	public MainController(Main v, MainModel m) {
	     
		this.mainview = v;
		this.data = m;
		((WhereToController) this.data.getController(0)).addObserver(this);
		
		((MapController) this.data.getController(2)).addObserver(this);
		((AboutController) this.data.getController(4)).addObserver(this);
		
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println(arg);
		if(this.data.getMenuController()==o) {
			this.data.setChosenPanel((int) arg);
		switch((int)arg) {
		case 0:
			this.data.getMenuView().setVisible(false);
			this.data.getMenuController().removeButtonsActions();
			this.mainview.add(this.data.getView(0));
			((WhereToController) this.data.getController(0)).displayLetterKeyboard();
			((WhereToController) this.data.getController(0)).connectMain(this.mainview);
			((WhereToController) this.data.getController(0)).addButtonsActions();
			System.out.println(this.data.getView(0).getName());
			this.mainview.repaint();
			this.mainview.revalidate();
			break;
		case 1:break;
		case 2:
			this.data.getMenuView().setVisible(false);
			this.data.getMenuController().removeButtonsActions();
			this.mainview.add(this.data.getView(2));
			((MapController) this.data.getController(2)).connectMain(this.mainview);
			((MapController) this.data.getController(2)).addButtonsActions();
			this.mainview.repaint();
			this.mainview.revalidate();
			break;
		case 3:
			/*this.data.getMenuView().setVisible(false);
			this.data.getMenuController().removeButtonsActions();
			this.mainview.add(this.data.getView(3));
			this.mainview.repaint();
			this.mainview.revalidate();*/
			break;
		case 4:
			this.data.getMenuView().setVisible(false);
			this.data.getMenuController().removeButtonsActions();
			this.mainview.add(this.data.getView(4));
			this.mainview.repaint();
			this.mainview.revalidate();
			break;
		case 5:
			this.data.getMenuView().setVisible(false);
			this.data.getMenuController().removeButtonsActions();
			this.mainview.add(this.data.getView(5));
			((AboutController) this.data.getController(4)).connectMain(this.mainview);
			((AboutController) this.data.getController(4)).addButtonsActions();
			this.mainview.repaint();
			this.mainview.revalidate();
			
			break;
		}
		}
		else if(arg == "menu"){
		
			this.mainview.remove(this.data.getView(1));
			this.data.getMenuView().setVisible(true);
			this.data.getMenuController().addButtonsActions();
			this.mainview.repaint();
			this.mainview.revalidate();
		}
		
		
		}
		
	}
	
	
	
	


