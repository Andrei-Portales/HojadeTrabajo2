public class Calculator implements ICalculator {
	//variable para almacenar la expresi�n de entrada
	protected String[] entrada;
	//se crea la pila
	IStack<String> data_result = new StackVector<String>();
	
	
	public Calculator () {
	}
	
	@Override
	public void fillStack(String text) {
		//prepara la expresi�n para ser analizada
		entrada = text.split(" ");
	}

	@Override
	public void doOperation() {
		//recorre toda la expresi�n
		for (int i = 0; i < entrada.length; i++ )
		{
			//�es operador o numero?
			if (isOperator(entrada[i])){
				//si es operador se retiran dos elementos de la pila y se operan
				int r = 0, n1= 0, n2 = 0; 
				n1 = Integer.parseInt(data_result.pop());
				n2 = Integer.parseInt(data_result.pop());
				r = operation(entrada[i], n1, n2);
				//se ingresa el resultado de la operaci�n en la pila
				data_result.push(Integer.toString(r));
				
			}else 
			{
				//si es un numero se ingresa a la pila
				data_result.push(entrada[i]);
			}
		}		
	
	}

	@Override
	public int getResult() {
		//print_vector(data_result);
		int result = 0;
		
		//se retorna el ultimo elemento que qued� en la pila que es el resultado
		//si hay mas elementos se retorna 0 porque no se pudo operar.
		if (data_result.size() == 1) {
			result = Integer.parseInt(data_result.pop());
		} 
			
		return result;
	}
	
	private boolean isOperator(String op) {
		//se comprueba si es un operador
		if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") ) 
			return true;
		else 
			return false;
	}
	
	private boolean isNumeric(String op) {
		//se comprueba si es un numero
		boolean numeric = false;
		try {
			Double num = Double.parseDouble(op);
			numeric = true;
        } catch (NumberFormatException e) {
            numeric = false;
        }
		return numeric;
	}
	
	
	
	/*private void print_vector(IStack<String> expresion) {
		int z;
		z = expresion.size();
		System.out.println("z " + z);
		for (int i = 0; i < z ; i++ )
		{
			String algo = expresion.pop();
			System.out.println(algo);
		}
	}*/
	
	private int operation(String operator, int n1, int n2) {
		
		int result = 0;
		
		//suma
		if (operator.equals("+")) {
			result = n1 + n2;
		}
		
		//resta
		if (operator.equals("-")) {
			result = n2 - n1;
		}
		
		//multiplicaci�n
		if (operator.equals("*")) {
			result = n1 * n2;
		}
		
		//divisi�n
		if (operator.equals("/")) {
			result = n2 / n1;
		}
		
		return result;
	}
}
