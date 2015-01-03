package graphics.swingUI;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public final class EventDisplayPanelSingelton extends JPanel {

	public static int MOUSE_CLICKED_ID =1;
	public static int MOUSE_PRESSED_ID =2;
	public static int MOUSE_RELEASED_ID =3;
	
	
	private static JTextArea text = new JTextArea("++++++ INIT ++++++");
	private static EventDisplayPanelSingelton instance;
	
	
	public static EventDisplayPanelSingelton getInstance(){
		if(instance == null){
			instance = new EventDisplayPanelSingelton();
		}
		return instance;	
	}
	
	public static void addEvent(int eventType){
		
	}
	
	public static void addEvent(MouseEvent e){
		addEvent(e.paramString());
	}
	
	public static void addEvent(String str){
		text.insert(str + "\n", 0);
	}
	
	private EventDisplayPanelSingelton(){
		JScrollPane scroll = new JScrollPane (text, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroll);
	}
	
	
}
