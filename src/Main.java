import javax.swing.SwingUtilities;

import controller.Manager;
import model.WordManager;
import view.MainWindow;

public class Main {
	public static void main(String[] args) {
		final String title = "Wordcount";
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// crea la vista
				MainWindow vista = new MainWindow(title);
				// creem el model
				WordManager model = new WordManager();
				// crea el controlador i estableix la relacio C->V i C->M
				Manager controlador = new Manager(vista, model);
				// establim la relacio V--->C
				vista.registerController(controlador);
				// fem la vista visible
				vista.setVisible(true);				
			}		});
		
	}
	
}
