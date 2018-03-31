package Views;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* 
 * OSX Ublox7 reader.
 * 
 * David Wakeling, 2018.
 */
public class UbloxSat implements Runnable {
       /* 
     * Modified Win7 Ublox7 reader.
     * 
     * Inspired form David Wakeling code, 2018.
     *
     * From rxtx-2.2pre2-bins.zip, extract RXTXcomm.jar and
     * the win64 version of rxtxSerial.dll.
     *
     * RXTXcomm.jar should be added to the CLASSPATH and 
     * rxtxSerial.dll should be placed in current directory.
     *
     * @Author Alexis Barbannaud
     * Reader.
     */
	 
  final static String FILE_NAME = "/dev/cu.usbmodem1421";
  //final static String FILE_NAME = "/dev/cu.usbmodem1441"; 
  final static int    BUFF_SIZE = 1024;
  String location;
  static UbloxValue ubloxValue;
  
    
  public UbloxSat(UbloxValue ubloxValue)
	{
        this.ubloxValue = ubloxValue;
	}
  /*
   * Reader.
   */
  private static void reader( String fileName ) {
    try {
      FileInputStream in = new FileInputStream( new File( fileName ) );
      byte[] buffer      = new byte[ BUFF_SIZE ];
      String s;
      int    n;
      String strLoc;         
      while ( ( n = in.read( buffer ) ) > -1 ) {
            strLoc = new String( buffer, 0, n );
          
            strLoc = strLoc.replaceAll("(?m)GPGSA.*", "");
            strLoc = strLoc.replaceAll("(?m)GPRMC.*", "");
            strLoc = strLoc.replaceAll("(?m)GPVTG.*", "");
            strLoc = strLoc.replaceAll("(?m)GPGGA.*", "");
            strLoc = strLoc.replaceAll("(?m)GPGSV.*", "");
            strLoc = strLoc.replaceAll("(?m)GPTXT.*", "");
            strLoc = strLoc.replaceAll("[$]","");
            strLoc = strLoc.replaceAll("(?m)^[ \t]*\r?\n", "");
            
            if(strLoc != "" && strLoc.length()>0 && strLoc.startsWith("GPGLL")){// Checks that the string is not empty
            	    
                ubloxValue.setCoordinates(strLoc);
                Thread.currentThread().sleep(5000);
            }
      }
    } catch ( Exception ex ) {
      System.out.println( ex ); System.exit( 1 );
    }
  }
   
  

@Override
public void run() {
	// TODO Auto-generated method stub
	reader( FILE_NAME );
} 
}