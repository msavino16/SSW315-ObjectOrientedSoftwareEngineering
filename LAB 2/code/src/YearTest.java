import org.junit.jupiter.api.Test; 
import static org.junit.Assert.assertFalse; 
import static org.junit.Assert.assertTrue; 
 
/** Tests for the Year class. 
 */ 
public class YearTest { 
 
    @Test 
    public void testLeap() { 
        String msg = "should be leap year"; 
        assertTrue(msg, Year.isLeapYear(2000));
        assertTrue(msg, Year.isLeapYear(2004));
    } 
 
    @Test 
    public void testNotLeap() { 
        String msg = "should not be leap year"; 
        assertFalse(msg, Year.isLeapYear(1999)); 
        assertFalse(msg, Year.isLeapYear(2001)); 
        assertFalse(msg, Year.isLeapYear(2002)); 
        assertFalse(msg, Year.isLeapYear(2010)); 
        assertFalse(msg, Year.isLeapYear(2100)); 
    } 
 
} 