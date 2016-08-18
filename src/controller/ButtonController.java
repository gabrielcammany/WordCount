package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainWindow;

/**
 * Funció encarregada dels buttons de la interficie grafica
 * @author Jordi
 *
 */
public class ButtonController implements ActionListener {
	// relacio amb el controlador
	private Manager manager;

	public ButtonController(Manager manager) {
		this.manager = manager;
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
		case MainWindow.OPTION0:
			System.err.println(MainWindow.OPTION0);
			manager.openFC();
			break;
		case MainWindow.OPTION1:
			System.err.println(MainWindow.OPTION1);
			manager.calculate();
			break;
		case MainWindow.OPTION2:
			System.err.println(MainWindow.OPTION2);
			manager.showResult();
			break;
		case MainWindow.OPTION3:
			System.err.println(MainWindow.OPTION3);
			System.exit(0);
			break;
		}
	}
}
