package Models;

public class MapModel implements Model {
	
	
	public enum Modes{
		ZOOM("zoomin", "zoomout"),
		ROTATE("clockwise", "unticlockwise");
		String plusCommand;
		String minusCommand;
		private Modes(String p, String m) {
			this.plusCommand = p;
			this.minusCommand = m;
		}
		
		public String getPlusCommand() { return this.plusCommand;}
		public String getMinusCommand() {return this.minusCommand;}
		
	}
	private Modes modes;
	private  int zoom  = 7; 
	private String latitude;
	private String longitude;
	private String currentImage = "src/Images/CurrentState.png";
    private Modes currentMode = Modes.ZOOM;
	public MapModel() {}
	public void setZoom(int x) {this.zoom = x;}
	public int getZoom() {return this.zoom;}
	public Modes getModes() { return this.modes;}
	public Modes getCurrentMode() {return this.currentMode;}
	public void changeCurrentMode() { 
		if (currentMode == Modes.ZOOM) {
			currentMode = Modes.ROTATE;
		}
		else {
			currentMode = Modes.ZOOM;
		}
			}
	
	
}
