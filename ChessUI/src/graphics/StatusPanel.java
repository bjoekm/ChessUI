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
	private static int numberOfLabels = 0;
	
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
		statusLabels.get(labelIndex).setText(s);
	}
	
	private  StatusPanel(){
		//Setup JLabel(s) with text(s)
		statusLabels = new ArrayList<JLabel>();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		addLabel();
	}
	
	private void addLabel(){
		JLabel tmp = new JLabel("status");
		tmp.setHorizontalAlignment(SwingConstants.LEFT);
		add(tmp);
		statusLabels.add(tmp);
		numberOfLabels++;
	}
	
	
}
