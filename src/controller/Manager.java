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

	@SuppressWarnings("unused")
	private final String hash1 = "RSHash";
	private final String hash2 = "JSHash";
	@SuppressWarnings("unused")
	private final String hash3 = "PJWHash";
	@SuppressWarnings("unused")
	private final String hash4 = "ELFHash";
	@SuppressWarnings("unused")
	private final String hash5 = "PJWHash";
	@SuppressWarnings("unused")
	private final String hash6 = "BKDRHash";
	@SuppressWarnings("unused")
	private final String hash7 = "SDBMHash";
	@SuppressWarnings("unused")
	private final String hash8 = "DJBHash";
	@SuppressWarnings("unused")
	private final String hash9 = "DEKHash";
	@SuppressWarnings("unused")
	private final String hash10 = "BPHash";
	@SuppressWarnings("unused")
	private final String hash11 = "FNVHash";
	@SuppressWarnings("unused")
	private final String hash12 = "APHash";
	@SuppressWarnings("unused")
	private final String hash13 = "MurMurhash32";
	@SuppressWarnings("unused")
	private final String hash14 = "MurMurhash64";
	@SuppressWarnings("unused")
	private final String hash15 = "asci";
	@SuppressWarnings("unused")
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
			model.countWithHashTableplusTree(hash16);
			break;
		}
		tiempo = model.getTiempo();
		view.showDialog("Finalize in " + tiempo.getDurationBreakdown(tiempo.gettempsExecucio()) + "\nRAM usage" + humanReadableByteCount(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(), false));
	}

	public void registerController(JButton button) {
		button.addActionListener(bc);
	}

	public void showmessage(String string) {
		System.out.println(string);
	}

	public void showResult() {
		if(model == null)System.out.println("KASJDKAJSDKAS");
		gf.createHTML(model, book.getName().split(".txt")[0]);
	}
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
}
