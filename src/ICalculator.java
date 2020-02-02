public interface ICalculator {
	
	public void fillStack(String[] text, IStack<String> expresion);
	
	public void doOperation(); 
	
	public void getResult(IStack<String> expresion);
	
	
}