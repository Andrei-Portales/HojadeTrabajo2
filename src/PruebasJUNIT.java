import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebasJUNIT {

	@Test
	public void TestSum() {
		ICalculadora c = new Calculadora();
		assertEquals(Integer.toString(c.sumar(3, 2)),"5");
	}
	
	@Test
	public void TestRes() {
		ICalculadora c = new Calculadora();
		assertEquals(Integer.toString(c.restar(3, 7)),"4");
	}
	
	@Test
	public void TestMul() {
		ICalculadora c = new Calculadora();
		assertEquals(Integer.toString(c.multiplicar(2, 4)),"8");
	}
	
	@Test
	public void TestDiv() {
		ICalculadora c = new Calculadora();
		assertEquals(Integer.toString(c.dividir(3,9)),"3");
	}

}
