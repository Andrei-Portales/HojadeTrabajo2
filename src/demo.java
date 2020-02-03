
public class demo {

	public static void main(String[] args) {
		//Se crea una pila
		IStack<String> expresion = new StackVector<String>();
		//Se crea una calculadora
		ICalculator calculadora = new Calculator();
		//cadena del archivo de texto
		String cadena = "1 2 + 4 * 3 +";
		//String cadena = "6 2 3 + *";
		
		//llena la pila
		calculadora.fillStack(cadena, expresion);
		
		//hace la operacion
		calculadora.doOperation(expresion);
		
		//obtiene e imprime le resultado
		System.out.println(calculadora.getResult());
	}

}
