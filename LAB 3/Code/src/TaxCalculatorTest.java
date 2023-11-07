import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaxCalculatorTest {

	@Test
	void test() {
		assertEquals(TaxCalculator.incomePrompt(),600000);
		assertEquals(TaxCalculator.singleFiler(600000),184955);
		assertEquals(TaxCalculator.marriedJoint(600000),157506);
		assertEquals(TaxCalculator.marriedSeperate(600000),189274.50);
		assertEquals(TaxCalculator.Head(600000),183455.50);
	}

}
