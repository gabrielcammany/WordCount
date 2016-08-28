package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Manager;


public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public static final String STRUCTURE0 = "Default";
	public static final String STRUCTURE1 = "Binary Tree";
	public static final String STRUCTURE2 = "AVL tree";
	public static final String STRUCTURE3 = "Hash Tables";
	public static final String STRUCTURE4 = "Hash + Tree";	
	public static final String OPTION0 = "Select Entry File";
	public static final String OPTION1 = "Calculate";
	public static final String OPTION2 = "See Result";
	public static final String OPTION3 = "Exit";
	
	private final JFileChooser fc = new JFileChooser();
	private JButton filechooserButton;
	private JButton calculateButton;
	private JButton resultButton;
	private JButton exitButton;
	private JPanel structPanel;
	private JLabel txtStructure;
	private JPanel labelPanel;
	private JRadioButton[] radiobuttons;


	public MainWindow(String title) {

		initWindow(title);

		//FileChooser
		filechooserButton = new JButton(OPTION0);
		GridBagConstraints gbc_1 = new GridBagConstraints();
		gbc_1.fill = GridBagConstraints.BOTH;
		gbc_1.insets = new Insets(0, 0, 0, 5);
		gbc_1.gridx = 0;
		gbc_1.gridy = 0;
		filechooserButton.setActionCommand(OPTION0);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fc.setFileFilter(filter);
		getContentPane().add(filechooserButton);

		//CalculateButton
		calculateButton = new JButton(OPTION1);
		GridBagConstraints gbc_2 = new GridBagConstraints();
		gbc_2.insets = new Insets(0, 0, 0, 5);
		gbc_2.gridx = 1;
		gbc_2.gridy = 0;		
		calculateButton.setActionCommand(OPTION1);
		getContentPane().add(calculateButton);
		
		//Struct Selector
		structPanel = new JPanel();
		getContentPane().add(structPanel);
		structPanel.setLayout(new GridLayout(0, 2, 0, 0));

		//Structure
		labelPanel = new JPanel();
		structPanel.add(labelPanel);
		labelPanel.setLayout(new BorderLayout(0, 0));
		txtStructure = new JLabel();
		labelPanel.add(txtStructure);
		txtStructure.setText("Structure:");

		//radiobutton
		radiobuttons = new JRadioButton[5];
		radiobuttons[0] = new JRadioButton(STRUCTURE0);
		radiobuttons[1] = new JRadioButton(STRUCTURE1);
		radiobuttons[2] = new JRadioButton(STRUCTURE2);
		radiobuttons[3] = new JRadioButton(STRUCTURE3);
		radiobuttons[4] = new JRadioButton(STRUCTURE4);

		//ButtonGroup
		ButtonGroup bG = new ButtonGroup();
		radiobuttons[0].setSelected(true);
		for (JRadioButton b: radiobuttons){
			bG.add(b);
			structPanel.add(b);
		}

		//resultButton
		resultButton = new JButton(OPTION2);
		GridBagConstraints gbc_3 = new GridBagConstraints();
		gbc_3.fill = GridBagConstraints.BOTH;
		gbc_3.insets = new Insets(0, 0, 0, 5);
		gbc_3.gridx = 2;
		gbc_3.gridy = 0;
		resultButton.setActionCommand(OPTION2);
		getContentPane().add(resultButton);

		exitButton = new JButton(OPTION3);
		GridBagConstraints gbc_4 = new GridBagConstraints();
		gbc_4.fill = GridBagConstraints.BOTH;
		gbc_4.gridx = 3;
		gbc_4.gridy = 0;
		exitButton.setActionCommand(OPTION3);
		getContentPane().add(exitButton);
		changeEnabled(false);
	}

	public void registerController(Manager controlador) {
		controlador.registerController(filechooserButton);
		controlador.registerController(calculateButton);
		controlador.registerController(resultButton);
		controlador.registerController(exitButton);
	}

	public void initWindow(String title){
		setResizable(false);
		setTitle(title);
		setVisible(true);
		setSize(new Dimension(240, 400));
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
	}
	
	public File openFC(){
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) return fc.getSelectedFile();
		else showDialog("Open command cancelled by user"); 
		return null;
	}
	
	public void changeEnabled(Boolean b){
		calculateButton.setEnabled(b);
		resultButton.setEnabled(b);
		System.err.println("Buttons "+ b);
	}
	
	public void showDialog (String msg){
		JOptionPane.showMessageDialog(this, msg);
	}

	public String getStructureOptionSelected(){
		for( JRadioButton jrb: radiobuttons){
			if(jrb.isSelected()){
				switch (jrb.getText()){
				case STRUCTURE0:	return STRUCTURE0;
				case STRUCTURE1:	return STRUCTURE1;
				case STRUCTURE2:	return STRUCTURE2;
				case STRUCTURE3:	return STRUCTURE3;
				case STRUCTURE4:	return STRUCTURE4;
				}	
			}
		}return "error";
	}
}