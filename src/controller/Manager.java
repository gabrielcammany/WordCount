package controller;

import java.io.File;

import javax.swing.JButton;

import model.WordManager;
import tools.GestorFitxers;
import tools.Time;
import view.MainWindow;

/**
 * Manager que gestiona els controladors
 * @author Jordi
 *
 */

public class Manager {

	/**
	 * Tipus de funció hash que usarem
	 */
	private final String hash1 = "RSHash";
	private final String hash2 = "JSHash";
	private final String hash3 = "PJWHash";
	private final String hash4 = "ELFHash";
	private final String hash5 = "PJWHash";
	private final String hash6 = "BKDRHash";
	private final String hash7 = "SDBMHash";
	private final String hash8 = "DJBHash";
	private final String hash9 = "DEKHash";
	private final String hash10 = "BPHash";
	private final String hash11 = "FNVHash";
	private final String hash12 = "APHash";
	private final String hash13 = "MurMurhash32";
	private final String hash14 = "MurMurhash64";
	private final String hash15 = "asci";
	private final String hash16 = "basic";
	
	// gestor de controladors
	private ButtonController bc;
	// relacio amb la vista
	private MainWindow view;
	// relacio amb el model
	private WordManager model;
	private GestorFitxers gf;
	private Time tiempo;
	private File book;

	public Manager(MainWindow vista, WordManager model) {
		this.view = vista;
		this.model = model;
		bc = new ButtonController(this);
		gf = new GestorFitxers();
	}

	public void openFC() {
		book = view.openFC();
		if (book != null) {
			view.showDialog("Analyzing file....");
			view.changeEnabled(true);
			model.setWords(gf.obtainWords(book));
			view.showDialog("Numero de palabras encontradas: " + model.wordNumber());
		}
	}

	/**
	 * Calcula depenen de la estructuraclicada"
	 */
	public void calculate() {
		model.getList().clear();
		switch (view.getStructureOptionSelected()) {
		case MainWindow.STRUCTURE0:
			model.count();
			break;
		case MainWindow.STRUCTURE1:
			model.countWithBinaryTree();
			break;
		case MainWindow.STRUCTURE2:
			model.countWithAVLTree();
			break;
		case MainWindow.STRUCTURE3:
			model.countWithHashTable(hash2);
			break;
		case MainWindow.STRUCTURE4:
			model.countWithHashTableplusTree(hash2);
			break;
		}
		tiempo = model.getTiempo();
		view.showDialog("Finalize in " + tiempo.getDurationBreakdown(tiempo.gettempsExecucio()));
	}

	public void registerController(JButton button) {
		button.addActionListener(bc);
	}

	public void showmessage(String string) {
		System.out.println(string);
	}

	public void showResult() {
		gf.createHTML(model.getList(), tiempo, model.wordNumber(), model.getExtra(), book.getName().split(".txt")[0]);
	}
}
