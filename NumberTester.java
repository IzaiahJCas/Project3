/**
 * JUnit
 * @author Izaiah Caston
 */
import org.junit.*;
import static org.junit.Assert.*;
public class NumberTester{
  
  @Test
  public void testNumber(){
    Number x = new Number(5.0);
    Number x2 = new Number(10.0);
    //checks that Number instance is correct
    assertEquals("5.0", x.toString());
    //checks that Number instance is correct
    assertEquals("10.0", x2.toString());
  }
  
  @Test
  public void testGetNumber(){
    Number x = new Number(5.0);
    Number x2 = new Number(10.0);
    //shows that getNumber returns correctly
    assertEquals(5.0, x.getNumber(),0.001);
    //shows that getNumber returns correctly
    assertEquals(10.0, x2.getNumber(),0.001);
  }
  
  @Test
  public void testSetNumber(){ 
    Number x = new Number(15.0);
    //shows that Number intialized correctly
    assertEquals(15.0, x.getNumber(), 0.001);
    x.setNumber(5.0);
    //shows that setNumber changes value
    assertEquals(5.0, x.getNumber(), 0.001);
  }
  
  @Test
  public void testToString(){
    Number x = new Number(5.0);
    Number x2 = new Number(10.0);
    //Checks that converts to string
    assertEquals("5.0", x.toString());
    //Checks that converts to string
    assertEquals("10.0", x2.toString());
  }
  
  @Test
  public void testEquals(){
    Number x = new Number(5.0);
    Number x2 = new Number(10.0);
    Number x3 = new Number(10.0);
    //Compares x2 to x3
    assertTrue(x2.equals(x3));
    //Compares x2 to x3
    assertFalse(x.equals(x2));
    //Compares x2 to x3
    assertFalse(x.equals(x3));
  }
  
  @Test
  public void testValue(){ 
    Number x = new Number(5.0);
    Number x2 = new Number(10.0);
    //Shows that value doesn't change anything
    assertEquals(5.0, x.value(10.0), 0.001);
    //Shows that value doesn't change anything
    assertEquals(10.0, x2.value(15.0), 0.001);
    //Tests without parameter for value
    assertEquals(10.0, x2.value(), 0.001);
  }
  
  @Test
  public void testDerivative(){
    Number x = new Number(5.0);
    Number x2 = new Number(10.0);
    Number d = new Number(0.0);
    //Shows that derivative is computed
    assertEquals(d.toString(), x.derivative().toString());
    //Shows that derivative is computed
    assertEquals(d.toString(), x2.derivative().toString());
  }
}