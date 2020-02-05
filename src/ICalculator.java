public interface ICalculator {
	
	public void fillStack(String text);
	// pre: 
    // post: se prepara el texto para ser analizado en la pila

	
	public void doOperation(); 
	// pre: se ingresó el texto de entrada
    // post: la pila tiene el resultado de la operación
	
	public int getResult();
	// pre: se realizó la operación 
    // post: retorna el resultado 
    	
}
