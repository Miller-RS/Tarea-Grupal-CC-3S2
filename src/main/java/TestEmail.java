
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Test case class for testing emails address verification.


*/
public class TestEmail {

  private EmailAddress address;

  @Test
  public void replaceMe() {
    assertTrue(true);
  }

  @Test
  public void shouldAcceptJohnAtCsDotEdu() {
    EmailAddress ea = new EmailAddress("abejita@cs.edu");
    assertTrue(ea.isValid());
  }

  @Test
  public void shouldNotAccept123AtCsDotEdu() {
    EmailAddress ea = new EmailAddress("123@cs.edu");
    assertFalse(ea.isValid());
  }

  @Test
  public void shouldNotAcceptTwoDotsAfterAt(){
    EmailAddress ea = new EmailAddress("a13a@s.m.com");
    assertFalse(ea.isValid());
  }
  /*

   * a.b.c (missing @)
   * abc@ (missing identifier after @)
   */
@Test
  public void shouldNotAcceptNoLetterBeforeAt(){
  EmailAddress ea = new EmailAddress("a-c@s.m.com");
  assertFalse(ea.isValid());
}

@Test
  public void shouldNotAcceptWithoutAt(){
  EmailAddress ea = new EmailAddress("a.b.c");
  assertFalse(ea.isValid());
}

@Test
  public void shouldNotAcceptOneFinallyPositionWithAt(){
  EmailAddress ea = new EmailAddress("abc@");
  assertFalse(ea.isValid());
  }

  @Test
  public void shouldNotAcceptMoreThanAnAt(){
    EmailAddress ea = new EmailAddress("abc@darwin@cc.com");
    assertFalse(ea.isValid());
  }
}