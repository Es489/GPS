package Views;

import Controllers.MainController;
import Controllers.MenuController;
import Models.MainModel;
import Models.MenuModel;

import java.awt.Container;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Main extends JFrame{
	
	JButton plus;
	JButton minus;
	JButton select;
	JButton on_off;
	JButton backToMainMenu;
	JLabel navigatorImage;
	MainModel model;
	
	public Main(MainModel m) {
		this.model = m;
		this.setLayout(null);
		this.setSize(500,700);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.plus = this.model.getButton().PLUS.getBTN();
		this.minus = this.model.getButton().MINUS.getBTN();
		this.select = this.model.getButton().SELECT.getBTN();
		this.backToMainMenu = this.model.getButton().MENU.getBTN();
		this.on_off = this.model.getButton().POWER.getBTN(); 
		
		 

		this.setContentPane(this.model.getBackgroundImage());
		this.add(this.select);
		this.add(this.plus);
		this.add(this.minus);
		this.add(this.on_off);
		this.add(this.backToMainMenu);
		
		
		
	}
	 
	 public JButton getSelect() {
		 return this.select;
	 }
	 
	 public JButton getMenuBT() {
		 return this.backToMainMenu;
	 }
     
	 public JButton getPlus() {
		 return this.plus;
	 }
 
	 public JButton getMinus() {
		 return this.minus;
	 }
     
	 public JButton getPower() {
		 return this.on_off;
	 }
	 
	 public static void main(String[] args) {
		
		 MenuModel menuModel = new MenuModel();	
		 Menu menuview = new Menu("Menu", menuModel);
		 MenuController menu = new MenuController(menuview, menuModel);
		
		 MainModel m_model= new MainModel(); 
		 Main m = new Main(m_model);
		 menu.connectMain(m);
		 menu.addButtonsActions();
		 MainController main_conts = new MainController(m, m_model);
		 menu.addObserver(main_conts);
		 m_model.setMenuController(menu);
		 m_model.setMenuView(menuview);
		 m_model.setMenuModel(menuModel);
		 m.add(menuview);
		 m.repaint();
         m.revalidate();
		 
	 }

		
}
    	
    
 

