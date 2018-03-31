package Views;


import static java.lang.Float.parseFloat;

import java.util.Observable;

/**
 *
 * @author Alexis Barbannaud
 */
public class UbloxValue extends Observable
{
    private float latitude , longitude;
    private String latitudeDir = "N", longitudeDir = "W";
    public String rawCoordinates = "";
    
    public UbloxValue()
    {
        
    }
    public void setCoordinates(String input)
    {
        int first_comma = input.indexOf(",");
        int second_comma = input.indexOf(",", first_comma + 1);
        int third_comma = input.indexOf(",", second_comma + 1);
        int fourth_comma = input.indexOf(",", third_comma + 1);
        int fifth_comma = input.indexOf(",", fourth_comma + 1);
        
        
        
        
        if (second_comma-first_comma !=1) {
        	    System.out.println("Input is " +input);
        	    System.out.println( "Latitude" + input.substring(first_comma+1, second_comma));
            this.latitude = parseFloat(input.substring(first_comma+1, second_comma));
            System.out.println( "LatitudeDir" + input.substring(second_comma+1, third_comma));
            this.latitudeDir = input.substring(second_comma+1, third_comma);
            System.out.println( "Longtitude" + input.substring(third_comma+1, fourth_comma));
            this.longitude = parseFloat(input.substring(third_comma+1, fourth_comma));
            this.longitudeDir = input.substring(fourth_comma+1, fifth_comma);
            this.rawCoordinates = input;
            
        }else{
            this.rawCoordinates = input;
            
            
        }
        this.setChanged();
	    this.notifyObservers(this.rawCoordinates);
    }
    
    public String getRawCoordinates()
    {
        return rawCoordinates;
    }
    public String getLatitude()
    {
        String strLatitude = String.valueOf(this.latitude);
        int pointToMove = strLatitude.indexOf(".");
        strLatitude = strLatitude.replaceAll("[.]","");
        strLatitude = strLatitude.substring(0, pointToMove-2) + "." + strLatitude.substring(pointToMove-2, strLatitude.length());
        return strLatitude+this.latitudeDir;
    }

    
    public String getLongitude()
    {
        String strLongitude = String.valueOf(this.longitude);
        int pointToMove = strLongitude.indexOf(".");
        strLongitude = strLongitude.replaceAll("[.]","");
        strLongitude = strLongitude.substring(0, pointToMove-2) + "." + strLongitude.substring(pointToMove-2, strLongitude.length());
        return strLongitude+this.longitudeDir;
    }
    
    public String[] getCoordinates()
    {
        String arr[] = new String[2];
        arr[0] = this.getLatitude();
        arr[1] = this.getLongitude();
        return arr;
    }

}