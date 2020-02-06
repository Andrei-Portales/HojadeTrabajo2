import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebasJUNIT {

	@Test
	public void TestSum() {
		String e = "2 3 +"; //el resultado de la expresi�n es 5
		
		//ejecuta la calculadora
		ICalculator c = new Calculator();
		c.fillStack(e);
		c.doOperation();
		
		//se comprueba el resultado
		
		assertEquals(c.getResult(),"5.0");
	}
	
	@Test
	public void TestRes() {
		String e = "7 3 -"; //el resultado de la expresi�n es 4
		
		//ejecuta la calculadora
		ICalculator c = new Calculator();
		c.fillStack(e);
		c.doOperation();
		
		//se comprueba el resultado
		
		assertEquals(c.getResult(),"4.0");
	}
	
	@Test
	public void TestMul() {
		String e = "4 3 *"; //el resultado de la expresi�n es 12
		
		//ejecuta la calculadora
		ICalculator c = new Calculator();
		c.fillStack(e);
		c.doOperation();
		
		//se comprueba el resultado
		
		assertEquals(c.getResult(),"12.0");
	}
	
	@Test
	public void TestDiv() {
		String e = "9 3 /"; //el resultado de la expresi�n es 3
		
		//ejecuta la calculadora
		ICalculator c = new Calculator();
		c.fillStack(e);
		c.doOperation();
		
		//se comprueba el resultado
		
		assertEquals(c.getResult(),"3.0");
	}

}
