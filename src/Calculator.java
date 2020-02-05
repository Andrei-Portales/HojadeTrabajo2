public class Calculator implements ICalculator {
	//variable para almacenar la expresión de entrada
	protected String[] entrada;
	//se crea la pila
	IStack<String> data_result = new StackVector<String>();
	
	
	public Calculator () {
	}
	
	@Override
	public void fillStack(String text) {
		//prepara la expresión para ser analizada
		entrada = text.split(" ");
	}

	@Override
	public void doOperation() {
		//recorre toda la expresión
		try {
			for (int i = 0; i < entrada.length; i++ )
			{
				//¿es operador o numero?
				if (isOperator(entrada[i])){
					//si es operador se retiran dos elementos de la pila y se operan
					double r = 0, n1= 0, n2 = 0; 
					n1 = Double.parseDouble(data_result.pop());
					n2 = Double.parseDouble(data_result.pop());
					r = operation(entrada[i], n1, n2);
					//se ingresa el resultado de la operación en la pila
					data_result.push(Double.toString(r));
					
				}else if (isNumeric(entrada[i])){
					//si es un numero se ingresa a la pila
					data_result.push(entrada[i]);
				} else 
				{ 	//se  limpia la pila
					while (!(data_result.size() == 0)) {
						data_result.pop();
		            } 
					return;
				}
			}
        } catch (NumberFormatException e) {
        	
            while (!(data_result.size() == 0)) {
            	data_result.pop();
            }
        }
				
	
	}

	@Override
	public String getResult() {
		//print_vector(data_result);
		String result = "";
		
		//se retorna el ultimo elemento que quedó en la pila que es el resultado
		//si hay mas elementos se retorna 0 porque no se pudo operar.
		if (data_result.size() == 1) {
			result = data_result.pop();
		}else 
		{
			result = "Error en la operación";
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
	
	private double operation(String operator, double n1, double n2) {
		
		double result = 0;
		
		//suma
		if (operator.equals("+")) {
			result = n1 + n2;
		}
		
		//resta
		if (operator.equals("-")) {
			result = n2 - n1;
		}
		
		//multiplicación
		if (operator.equals("*")) {
			result = n1 * n2;
		}
		
		//división
		if (operator.equals("/")) {
			result = n2 / n1;
		}
		
		return result;
	}
}
