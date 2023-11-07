import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaxCounterTest {

	@Test
	void testParseValues() {
		int [] values = {3,5,2,0,5,5,5,-1};
		assertArrayEquals(values,MaxCounter.parseValues("3  5 2 0 5 5 5 -1"));
	}

	void testParseValues2() {
		int [] values = {3,4,5,5,2,-4,6,4,5,5};
		assertArrayEquals(values,MaxCounter.parseValues("  3 4 5 5 2 -4 6 4 5 5"));
	}
	
	void testMaxCounter() {
		int [] result = {5,4};
		assertArrayEquals(result,MaxCounter.maxCounter(MaxCounter.parseValues("3 5 2 0 5 5 5")));
	}
	
	void testMaxCounter2() {
		int [] result = {6,1};
		assertArrayEquals(result,MaxCounter.maxCounter(MaxCounter.parseValues("3 4 5 5 2 -4 6 4 5")));
	}
}
