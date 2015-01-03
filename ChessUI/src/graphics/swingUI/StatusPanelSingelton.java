package graphics.swingUI;

import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public final class StatusPanelSingelton extends JPanel {

	public static final int CLICKED_STATUS_IND = 0;
	public static final int DRAGGED_STATUS_IND = 1;
	public static final int PRESSED_RELEASED_STATUS_IND = 2;
	public static final int IN_OUT_STATUS_IND = 3;
	public static final int MOUSE_MOVED_STATUS_IND = 4;
	public static final int SLEEP_TIME_STATUS_IND = 5;
	public static final int SPRITE_SELECTION = 6;
	
	
	private static StatusPanelSingelton instance = null;
	private static ArrayList<JLabel> statusLabels;
	private static int numberOfLabels = -1; //Start on -1 to make setStatus fail even when not initalized. 
	
	public static StatusPanelSingelton getInstance(){
		if(instance == null){
			instance = new StatusPanelSingelton();
		}
		return instance;	
	}
	
	public static String appendPoint(String statusMsg, Point p){
		String str = statusMsg;
		str += " (" + p.x ;
		str += " , " + p.y + ")";
		return str;
	}
	
	public static void setStatusWithPoint(String s,Point p, int labelIndex){
		String tmp = appendPoint(s,p);
		setStatus(tmp,labelIndex);
	}
	
	public static void setStatus(String s, int labelIndex){
		if(labelIndex<0 || labelIndex>=numberOfLabels){
			return;
		}
		String labelInfo = defaultStatus(labelIndex);
		statusLabels.get(labelIndex).setText(labelInfo + s);
	}
	
	private static String defaultStatus(int labelIndex){	
		return " | " + labelIndex + ". ";
	}
	
	private StatusPanelSingelton(){
		//Setup JLabel(s) with text(s)
		statusLabels = new ArrayList<JLabel>();
		numberOfLabels = 0;
		//setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setLayout(new GridLayout(2, 5));
		addLabel(); //0
		addLabel(); //1
		addLabel(); //2
		addLabel(); //3
		addLabel(); //4
		addLabel(); //5
		addLabel();
		addLabel();
	}
	
	private void addLabel(){
		JLabel tmp = new JLabel(defaultStatus(numberOfLabels)+ "status");
		//tmp.setHorizontalAlignment(SwingConstants.LEFT);
		add(tmp);
		statusLabels.add(tmp);
		numberOfLabels++;
	}
}
