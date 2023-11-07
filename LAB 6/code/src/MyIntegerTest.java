import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyIntegerTest {
	
	@Test
	void ConstructortTests()
	{
		char[] t = {'5','0'};
		MyInteger test1 = new MyInteger();
		MyInteger test2 = new MyInteger(10);
		MyInteger test3 = new MyInteger("20");
		MyInteger test4 = new MyInteger(t);
		
		assertEquals(0,test1.getValue());
		assertEquals(10,test2.getValue());
		assertEquals(20,test3.getValue());
		assertEquals(50,test4.getValue());
	}
	
	void GetAndSetTests()
	{
		char[] t = {'5','0'};
		MyInteger test = new MyInteger();
		assertEquals(0,test.getValue());
		
		test.setValue(5);
		assertEquals(5,test.getValue());

		test.setValue("5");
		assertEquals(5,test.getValue());

		test.setValue(t);
		assertEquals(50,test.getValue());
	}

	void isMethodsTests()
	{
		MyInteger test1 = new MyInteger(16);
		MyInteger test2 = new MyInteger(7);
		
		assertTrue(test1.isEven());
		assertTrue(MyInteger.isEven(6));
		assertTrue(MyInteger.isEven(test1));
		
		assertFalse(test2.isEven());
		assertFalse(MyInteger.isEven(9));
		assertFalse(MyInteger.isEven(test2));
		
		assertTrue(test2.isOdd());
		assertTrue(MyInteger.isOdd(9));
		assertTrue(MyInteger.isOdd(test2));
		
		assertFalse(test1.isOdd());
		assertFalse(MyInteger.isOdd(2));
		assertFalse(MyInteger.isOdd(test1));
		
		assertTrue(test2.isPrime());
		assertTrue(MyInteger.isPrime(3));
		assertTrue(MyInteger.isPrime(test2));
		
		assertFalse(test1.isPrime());
		assertFalse(MyInteger.isPrime(2));
		assertFalse(MyInteger.isPrime(test1));
	}
	
	void EqualsTest()
	{
		MyInteger test1 = new MyInteger(16);
		MyInteger test2 = new MyInteger(16);
		MyInteger test3 = new MyInteger(12);
		
		assertTrue(test1.equals(16));
		assertTrue(test1.equals(test2));
		
		assertFalse(test1.equals(12));
		assertFalse(test1.equals(test3));
	}
	
	void parseTest()
	{
		char[] t = {'5','0'};
		
		assertEquals(50,MyInteger.parseInt(t));
		assertEquals(50,MyInteger.parseInt("50"));
		
	}
}
