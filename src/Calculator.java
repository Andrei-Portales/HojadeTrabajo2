
public class Calculator implements ICalculator {
	
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
	public void doOperation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getResult(IStack<String> expresion) {
		// TODO Auto-generated method stub

	}

}
