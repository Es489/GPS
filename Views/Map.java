package Views;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.MapModel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Observable;


public class Map extends JPanel {
		
	final static String ExE_LATITUDE  = "50.7216";
    final static String ExE_LONGITUDE = "-3.5256";
	private String[] coordinates = null;
	private  int zoom  = 7;         
	final static String SIZE = "600x600"; 
	final static String POLYLINE = "apqtHl{oTCVsCkB]dDUrAWfAo@dCFXBp@G`AK|AK@";
	private String currentImage = "src/Images/CurrentState.png";
	
	private String[] mapModes= {"Zooming", "Rotation", "TrTrace"};
	private int current = 0;
	private Image im;
	private int rotate;
	private BufferedImage mapImage;
	private JLabel  mapp;
	private MapModel mapmodel;
	
	
	public  Map(MapModel m) {
		this.mapmodel = m;
		
		//mapImage = ImageIO.read( new File( "/Users/danchillman/Downloads/src/CurrentState.png" )) ;
		this.MainMapCreator();
		this.setLayout(null);
   		this.setBackground(Color.black);
   		this.setBounds(142,235,230,300);
			
	}
	
	
	
	
	
	
	static void writeData( String file, byte[] data ) {
	    try {
	      OutputStream os = new FileOutputStream( file );
	      os.write( data, 0, data.length );
	      os.close();
	    } catch ( IOException ex ) {
	      ex.printStackTrace(); System.exit( 1 );
	    }
	  }
	
	
	
	public int getZoom() {
		return this.zoom;
	}
	
	public void setZoom(int z) {
		this.zoom = z;
		
	}
	
	public JLabel getMap() {
		return this.mapp;
	}
	
	public byte[] LoadMap(int zom){
        final byte[] dis;
		String zoom = Integer.toString(zom);

		if(this.coordinates == null){
            dis = Map.readData(ExE_LATITUDE,ExE_LONGITUDE,zoom,SIZE,POLYLINE);
        }else{
            dis = Map.readData(this.coordinates[0],this.coordinates[1],zoom,SIZE,POLYLINE);
        }
		
		writeData( this.currentImage, dis );
		
	    return dis;
	}
    
	static byte[] readData( String latitude
            , String longitude
            , String zoom
            , String size
            , String polyline
            ) {
		final String method = "GET";
		final String url
		= ( "https://maps.googleapis.com/maps/api/staticmap"
				+ "?" + "center" + "=" + latitude + "," + longitude
				+ "&" + "zoom"   + "=" + zoom
				+ "&" + "size"   + "=" + size
				+ "&" + "path=weight:5%7Ccolor:red%7Cenc:" + polyline 
				);
		final byte[] body
		= {};
		final String[][] headers
		= {};
		byte[] response = HttpConnect.httpConnect( method, url, headers, body );
	
		
	return response;
	}
	
    public void setCoordinates(String[] coordinates) {
        this.coordinates = coordinates;
    }

    public int getRotation() {
		
		return this.rotate;
	}
	
	public void setRotation(int i) {
		
		this.rotate = i;
	}
	
	public void update( Observable obs, Object obj ) {
	    this.rotate = (int) obj;
	    repaint();
	  }
	
	 
	
	public void paintComponent(Graphics g) {
		
		try {
			this.mapImage = ImageIO.read( new File( "src/Images/CurrentState.png" )) ;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.paintComponent( g );
		double radians = Math.toRadians( (double) this.rotate );
		Graphics2D g2d = (Graphics2D) g;
	    
		g2d.rotate( radians, (this.mapImage.getWidth()/2)*0.5f, (this.mapImage.getHeight() / 2) *0.5f );
		g2d.drawImage( this.mapImage, 0, 0, this );
		
		this.repaint();
		this.revalidate();
	}
	
	
	
	public Dimension getPreferredSize() {
	    return new Dimension( this.mapImage.getWidth(), this.mapImage.getHeight() );
	  }
    
    
    public void MainMapCreator() {
		
		this.mapp = new JLabel(new ImageIcon(LoadMap(this.zoom)));
		this.mapp.setBounds(0, 0,230,300);
		this.add(this.mapp);
		   
	}	
    
    
}


