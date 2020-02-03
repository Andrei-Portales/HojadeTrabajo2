public class Calculator implements ICalculator {
	
	//protected int result;
	protected String[] entrada;
	
	IStack<String> data_result = new StackVector<String>();
	
	
	public Calculator () {
	}
	
	@Override
	public void fillStack(String text) {
		entrada = text.split(" ");
	}

	@Override
	public void doOperation() {
		
		for (int i = 0; i < entrada.length; i++ )
		{
			if (isOperator(entrada[i])){
				
				int r = 0, n1= 0, n2 = 0; 
				n1 = Integer.parseInt(data_result.pop());
				n2 = Integer.parseInt(data_result.pop());
				r = operation(entrada[i], n1, n2);
				data_result.push(Integer.toString(r));
				
			}else 
			{
				data_result.push(entrada[i]);
			}
		}		
	
	}

	@Override
	public int getResult() {
		//print_vector(data_result);
		int result = 0;
		if (data_result.size() == 1) {
			result = Integer.parseInt(data_result.pop());
		} 
			
		return result;
	}
	
	private boolean isOperator(String op) {
		if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") ) 
			return true;
		else 
			return false;
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
		
		if (operator.equals("+")) {
			result = n1 + n2;
		}
		
		if (operator.equals("-")) {
			result = n2 - n1;
		}
		
		if (operator.equals("*")) {
			result = n1 * n2;
		}
		
		if (operator.equals("/")) {
			result = n1 * n2;
		}
		
		return result;
	}
}
