package Models;
import java.awt.Container;

public class WhereToModel implements Model{
	
	String address = null;
	String letters[] = {"A","B","C","D","E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "space", "numb"};
	String numbers[] = {"1","2","3","4","5","6","7","8","9","0","back", "del"};
	Container currentKeyboard;
	
    public void setKeyboard(Container c) {
    	    this.currentKeyboard = c;
    }
    
    public Container getcurrentKeyboard() {return this.currentKeyboard;}
    
    public void setAddress(String a) {
    	    this.address = a;
    }
    
    public String getAddress() {
    	     return this.address;
    }
    
    public String[] getLetters() {
    	   return this.letters;
    }
    
    public String[] getNumbers() {
    	    return this.numbers;
    	
    }
}
