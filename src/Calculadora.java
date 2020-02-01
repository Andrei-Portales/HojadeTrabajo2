
public class Calculadora {

	private String path;
	private String expresion;
	
	
	
	
	public Calculadora() {
		path = null;
		expresion = null;
	}
	
	
	
	public void getPath() {
		path = ArchivoTXT.getPath();
		if (path != null) {
			expresion = ArchivoTXT.leerTXT(path);
		}
	}
	
	public String getResult() {
		String retorno = "";
		
		if (expresion != null) {
			retorno = expresion;
		}else {
			retorno = "No hay ninguna expresion";
		}
		
		return retorno;
	}
	
	
	public String suma(String operador,int d1,int d2) {
		return "";
	}
}
