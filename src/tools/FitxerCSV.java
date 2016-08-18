package tools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/**
 * Clase que s'ocupa de gestionar les entrades d'un fitxer CSV
 * @author Jordi
 *
 */
public class FitxerCSV {
	private StringBuilder sb;

	public FitxerCSV() {
		sb = new StringBuilder();
	}
	public void addColumnNamesList (String[] info){
		//lenght=info.length;
		for (String s : info){
			sb.append(s+";");
		}   
		nextLine();

	}
	public void addRow(String[] info){
	//	if (lenght<info.length && lenght==0) return;
		for (String s : info){
			sb.append(s+";");
		}   
		nextLine();
	}

	private void nextLine(){
		sb.append('\n');
	}
	public void crearCSV(String nom){
		Writer writer = null;
		try {
			writer = new FileWriter(nom.split(".txt")[0]+".csv");
			writer.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
