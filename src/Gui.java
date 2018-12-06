import java.awt.*;
import java.net.URL;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

//TODO Delete all imports at the end and then add them one by one because dark voodoo reasons
public class Gui extends JFrame {
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
	private JTextField queryField;

	public static void main(String[] args) {
		JFrame gui = new Gui();

	}

	public Gui() {
		super("Pirex");
		contentPane = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);

		setIcon();
		setupPanels();
		setupMenu();

		this.setVisible(true);
	}

	private void setIcon() {
		URL iconUrl = Gui.class.getResource("assets/logo.png");
		icon = new ImageIcon(iconUrl);

		this.setIconImage(icon.getImage());
	}

	private void setupMenu() {
		menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);

		file = new JMenu("File");
		JMenuItem loadQuery = new JMenuItem("Load Query");
		JMenuItem export = new JMenuItem("Export");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem documents = new JMenuItem("Documents");

		options = new JMenu("Options");

		setupHelpMenu();

		loadQuery.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Function not available"));
		documents.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Function not available"));
		export.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Function not available"));
		exit.addActionListener((event) -> System.exit(0));
		file.add(loadQuery);
		file.add(export);
		file.add(exit);

		options.add(documents);

		menuBar.add(file);
		menuBar.add(options);
		menuBar.add(help);
	}
	
	private void setupHelpMenu()
	{
		help = new JMenu("Help");
		JMenuItem index = new JMenuItem("Index");
		JMenuItem about = new JMenuItem("About");
		
		about.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Made by Group 3"));
		index.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Function not available"));
		help.add(index);
		help.add(about);
	}

	private void setupPanels() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel borderPanel = new JPanel();
		borderPanel.setBorder(new EmptyBorder(0, 8, 8, 8));
		getContentPane().add(borderPanel);
		borderPanel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		borderPanel.add(tabbedPane);

		JPanel seachPanel = new JPanel();
		tabbedPane.addTab("Search Documents", null, seachPanel, null);
		seachPanel.setLayout(new BorderLayout(0, 0));

		JPanel queryPanel = new JPanel();
		seachPanel.add(queryPanel, BorderLayout.NORTH);
		queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.X_AXIS));

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(10, 0));
		queryPanel.add(horizontalStrut_1);

		JLabel query = new JLabel("Query:");
		query.setHorizontalAlignment(SwingConstants.LEFT);
		queryPanel.add(query);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setPreferredSize(new Dimension(10, 0));
		queryPanel.add(horizontalStrut_2);

		queryField = new JTextField();
		queryField.setHorizontalAlignment(SwingConstants.LEFT);
		queryPanel.add(queryField);
		queryField.setColumns(10);

		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				queryField.setText("");
			}
		});

		Component horizontalStrut = Box.createHorizontalStrut(20);
		queryPanel.add(horizontalStrut);
		btnClear.setHorizontalAlignment(SwingConstants.RIGHT);
		queryPanel.add(btnClear);

		JPanel textPanel = new JPanel();
		textPanel.setBorder(new EmptyBorder(0, 25, 0, 25));
		seachPanel.add(textPanel, BorderLayout.CENTER);
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		textPanel.add(verticalStrut_1);

		JTextArea textTop = new JTextArea();
		textTop.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textTop.setEditable(false);
		textPanel.add(textTop);

		Component verticalStrut = Box.createVerticalStrut(20);
		textPanel.add(verticalStrut);

		JTextArea textBot = new JTextArea();
		textBot.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textBot.setEditable(false);
		textPanel.add(textBot);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		textPanel.add(verticalStrut_2);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		textPanel.add(horizontalStrut_4);

		JPanel loadPanel = new JPanel();
		tabbedPane.addTab("Load Documents", null, loadPanel, null);

		JPanel summPanel = new JPanel();
		tabbedPane.addTab("Summarize Documents", null, summPanel, null);
		
	}
}
