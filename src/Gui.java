import java.awt.*;
import java.net.URL;
import javax.swing.*;

//TODO Delete all imports at the end and then add them one by one because dark voodoo reasons
public class Gui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu options;
	private JMenu help;
	private ImageIcon icon;
	Container contentPane;
	private JPanel mainContent;
	
	public static void main(String[] args) {
		JFrame gui = new Gui();

	}
	
	public Gui()
	{
		super("Pirex");
		contentPane = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(new BorderLayout());
		this.setSize(600, 400);
		
		setIcon();
		setupMenu();			
		
		mainContent = new JPanel();
		getContentPane().add(mainContent, BorderLayout.CENTER);
		mainContent.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonPanel = new JPanel();
		mainContent.add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton searchBtn = new JButton("Search Documents");
		buttonPanel.add(searchBtn);
		
		JButton loadBtn = new JButton("Load Documents");
		buttonPanel.add(loadBtn);
		
		JButton summBtn = new JButton("Summarize Documents");
		buttonPanel.add(summBtn);
		this.setVisible(true);
	}
	
	private void setIcon() {
		URL iconUrl = Gui.class.getResource("assets/logo.png");
		icon = new ImageIcon(iconUrl);
		
		this.setIconImage(icon.getImage());
	}
	
	private void setupMenu() {
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		JMenuItem loadQuery = new JMenuItem("Load Query");
		JMenuItem export = new JMenuItem("Export");
		JMenuItem exit = new JMenuItem("Exit");
		
		options = new JMenu("Options");
		
		help = new JMenu("Help");
		JMenuItem index = new JMenuItem("Index");
		JMenuItem about = new JMenuItem("About");
		
		loadQuery.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Function not available"));
		export.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Function not available"));
		exit.addActionListener((event) -> System.exit(0));
		file.add(loadQuery);
		file.add(export);
		file.add(exit);
		
		about.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Made by Group 3"));
		index.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Function not available"));
		help.add(index);
		help.add(about);
		menuBar.add(file);
		menuBar.add(options);
		menuBar.add(help);
		getContentPane().add(menuBar, BorderLayout.NORTH);
	}
}
