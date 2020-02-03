public interface ICalculator {
	
	public void fillStack(String text, IStack<String> expresion);
	
	public void doOperation(IStack<String> expresion); 
	
	public int getResult();
		
}
