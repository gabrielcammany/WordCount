package tools;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import model.Word;

/**
 * Classe que s'ocupa de getionar els recursos que tenim al local
 */

public class GestorFitxers {
	public static int MAX_HTML;
	public static String PREFIX = "WC_Output_";
	public static String SUBFIX = ".html";
	public static String SUBFIX2 = ".html";
	private FileWriter writer = null;
	private File reader = null;
	
	/**
	 * Constructor de la classe,
	 * com  que no hem d'inicialitzar cap atribut,
	 * no implementem re
	 */
	public GestorFitxers(){}
			
	/**
	 *Funció que crear un HTML a traves del String que passa
	 */
	public void crearHTML(String nom, String html){
		try {
			writer = new FileWriter(PREFIX+nom+SUBFIX);
			writer.write(html);
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
	/**
	 * Funció encarregada de obrir un arxiu HTML amb el navegador per defecte
	 *  
	 * @param nom del fitxer (Ruta Complerta)
	 */
	public void llegirHTML(String nom){
			try {
				reader =  new File(PREFIX+nom+SUBFIX);;
				Desktop.getDesktop().open(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Funció que fragmenta el fitxer de text
	 * @param file
	 * @return
	 */
	public List<String> obtainWords(File file){
		Scanner scanner = null;
		try {
      	  scanner = new Scanner(file);
      	  String text = scanner.useDelimiter("\\A").next();
      	  return Arrays.asList(text.toLowerCase().replaceAll("[^a-z\\s+]", "").replaceAll("\\s+", " ").trim().split(" "));
        } catch (IOException e) {
			e.printStackTrace();
		}finally{
			 scanner.close(); 
		}
		return null;
	}
	public void createHTML(List<Word> words, Time tiempo, int wordNumber, String extra, String filename){
		Time timeofOrder = new Time();
		FitxerHTML html = new FitxerHTML();
		html.agregarBody();
		html.agregarHead("Analysis of " + filename);
		html.agregarText("Number of words: " + String.valueOf(wordNumber));
		System.out.println("Number of words: " + words.size());
		html.agregarText("Number of Unique Words: " + words.size());
		if (extra!=null) html.agregarText(extra);
		html.agregarText("Time: " + tiempo.getDurationBreakdown(tiempo.gettempsExecucio()));
		Collections.sort(words);
		timeofOrder.setTemps_final();
		html.agregarText("Order Time: " + timeofOrder.getDurationBreakdown(timeofOrder.gettempsExecucio()));
		html.agregarTaula();
		MAX_HTML = words.size();
		//MAX_HTML = 100;
		for (int i = 0; i<MAX_HTML; i++){
			html.agregarCampTaula( words.get(i).toList());
		}
		html.tancarTaula();
		crearHTML(tiempo.humanData(tiempo.getTemps_inici()), html.getHtml());
		llegirHTML(tiempo.humanData(tiempo.getTemps_inici()));	
	}
	
	/**
	 * Crea un CSV
	 * @param nom
	 */
	public void crearCSV(String nom){
		try {
			
			writer = new FileWriter(nom);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	/**
	 * Agreguem fila
	 * @param nom
	 */
	public void addRows(String nom){
		try {
			writer.write(nom);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Tanquem
	 * @param nom
	 */
	public void closeCSV(String nom){
		try {
			writer.write(nom);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

	
}
