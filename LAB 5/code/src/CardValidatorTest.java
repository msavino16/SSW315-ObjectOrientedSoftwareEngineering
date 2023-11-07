import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardValidatorTest {

	@Test
	void VisaTest() {
		assertTrue(CardValidation.isValid(4388576018410707L));
		assertFalse(CardValidation.isValid(4388576018410717L));
	}
	
	@Test
	void MastercardTest() {
		assertTrue(CardValidation.isValid(5136387743909100L));
		assertFalse(CardValidation.isValid(5136387743909101L));
	}
	
	@Test
	void AmexTest() {
		assertTrue(CardValidation.isValid(371847285702275L));
		assertFalse(CardValidation.isValid(371847285701275L));
	}
	
	@Test
	void DiscoverTest() {
		assertTrue(CardValidation.isValid(6538823998821436L));
		assertFalse(CardValidation.isValid(622126456495012944L));
	}

}
