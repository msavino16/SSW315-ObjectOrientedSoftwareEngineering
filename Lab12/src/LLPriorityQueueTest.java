import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LLPriorityQueueTest {
	
	LLPriorityQueue<Integer> L = new LLPriorityQueue<Integer>();

	@Test
	void testEnque()
	{
		L.enque(5);
		
		assertEquals(5,L.deque());

		L.enque(2);

		assertEquals(2,L.deque());
	}
	
	
	@Test
	void testDeque()
	{
		L.enque(5);
		L.enque(3);
		L.enque(7);
		L.enque(1);
		
		assertEquals(7,L.deque());
		assertEquals(5,L.deque());
		assertEquals(3,L.deque());
		L.deque();
		
		L.enque(5);
		L.enque(3);
		L.enque(7);
		L.enque(1);
		
		assertNotEquals(5,L.deque());
	}
	
	@Test
	void testSize()
	{
		L.enque(5);
		L.enque(3);
		L.enque(7);
		L.enque(1);
		
		assertEquals(4,L.getSize());

	}
}
