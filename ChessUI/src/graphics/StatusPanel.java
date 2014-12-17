package graphics;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public final class StatusPanel extends JPanel {

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
		addLabel();
		addLabel();
		addLabel();
		addLabel();
		addLabel();
	}
	
	private void addLabel(){
		JLabel tmp = new JLabel(defaultStatus(numberOfLabels)+ "status");
		tmp.setHorizontalAlignment(SwingConstants.LEFT);
		add(tmp);
		statusLabels.add(tmp);
		numberOfLabels++;
	}
	
	
}
