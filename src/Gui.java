import java.awt.*;
import javax.swing.*;

public class Gui {

	private JFrame window;
	
	//please put the menus into dropDownMenus
	private JPanel dropDownMenus;
	
	public static void main(String[] args) {
		Gui gui = new Gui();

	}
	
	public Gui()
	{
		window = new JFrame("Pirex: The faultier way of storing your archives");
		dropDownMenus = new JPanel();
		window.setLayout(new BorderLayout());
		window.setVisible(true);
		window.setSize(600, 400);
		window.add(dropDownMenus);
	}
	

}
