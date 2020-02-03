public class Calculator implements ICalculator {
	
	protected int result;
	
	public Calculator () {
	}
	
	@Override
	public void fillStack(String text, IStack<String> expresion) {
		String[] ts; 
		ts = text.split(" ");
		for (int i = 0; i <ts.length; i++ )
		 {
			 expresion.push(ts[i]);
		 }
	}

	@Override
	public void doOperation(IStack<String> expresion) {
		String current ="", operator=""; 
		
		while (!expresion.empty()) {
			current = expresion.pop();
			switch (current) {
			case "+":
				operator = "suma";
				break;
			case "-":
				operator = "resta";
				break;
			case "*":
				operator = "multiplica";
				break;
			case "/":
				operator = "divide";
				break;
			default: 
				result = operation(Integer.parseInt(current), result, operator);
				//expresion.pop();
				break;
			}
		}

	}

	@Override
	public int getResult() {
		// TODO Auto-generated method stub
		return result;
	}
	
	private int operation(int n, int result, String operator) {
		int operation = 0;
		//System.out.println(operator == "suma");	
		if (operator == "suma") {
			operation = result + n;
			//System.out.println(n + " + " + result);
		}
		
		if (operator == "resta") {
			operation = result - n;
			//System.out.println(n + " - " + result);
		}
		
		if (operator == "multiplica") {
			operation = result * n;
			//System.out.println(n + " * " + result);
		}
		
		if (operator == "divide") {
			operation = result / n;
			//System.out.println(n + " / " + result);
		}
	
		return operation;
	}
}
