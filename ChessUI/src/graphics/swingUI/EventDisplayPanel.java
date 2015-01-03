package graphics.swingUI;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EventDisplayPanel extends JPanel {

	public static int MOUSE_CLICKED_ID =1;
	public static int MOUSE_PRESSED_ID =2;
	public static int MOUSE_RELEASED_ID =3;
	
	
	private static JTextArea text = new JTextArea("++++++ INIT ++++++");
	private static EventDisplayPanel instance;
	
	
	public static EventDisplayPanel getInstance(){
		if(instance == null){
			instance = new EventDisplayPanel();
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
	
	private EventDisplayPanel(){
		JScrollPane scroll = new JScrollPane (text, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//this.add(text);
		this.add(scroll);
	}
	
	
}
