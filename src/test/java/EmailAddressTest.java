import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailAddressTest {

    private EmailAddress address;

    @Test
    public void replaceMe() {
        assertTrue(true);
    }

    @Test
    public void shouldAcceptJohnAtCsDotEdu() {
        EmailAddress ea = new EmailAddress("abejita@cs.edu");
        assertTrue( ea.isValid() );
    }
    @Test
    public void shouldNotAccept123AtCsDotEdu() {
        EmailAddress ea = new EmailAddress("123@cs.edu");
        assertFalse( ea.isValid() );
    }
}