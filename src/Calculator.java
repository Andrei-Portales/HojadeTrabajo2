
public class Calculator implements ICalculator {
	
	public Calculator () {
	}
	
	@Override
	public void fillStack(String[] text, IStack<String> expresion) {
		
		for (int i = 0; i <text.length; i++ )
		 {
			 expresion.push(text[i]);
		 }
	}

	@Override
	public void doOperation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getResult(IStack<String> expresion) {
		// TODO Auto-generated method stub

	}

}
