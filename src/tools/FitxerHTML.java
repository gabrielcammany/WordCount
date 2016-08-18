package tools;
import java.util.List;

/**
 * Funcio encarregada de gestionar de manera mes sencilla la creacio del contingut de un HTML
 * <br> implementacio simple
 */
public class FitxerHTML {

	/**
	 * Contingut del fitxer
	 */
	private String html;
	/**
	 * ens permet detectar si el fitxer te la etiqueta cos oberta
	 */
	private boolean body;
	/**
	 * Constructor de la classe
	 */
	public FitxerHTML() {
		this.html = "<!DOCTYPE html><html>";
		body=false;
	}
	/**
	 * Ens permet agregar un titol al fitxer
	 * @param Contingut del titol
	 */
	public void agregarTitol(String s){
		this.html = this.html + "<title>" + s + "</title>";
	}
	/**
	 * Ens permet agregar un encapçalament al fitxer
	 * @param Contingut del encapçalament
	 */
	public void agregarHead(String s){
		this.html = this.html + "<h1>" + s + "</h1>";
	}
	/**
	 * Ens permet agregar una imatge al fitxer
	 * @param text a introduir
	 */
	public void agregarText(String s){
		this.html = this.html + "<p>" + s + "</p>";
	}
	/**
	 * Ens permet agregar un paraf al fitxer
	 * @param imatge a introduir url
	 */
	public void agregarImagen(String s){
		this.html = this.html + "<img src=\"" + s + "\">";
	}
	/**
	 * Agrega el comenzament de una taula
	 */
	public void agregarTaula(){
		this.html = this.html + "<table>";
	}
	/**
	 * Tanca la taula previament oberta
	 */
	public void tancarTaula(){
		this.html = this.html + "</table>";
	}
	/**
	 * Un cop tenim una taula creada, ens serveix per inserir camps a la mateixa
	 * 
	 * @param color de la row
	 * @param llista List amb les dades a introduir
	 */
	public void agregarCampTaula(String color, List<String> llista){
		this.html = this.html + "<tr bgcolor=\""+color+ "\">";
		for(int i = 0; i< llista.size() ; i++){
			this.html = this.html  + "<td>" + llista.get(i) +"</td>";
		}
		this.html = this.html + "</tr>";
	}
	
	public void agregarCampTaula(List<String> llista){
		this.html = this.html + "<tr>";
		for(int i = 0; i< llista.size() ; i++){
			this.html = this.html  + "<td>" + llista.get(i) +"</td>";
		}
		this.html = this.html + "</tr>";
	}
	
	/**
	 * Agregar el cos al fitxer
	 */
	public void agregarBody(){
		this.html = this.html + "<body>";
		body=true;
	}
	/**
	 * Tanca el fitxer i el retorna
	 * @return contingut fitxer html
	 */
	public String getHtml() {
		if (body) return html+"</body></html>";
		else return html+"</html>";
	}
	
	public void setHtml(String html) {
		this.html = html;
	}
	public void addHtml(String html) {
		this.html = this.html + html;
	}
	
	
	
}
