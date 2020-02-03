public class Calculator implements ICalculator {
	
	protected int result;
	IStack<String> exp_tmp = new StackVector<String>();
	IStack<String> data_result = new StackVector<String>();
	
	public Calculator () {
	}
	
	@Override
	public void fillStack(String text, IStack<String> expresion) {
		String[] ts; 
		ts = text.split(" ");
		for (int i = 0; i < ts.length; i++ )
		 {
			exp_tmp.push(ts[i]);
		 }
		
		int c = exp_tmp.size();
		for (int j = 0; j < c; j++) 
		{
			expresion.push(exp_tmp.pop());
		}
	}

	@Override
	public void doOperation(IStack<String> expresion) {
		
		int size = 0;
		size = expresion.size(); 
		
		do {
			calculator(expresion);
			
			clean_stack(expresion);
			
			clean_stack(exp_tmp);
			
			//se copia y ordena
			if(!data_result.empty()) {
				int c = data_result.size();
				for (int j = 0; j < c; j++) 
				{
					expresion.push(data_result.pop());
				}
			}
			
			//System.out.println("expresion ->");
			//print_vector(expresion);
			
			clean_stack(data_result);
			
			size = expresion.size();
			
		} while (size > 1);
			
		result = Integer.parseInt(expresion.pop()) ;
	}

	@Override
	public int getResult() {
		return result;
	}
	
	private void clean_stack(IStack<String> expresion) {
		if(!expresion.empty()) {
			for (int i = 0; i < expresion.size() -1 ; i++ )
			{
				expresion.pop();
			}
		}
	}
	
	private void calculator(IStack<String> expresion) {
		String current ="";
		int count = 0;
		boolean continua = true;
		
		while (expresion.size() > 0) {
			current = expresion.pop();
			
			if (continua == true) {
				switch (current) {
				case "+":
					operation("suma",count);
					count = 0;
					continua = false;
					break;
				case "-":
					operation("resta",count);
					count = 0;
					continua = false;
					break;
				case "*":
					operation("multiplica",count);
					count = 0;
					continua = false;
					break;
				case "/":
					operation("divide",count);
					count = 0;
					continua = false;
					break;
				default: 
					count ++;
					data_result.push(current);
					break;
				}
			} else {
				data_result.push(current);
			}
		}
	}
	
	private void print_vector(IStack<String> expresion) {
		int z;
		z = expresion.size();
		System.out.println("z " + z);
		for (int i = 0; i < z ; i++ )
		{
			String algo = expresion.pop();
			System.out.println(algo);
		}
	}
	
	private void operation(String operator, int x) {
		int operation = 0, n1 = 0, n2 = 0;
		
		if (operator == "suma") {
			n1 = Integer.parseInt(data_result.pop());
			n2 = Integer.parseInt(data_result.pop());
			operation = n1 + n2;
			
			data_result.push(Integer.toString(operation));

			if (x > 2) {
				data_result.push("+");
			}
		}
		
		if (operator == "resta") {
			n1 = Integer.parseInt(data_result.pop());
			n2 = Integer.parseInt(data_result.pop());
			operation = n2 - n1;
			
			data_result.push(Integer.toString(operation));
			
			if (x > 2) {
				data_result.push("-");
			}
		}
		
		if (operator == "multiplica") {
			n1 = Integer.parseInt(data_result.pop());
			n2 = Integer.parseInt(data_result.pop());
			operation = n1 * n2;
			
			data_result.push(Integer.toString(operation));
			
			if (x > 2) {
				data_result.push("*");
			}
		}
		
		if (operator == "divide") {
			n1 = Integer.parseInt(data_result.pop());
			n2 = Integer.parseInt(data_result.pop());
			operation = n1 * n2;
			
			data_result.push(Integer.toString(operation));
			
			if (x > 2) {
				data_result.push("*");
			}
		}
	
	}
}
