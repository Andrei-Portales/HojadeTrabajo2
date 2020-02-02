
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
	
	
	
	
	public Integer operar(String operador,String[] datos) {
		int resultado = 0;
		
		switch (operador) {
		
		case "suma":
			for (String dato: datos) {
				int num = Integer.parseInt(dato);
				resultado = resultado + num;
			}
			break;
		case "resta":
			resultado = Integer.parseInt(datos[0]);
			for (int i = 1;i<=datos.length - 1;i++) {
				resultado = resultado - Integer.parseInt(datos[i]);
			}
			break;
		case "multiplicacion":
			resultado++;
			for (String dato:datos) {
				resultado = resultado * Integer.parseInt(dato);
			}
			break;
		case "division":
			resultado = Integer.parseInt(datos[0]);
			for (int i = 1;i<= datos.length - 1;i++) {
				resultado = resultado / Integer.parseInt(datos[i]);
			}
			break;
			
		}
		return resultado;
	}
	
	
	public void fillStacks() {
		
	}
	
	public void duOperation() {
		
	}
	
	public String getResult() {
		return "";
	}
	
	
	
	
	
}
