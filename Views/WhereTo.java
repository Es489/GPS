package Views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class WhereTo extends JPanel{
	
	TextField user_input;
	Container letterKeyboard;
	Container numKeyboard ;
	
	
	public WhereTo(String s) {
		this.user_input = new TextField(1);
		this.setBounds(142,235, 220, 300);
	    this.setName(s);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.createUserInput("Input");
	  	
	}
	public TextField getTextField() {
		return this.user_input;
	}
	
	
	/*
	 * Creates text field
	 */
	public void createUserInput(String name) {
		this.user_input.setName(name);
		
		this.user_input.setBounds(10, 10, 200, 30);
		this.add(user_input);
	}
	
	
	
	/*
	 * Creates the number keyboard
	 */
	public void  createNumKey(String name, String[] n){
		this.numKeyboard  = new Container();
		this.numKeyboard.setName(name);
		this.numKeyboard.setBounds(10, 50, 200, 220);
		
		this.numKeyboard .setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		int row =0;
		int column =0 ;
		for(String i : n) {
			if(row >2) {
					column = 0;
					row++;
				}
			else if(column == 3) {
					column = 0;
					row++;	
				}
			 if (i=="del") {
					
					Label d = new Label("DEL");
					
					d.setName("del");
					d.setAlignment(Label.CENTER);
					c.gridwidth =2;
					c.gridheight=2;
					c.gridx = 1;
					c.gridy = 3;
					column++;
					
					d.setBackground(Color.white);
					this.numKeyboard .add(d,c);
				    	
				}
			else {
				
			Label x = new Label(i);
			x.setName(i);
			x.setAlignment(Label.CENTER);
			c.gridx = column;
			c.weightx =1.0;
			c.weighty = 1.0;
			c.gridy = row;
			c.insets = new Insets(1,1,1,1);
			column++;
			x.setBackground(Color.white);
			this.numKeyboard.add(x,c);
			
		}
	}
	
	}
		
	
	/*
	 * Creates letter keyboard
	 */
	public void createLetKey(String name, String[] k) {
		this.letterKeyboard = new Container();
		this.letterKeyboard.setBounds(10, 50, 200, 220);
		this.letterKeyboard.setLayout(new GridLayout(7,4,1,1));
		this.letterKeyboard.setName(name);
		
		this.letterKeyboard.setBackground(Color.WHITE);
		
		for(String i: k) {
			
		Label x = new Label(i);
		x.setName(i);
		x.setSize(60, 80);
		x.setAlignment(Label.CENTER);
		x.setBackground(Color.white);
		this.letterKeyboard.add(x);
		
		}
	
	}
	
	
	
	public String getUserInput() {
		return this.user_input.getText();
	}
	
	public Container getLetterKeyboard() {
		return this.letterKeyboard;
		}
    
	
	public Container getNumKeyboard() {
    	    return this.numKeyboard;
    }
	
	}
	


