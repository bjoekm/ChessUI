package graphics;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public final class StatusPanel extends JPanel {

	public static int CLICKED_STATUS_IND = 0;
	public static int DRAGGED_STATUS_IND = 1;
	public static int PRESSED_RELEASED_STATUS_IND = 2;
	public static int IN_OUT_STATUS_IND = 3;
	public static int MOUSE_MOVED_STATUS_IND = 4;
	public static int SLEEP_TIME_STATUS_IND = 5;
	
	
	private static StatusPanel instance = null;
	private static ArrayList<JLabel> statusLabels;
	private static int numberOfLabels = -1; //Start on -1 to make setStatus fail even when not initalized. 
	
	public static StatusPanel getInstance(){
		if(instance == null){
			instance = new StatusPanel();
		}
		return instance;	
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
	
	private StatusPanel(){
		//Setup JLabel(s) with text(s)
		statusLabels = new ArrayList<JLabel>();
		numberOfLabels = 0;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		addLabel(); //0
		addLabel(); //1
		addLabel(); //2
		addLabel(); //3
		addLabel(); //4
		addLabel(); //5
	}
	
	private void addLabel(){
		JLabel tmp = new JLabel(defaultStatus(numberOfLabels)+ "status");
		tmp.setHorizontalAlignment(SwingConstants.LEFT);
		add(tmp);
		statusLabels.add(tmp);
		numberOfLabels++;
	}
	
	
}
