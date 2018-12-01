import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

//TODO Delete all imports at the end and then add them one by one because dark voodoo reasons
public class Gui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame window;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu options;
	private JMenu help;
	ImageIcon icon;
	
	public static void main(String[] args) {
		Gui gui = new Gui();

	}
	
	public Gui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window = new JFrame("Pirex: The faultier way of storing your archives");
		
		try {
			icon = new ImageIcon(ImageIO.read(new File("assets/logo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		window.setIconImage(icon.getImage());
		
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		options = new JMenu("Options");
		help = new JMenu("Help");
		
		JMenuItem index = new JMenuItem("Index");
		JMenuItem about = new JMenuItem("About");
		
		about.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Made by Group 3"));
		
		help.add(index);
		help.add(about);
		
		menuBar.add(file);
		menuBar.add(options);
		menuBar.add(help);
		
		window.setLayout(new BorderLayout());
		window.setVisible(true);
		window.setSize(600, 400);
		window.add(menuBar, BorderLayout.NORTH);
		
		
		
	}
	

}
