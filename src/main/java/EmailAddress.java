import java.util.*;

/** The EmailAddress class represents an email address. Here only a
  very limited variant is used that allows an address to be defined
  and verified. A typical usage example is:
  EmailAddress ea = new EmailAddress("abejita@company.com");
  boolean isProper = ea.isValid();

  Please note that the implementation of isValid is on purpose WRONG!

*/
public class EmailAddress {
  private String address;
  public EmailAddress(String address) {
    this.address = address;
  }
  /**
   * Verify that a string is an email address.
   * The string must obey the following (somewhat strict format)
   * <email>      ::= <identifier> @ <identifier> {. <identifier>}
   * <identifier> ::= letter { letter | digit }
   * 
   * Example: abc@somewhere12.mail.com is correct whereas the
   * following are incorrect: 
   *
   * 13a@s.m.com (identifier starting with digit)
   * a-c@s.m.com (non letter in identifier)
   * a.b.c (missing @)
   * abc@ (missing identifier after @)
   * @return true if the address obeys this format.
  */

  private int countNumberCharacter(char myChar){
    int number = 0;
    for (int i = 0; i <address.length() ; i++) {
      if(address.charAt(i) == myChar){
        number++;
      }
    }
    return  number;
  }

  private boolean verificandoOnlyLetter(){
    boolean response = true;
    int len = address.indexOf('@');
    for (int i = 0; i <len ; i++) {
      if(address.charAt(i)<10||35<address.charAt(i)){
        response = false;
      }
    }

    return response;
  }

  public boolean isValid() {
    // This implementation is wrong and could be expressed more
    // elegantly using regular expressions.
    if ( address == null ) return false;
    if ( address.length() == 0 ) return false;
    int atPosition = address.indexOf( '@' );
    if ( atPosition == -1 ) return false;
    char firstChar = address.charAt(0);
    int positionInASCiI = Character.getNumericValue(Character.toUpperCase(firstChar));

    //------------
    if(positionInASCiI<10&&35<positionInASCiI){ //
      return false;
    }

    int numberRepeatedDotAfterAt = countNumberCharacter('.');

    if(numberRepeatedDotAfterAt>1){
      return false;
    }

    //-----------------------
    if(!verificandoOnlyLetter()){
      return false;
    }

    if(address.indexOf('@') == address.length()-1){
      return false;
    }

      if(countNumberCharacter('@')>1){
        return false;
      }

    int dotPosition = address.indexOf('.');
    if ( dotPosition < atPosition ) return false;
    return true;
  }
}
