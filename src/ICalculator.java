public interface ICalculator {
	
	public void fillStack(String text);
	// pre: 
    // post: se prepara el texto para ser analizado en la pila

	
	public void doOperation(); 
	// pre: se ingres� el texto de entrada
    // post: la pila tiene el resultado de la operaci�n
	
	public int getResult();
	// pre: se realiz� la operaci�n 
    // post: retorna el resultado 
    	
}
