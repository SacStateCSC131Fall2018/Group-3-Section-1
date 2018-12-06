import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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

		setupFileMenu();
		setupOptionsMenu();
		setupHelpMenu();

		menuBar.add(file);
		menuBar.add(options);
		menuBar.add(help);
	}

	private void setupFileMenu()
	{
		file = new JMenu("File");
		JMenuItem loadQuery = new JMenuItem("Load Query");
		JMenuItem export = new JMenuItem("Export");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem saveQuery = new JMenuItem("Save Query");

		export.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Function not available"));
		exit.addActionListener((event) -> System.exit(0));
		saveQuery.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Function not available"));

		file.add(loadQuery);
		file.add(saveQuery);
		file.add(export);
		file.add(exit);

		loadQuery.addActionListener(new ActionListener()
		{

			JFileChooser cho;
			String cht;

			public void actionPerformed(ActionEvent e) {

				cho = new JFileChooser();
				cho.setCurrentDirectory(new java.io.File("."));
				cho.setDialogTitle(cht);
				cho.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				cho.setAcceptAllFileFilterUsed(false);

				if (cho.showOpenDialog(loadQuery) == JFileChooser.APPROVE_OPTION) {
							cho.getCurrentDirectory();
							cho.getSelectedFile();
				}
			}
		});

	}

	private void setupOptionsMenu()
	{
		options = new JMenu("Options");
		JMenuItem documents = new JMenuItem("Documents");

		options.add(documents);

		documents.addActionListener(new ActionListener() {

			JFileChooser chooser;
			String choosertitle;

			public void actionPerformed(ActionEvent e) {

				chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle(choosertitle);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(documents) == JFileChooser.APPROVE_OPTION) {
							chooser.getCurrentDirectory();
							chooser.getSelectedFile();
				}
			}
		});
	}

	private void setupHelpMenu()
	{
		help = new JMenu("Help");
		JMenuItem index = new JMenuItem("Index");
		JMenuItem about = new JMenuItem("About");

		about.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Made by Group 3:\nColby Biegler \nIldebrando agerdahl \nMathew Iwasa \nJose Montanez \nDaniel Shevchyk \nJedjarvin Ragay \nKimlee Chea \nVu Nguyen"));
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

		JPanel searchPanel = new JPanel();
		tabbedPane.addTab("Search Documents", null, searchPanel, null);
		searchPanel.setLayout(new BorderLayout(0, 0));

		JPanel queryPanel = new JPanel();
		searchPanel.add(queryPanel, BorderLayout.NORTH);
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
		searchPanel.add(textPanel, BorderLayout.CENTER);
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		textPanel.add(verticalStrut_1);

		JTextArea textTop = new JTextArea();
		textTop.setBorder(BorderFactory.createLineBorder(Color.black));
		textTop.setEditable(false);
		textPanel.add(textTop);

		Component verticalStrut = Box.createVerticalStrut(20);
		textPanel.add(verticalStrut);

		JTextArea textBot = new JTextArea();
		textBot.setBorder(BorderFactory.createLineBorder(Color.black));
		textBot.setEditable(false);
		textPanel.add(textBot);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		textPanel.add(verticalStrut_2);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		textPanel.add(horizontalStrut_4);

		// Load tab code starts here
		JPanel loadPanel = new JPanel();
		tabbedPane.addTab("Load Documents", null, loadPanel, null);
		loadPanel.setLayout(new BorderLayout(0, 0));

		JPanel loadFilePanel = new JPanel();
		loadPanel.add(loadFilePanel, BorderLayout.NORTH);
		loadFilePanel.setLayout(new BoxLayout(loadFilePanel, BoxLayout.Y_AXIS));

		JPanel textFilePanel = new JPanel();
		loadFilePanel.add(textFilePanel);
		textFilePanel.setLayout(new BoxLayout(textFilePanel, BoxLayout.X_AXIS));

		Component textFilePanelStrut_0 = Box.createHorizontalStrut(20);
		textFilePanelStrut_0.setPreferredSize(new Dimension(10, 0));
		textFilePanel.add(textFilePanelStrut_0);

		JLabel textFile = new JLabel("Text File: ");
		textFile.setHorizontalAlignment(SwingConstants.LEFT);
		textFilePanel.add(textFile);

		Component textFilePanelStrut_1 = Box.createHorizontalStrut(20);
		textFilePanelStrut_1.setPreferredSize(new Dimension(10, 0));
		textFilePanel.add(textFilePanelStrut_1);

		JTextField textFilePath = new JTextField();
		textFilePath.setHorizontalAlignment(SwingConstants.LEFT);
		textFilePath.setColumns(10);
		textFilePanel.add(textFilePath);

		Component textFilePanelStrut_2 = Box.createHorizontalStrut(20);
		textFilePanelStrut_2.setPreferredSize(new Dimension(10, 0));
		textFilePanel.add(textFilePanelStrut_2);

		JButton browse = new JButton("Browse");
		textFilePanel.add(browse);
		browse.addActionListener(new ActionListener() {
			JFileChooser chooser;
			String chooserTitle;

			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle(chooserTitle);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(browse) == JFileChooser.APPROVE_OPTION) {
							chooser.getCurrentDirectory();
							chooser.getSelectedFile();
				}
			}
		});

		Component textFilePanelStrut_3 = Box.createHorizontalStrut(20);
		textFilePanelStrut_3.setPreferredSize(new Dimension(10, 0));
		textFilePanel.add(textFilePanelStrut_3);

		Component textFilePanelSpacer_1 = Box.createVerticalStrut(10);
		loadFilePanel.add(textFilePanelSpacer_1);

		JPanel textFileTypePanel = new JPanel();
		loadFilePanel.add(textFileTypePanel);
		textFileTypePanel.setLayout(new BoxLayout(textFileTypePanel, BoxLayout.X_AXIS));

		Component textFileTypeStrut_1 = Box.createHorizontalStrut(20);
		textFileTypeStrut_1.setPreferredSize(new Dimension(10, 0));
		textFileTypePanel.add(textFileTypeStrut_1);

		JLabel textFileType = new JLabel("Text File Type: ");
		textFile.setHorizontalAlignment(SwingConstants.LEFT);
		textFileTypePanel.add(textFileType);

		Component textFileTypeStrut_2 = Box.createHorizontalStrut(20);
		textFileTypeStrut_2.setPreferredSize(new Dimension(10, 0));
		textFileTypePanel.add(textFileTypeStrut_2);

		Component loadFileVertStrut_1 = Box.createVerticalStrut(10);
		loadFilePanel.add(loadFileVertStrut_1);

		JComboBox fileType;
		String fileTypes[] = {"Project Gutenberg File", ".txt", ".rtf"};
		fileType = new JComboBox (fileTypes);
		fileType.setBackground(Color.WHITE);
		textFileTypePanel.add(fileType);

		Component titleAuthorStrut_1 = Box.createHorizontalStrut(20);
		titleAuthorStrut_1.setPreferredSize(new Dimension(10, 0));
		textFileTypePanel.add(titleAuthorStrut_1);

		JPanel titleAuthorPanel = new JPanel();
		loadFilePanel.add(titleAuthorPanel);
		titleAuthorPanel.setLayout(new BoxLayout(titleAuthorPanel, BoxLayout.X_AXIS));

		Component loadFileVertStrut_2 = Box.createVerticalStrut(10);
		loadFilePanel.add(loadFileVertStrut_2);

		Component titleAuthorStrut_2 = Box.createHorizontalStrut(20);
		titleAuthorStrut_2.setPreferredSize(new Dimension(10, 0));
		titleAuthorPanel.add(titleAuthorStrut_2);

		JLabel title = new JLabel("Title: ");
		title.setHorizontalAlignment(SwingConstants.LEFT);
		titleAuthorPanel.add(title);

		Component titleAuthorStrut_3 = Box.createHorizontalStrut(20);
		titleAuthorStrut_3.setPreferredSize(new Dimension(10, 0));
		titleAuthorPanel.add(titleAuthorStrut_3);

		JTextArea titleField = new JTextArea();
		titleField.setBorder(BorderFactory.createLineBorder(Color.black));
		titleField.setEditable(true);
		titleAuthorPanel.add(titleField);

		Component titleAuthorStrut_4= Box.createHorizontalStrut(20);
		titleAuthorStrut_4.setPreferredSize(new Dimension(10, 0));
		titleAuthorPanel.add(titleAuthorStrut_4);

		JLabel author = new JLabel("Author: ");
		author.setHorizontalAlignment(SwingConstants.LEFT);
		titleAuthorPanel.add(author);

		Component titleAuthorStrut_5 = Box.createHorizontalStrut(20);
		titleAuthorStrut_5.setPreferredSize(new Dimension(10, 0));
		titleAuthorPanel.add(titleAuthorStrut_5);

		JTextArea authorField = new JTextArea();
		authorField.setBorder(BorderFactory.createLineBorder(Color.black));
		authorField.setEditable(true);
		titleAuthorPanel.add(authorField);

		Component titleAuthorStrut_6 = Box.createHorizontalStrut(20);
		titleAuthorStrut_6.setPreferredSize(new Dimension(10, 0));
		titleAuthorPanel.add(titleAuthorStrut_6);

		loadFilePanel.add(new JSeparator(SwingConstants.HORIZONTAL));

		Component loadFileVertStrut_3 = Box.createVerticalStrut(10);
		loadFilePanel.add(loadFileVertStrut_3);

		JPanel processPanel = new JPanel();
		processPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
		loadFilePanel.add(processPanel);
		processPanel.setLayout(new BoxLayout(processPanel, BoxLayout.X_AXIS));

		JButton process = new JButton("Process");
		process.setAlignmentX(Component.LEFT_ALIGNMENT);
		processPanel.add(process);
		process.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Process function disabled/not available."));

		Component loadFileVertStrut_4 = Box.createVerticalStrut(10);
		processPanel.add(loadFileVertStrut_4);

		JPanel processTextPanel = new JPanel();
		processTextPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		loadPanel.add(processTextPanel);
		processTextPanel.setLayout(new BorderLayout());

		JTextArea processedText = new JTextArea();
		processedText.setBorder(BorderFactory.createLineBorder(Color.black));
		processedText.setEditable(false);
		processTextPanel.add(processedText);
		//End Load tab code

		// Start Summarize Panel
		JPanel summPanel = new JPanel();
		tabbedPane.addTab("Summarize Documents", null, summPanel, null);
		summPanel.setLayout(new BorderLayout(0,0));

		JPanel fileInfoPanel = new JPanel();
		summPanel.add(fileInfoPanel, BorderLayout.NORTH);
		fileInfoPanel.setLayout(new BoxLayout(fileInfoPanel, BoxLayout.X_AXIS));

		Component fileInfoHStrut_1 = Box.createHorizontalStrut(20);
		fileInfoHStrut_1.setPreferredSize(new Dimension(10,0));
		fileInfoPanel.add(fileInfoHStrut_1);

		JLabel filePathLabel = new JLabel("File Path:");
		filePathLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fileInfoPanel.add(filePathLabel);

		Component fileInfoHStrut_2 = Box.createHorizontalStrut(20);
		fileInfoHStrut_2.setPreferredSize(new Dimension(10,0));
		fileInfoPanel.add(fileInfoHStrut_2);

		JTextField filePathField = new JTextField("C:\\Users\\TestUser\\AppData\\Pirex\\testOpus_01.txt");
		filePathField.setHorizontalAlignment(SwingConstants.LEFT);
		filePathField.setColumns(10);
		filePathField.setEditable(false);
		fileInfoPanel.add(filePathField);

		JPanel opusInfoPanel = new JPanel();
		summPanel.add(opusInfoPanel, BorderLayout.CENTER);
		opusInfoPanel.setLayout(new BoxLayout(opusInfoPanel, BoxLayout.PAGE_AXIS));

		Component opusInfoStrut_V1 = Box.createVerticalStrut(20);
		opusInfoPanel.add(opusInfoStrut_V1);

		JPanel opusTitle = new JPanel();
		opusTitle.setLayout(new BoxLayout(opusTitle, BoxLayout.X_AXIS));
		opusInfoPanel.add(opusTitle);

		Component opusTitleStrut_H1 = Box.createHorizontalStrut(20);
		opusTitleStrut_H1.setPreferredSize(new Dimension(10,0));
		opusTitle.add(opusTitleStrut_H1);

		JLabel opusTitleLabel = new JLabel("Opus Title:");
		opusTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		opusTitle.add(opusTitleLabel);

		Component opusTitleStrut_H2 = Box.createHorizontalStrut(20);
		opusTitleStrut_H2.setPreferredSize(new Dimension(10,0));
		opusTitle.add(opusTitleStrut_H2);

		JTextField opusTitleField = new JTextField("Test Opus");
		opusTitleField.setHorizontalAlignment(SwingConstants.LEFT);
		opusTitleField.setEditable(false);
		opusTitle.add(opusTitleField);

		Component opusInfoStrut_V2 = Box.createVerticalStrut(10);
		opusInfoPanel.add(opusInfoStrut_V2);

		JPanel opusAuthor = new JPanel();
		opusAuthor.setLayout(new BoxLayout(opusAuthor, BoxLayout.X_AXIS));
		opusInfoPanel.add(opusAuthor);

		Component opusAuthorStrut_H1 = Box.createHorizontalStrut(20);
		opusAuthorStrut_H1.setPreferredSize(new Dimension(10,0));
		opusAuthor.add(opusAuthorStrut_H1);

		JLabel opusAuthorLabel = new JLabel("Opus Author:");
		opusAuthorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		opusAuthor.add(opusAuthorLabel);

		Component opusAuthorStrut_H2 = Box.createHorizontalStrut(20);
		opusAuthorStrut_H2.setPreferredSize(new Dimension(10,0));
		opusAuthor.add(opusAuthorStrut_H2);

		JTextField opusAuthorField = new JTextField("Group 3");
		opusAuthorField.setHorizontalAlignment(SwingConstants.LEFT);
		opusAuthorField.setEditable(false);
		opusAuthor.add(opusAuthorField);

		Component opusInfoStrut_V3 = Box.createVerticalStrut(10);
		opusInfoPanel.add(opusInfoStrut_V3);

		JPanel opusExtras = new JPanel();
		opusExtras.setLayout(new BoxLayout(opusExtras, BoxLayout.X_AXIS));
		opusInfoPanel.add(opusExtras);

		Component opusExtraStrut_H1 = Box.createHorizontalStrut(10);
		opusExtraStrut_H1.setPreferredSize(new Dimension(10,0));
		opusExtras.add(opusExtraStrut_H1);

		JLabel opusOrdiLabel = new JLabel("Ordinal Numbers: ");
		opusExtras.add(opusOrdiLabel);
		JTextField opusOrdiField = new JTextField("");
		opusOrdiField.setEditable(false);
		opusExtras.add(opusOrdiField);

		Component opusExtraStrut_H2 = Box.createHorizontalStrut(10);
		opusExtraStrut_H2.setPreferredSize(new Dimension(10,0));
		opusExtras.add(opusExtraStrut_H2);

		JLabel opusDocNumLabel = new JLabel("# of Documents: ");
		opusExtras.add(opusDocNumLabel);
		JTextField opusDocNumField = new JTextField("");
		opusDocNumField.setEditable(false);
		opusExtras.add(opusDocNumField);

		Component opusExtraStrut_H3 = Box.createHorizontalStrut(10);
		opusExtraStrut_H3.setPreferredSize(new Dimension(10,0));
		opusExtras.add(opusExtraStrut_H3);

		JLabel opusIndexLabel = new JLabel("# of Index Terms: ");
		opusExtras.add(opusIndexLabel);
		JTextField opusIndexField = new JTextField("");
		opusIndexField.setEditable(false);
		opusExtras.add(opusIndexField);

		Component opusExtraStrut_H4 = Box.createHorizontalStrut(10);
		opusExtraStrut_H4.setPreferredSize(new Dimension(10,0));
		opusExtras.add(opusExtraStrut_H4);

		JLabel opusPostLabel = new JLabel("# of Postings: ");
		opusExtras.add(opusPostLabel);
		JTextField opusPostField = new JTextField("");
		opusPostField.setEditable(false);
		opusExtras.add(opusPostField);

	}
}
