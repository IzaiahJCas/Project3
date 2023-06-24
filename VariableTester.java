/**
 * JUnit
 * @author Izaiah Caston
 */
import org.junit.*;
import static org.junit.Assert.*;
public class VariableTester{
  
  @Test
  public void testToString() {
    Variable x = new Variable();
    //makes sure that Variable instance returns "x"
    assertEquals("x", x.toString());
  }
  
  @Test
  public void testEquals() {
    Variable x1 = new Variable();
    Variable x2 = new Variable();
    //Returns true for x1 and x2
    assertTrue(x1.equals(x2));
    //Returns false for x1 and "x"
    assertFalse(x1.equals("x"));
  }
  
  @Test
  public void testValue(){
    Variable x = new Variable();
    Variable x2 = new Variable();
    Variable x3 = new Variable();
    //Checks that variable value is changed to input
    assertEquals(5.0, x.value(5.0), 0.0001);
    //Checks that variable value is changed to input
    assertEquals(15.0, x.value(15.0), 0.0001);
    //Checks that variable value is changed to input
    assertEquals(10.0, x.value(10.0), 0.0001);
  }

  @Test
  public void testDerivative() {
    Variable x = new Variable();
    Number n = new Number(1.0);
    //Checks that variable derivative is correct
    assertEquals(n, x.derivative());
  }
  
  @Test(expected = UnsupportedOperationException.class)
  //tests exception thrown
    public void testUnsupportedOperationException() {
    Variable x = new Variable();
    x.value();
  }
}