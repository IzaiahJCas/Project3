/**
 * JUnit
 * @author Izaiah Caston
 */
import org.junit.*;
import static org.junit.Assert.*;
public class PolynomialTester{
  
  @Test
  public void testPolynomial(){
    Polynomial x = new Polynomial(new Variable(), 3.0);
    Polynomial x2 = new Polynomial(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)), 3.0);
    Polynomial x3 = new Polynomial(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)), 3.0);
    Polynomial x4 = new Polynomial(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)), 13.0);
    Polynomial x5 = new Polynomial(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)), 5.0);
    Polynomial x6 = new Polynomial(new Exp(new Number(5.0)), 6.0);
    Polynomial x7 = new Polynomial(new Log(new Number(10.0)), 9.0);
    Polynomial x8 = new Polynomial(new Sin(new Number(5.0)), 4.0);
    Polynomial x9 = new Polynomial(new Cos(new Number(15.0)), 2.0);
    Polynomial x10 = new Polynomial(new Polynomial(new Number(5.0), 5.0), 3.0);
    //Initialized without BinaryOp
    assertEquals("x^3.0", x.toString());
    //Initialized with BinaryOp PLUS
    assertEquals("(x + 5.0)^3.0", x2.toString());
    //Initialized with BinaryOp SUB
    assertEquals("(5.0 - 5.0)^3.0", x3.toString());
    //Initialized with BinaryOp MULT
    assertEquals("(5.0 * 5.0)^13.0", x4.toString());
    //Initialized with BinaryOp DIV
    assertEquals("(5.0 / 5.0)^5.0", x5.toString());
    //Initialized with Exp
    assertEquals("Exp[5.0]^6.0",  x6.toString());
    //Initialized with Log
    assertEquals("Log[10.0]^9.0", x7.toString());
    //Initialized with Sin
    assertEquals("Sin[5.0]^4.0", x8.toString());
    //Initialized with Cos
    assertEquals("Cos[15.0]^2.0", x9.toString());
    //Initialized with Polynomial
    assertEquals("5.0^5.0^3.0", x10.toString());   
  }
  
  @Test
  public void testGetPower(){
    Polynomial x = new Polynomial(new Variable(), 3.0);
    Polynomial x2 = new Polynomial(new Variable(), 5.0);
    Polynomial x10 = new Polynomial(new Polynomial(new Number(5.0), 5.0), 3.0);
    Polynomial x7 = new Polynomial(new Log(new Number(10.0)), 9.0);
    //Retruns power
    assertEquals(3.0, x.getPower(), 0.001);
    //Returns power even with BinaryOp
    assertEquals(5.0, x2.getPower(), 0.001);
    //With nested Polynomial
    assertEquals(3.0, x10.getPower(), 0.001);
    //With Log
    assertEquals(9.0, x7.getPower(), 0.001);
  }
  
  @Test
  public void testGetOperand(){
    Polynomial x = new Polynomial(new Variable(), 3.0);
    Polynomial x2 = new Polynomial(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)), 3.0);
    Polynomial x9 = new Polynomial(new Cos(new Number(15.0)), 2.0);
    //Returns the "x"
    assertEquals("x", x.getOperand().toString());
    //Returns the BinaryOp
    assertEquals("x + 5.0", x2.getOperand().toString());
    //Returns the Cos
    assertEquals("Cos[15.0]", x9.getOperand().toString());
  }
  
  @Test
  public void testToString(){
    Polynomial x = new Polynomial(new Variable(), 3.0);
    Polynomial x2 = new Polynomial(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)), 3.0);
    Polynomial x3 = new Polynomial(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)), 3.0);
    Polynomial x4 = new Polynomial(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)), 13.0);
    Polynomial x5 = new Polynomial(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)), 5.0);
    Polynomial x6 = new Polynomial(new Exp(new Number(5.0)), 6.0);
    Polynomial x7 = new Polynomial(new Log(new Number(10.0)), 9.0);
    Polynomial x8 = new Polynomial(new Sin(new Number(5.0)), 4.0);
    Polynomial x9 = new Polynomial(new Cos(new Number(15.0)), 2.0);
    Polynomial x10 = new Polynomial(new Polynomial(new Number(5.0), 5.0), 3.0);
    //Variable
    assertEquals("x^3.0", x.toString());
    //BinaryOp PLUS
    assertEquals("(x + 5.0)^3.0", x2.toString());
    //BinaryOp SUB
    assertEquals("(5.0 - 5.0)^3.0", x3.toString());
    //BinaryOp MULT
    assertEquals("(5.0 * 5.0)^13.0", x4.toString());
    //BinaryOp DIV
    assertEquals("(5.0 / 5.0)^5.0", x5.toString());
    //with Exp
    assertEquals("Exp[5.0]^6.0",  x6.toString());
    //with Log
    assertEquals("Log[10.0]^9.0", x7.toString());
    //with Sin
    assertEquals("Sin[5.0]^4.0", x8.toString());
    //with Cos
    assertEquals("Cos[15.0]^2.0", x9.toString());
    //with Polynomial
    assertEquals("5.0^5.0^3.0", x10.toString());   
  }
  
  @Test
  public void testEquals(){
    Polynomial x = new Polynomial(new Variable(), 3.0);
    Polynomial d = new Polynomial(new Variable(), 3.0);
    Polynomial x2 = new Polynomial(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)), 3.0);  
    Polynomial x3 = new Polynomial(new Variable(), 5.0);
    //Same power no BinaryOp
    assertTrue(x.equals(d));    
    //Same Power and Binary Op
    assertTrue(x.equals(x2));
    //Different power 
    assertFalse(x.equals(x3));
    //Different power and BinaryOp
    assertFalse(x2.equals(x3));
  }
    
  @Test
  public void testDerivative(){
    Polynomial x = new Polynomial(new Variable(), 3.0);
    Polynomial x2 = new Polynomial(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)), 3.0);
    Polynomial x3 = new Polynomial(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)), 3.0);
    Polynomial x4 = new Polynomial(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)), 13.0);
    Polynomial x5 = new Polynomial(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)), 5.0);
    Polynomial x6 = new Polynomial(new Exp(new Number(5.0)), 6.0);
    Polynomial x7 = new Polynomial(new Log(new Number(10.0)), 9.0);
    Polynomial x8 = new Polynomial(new Sin(new Number(5.0)), 4.0);
    Polynomial x9 = new Polynomial(new Cos(new Number(15.0)), 2.0);
    Polynomial x10 = new Polynomial(new Polynomial(new Number(5.0), 5.0), 3.0);
    //No BinaryOp
    assertEquals("3.0 * x^2.0", x.derivative().toString());
    //With BinaryOp PLUS
    assertEquals("(3.0 * (x + 5.0)^2.0) * (1.0 + 0.0)", x2.derivative().toString());
    //BinaryOp SUB
    assertEquals("(3.0 * (5.0 - 5.0)^2.0) * (0.0 - 0.0)", x3.derivative().toString());
    //BinaryOp MULT
    assertEquals("(13.0 * (5.0 * 5.0)^12.0) * ((5.0 * 0.0) + (0.0 * 5.0))", x4.derivative().toString());
    //BinaryOp DIV
    assertEquals("(5.0 * (5.0 / 5.0)^4.0) * (((5.0 * 0.0) - (5.0 * 0.0)) / (5.0 * 5.0))", x5.derivative().toString());
    //Exp
    assertEquals("6.0 * Exp[5.0]^5.0", x6.derivative().toString());
    //Log
    assertEquals("9.0 * Log[10.0]^8.0", x7.derivative().toString());
    //Sin
    assertEquals("4.0 * Sin[5.0]^3.0",  x8.derivative().toString());
    //Cos
    assertEquals("2.0 * Cos[15.0]^1.0", x9.derivative().toString());
    //Nested Polynomial
    assertEquals("3.0 * 5.0^5.0^2.0", x10.derivative().toString());
  }
    
  @Test
  public void testValue(){
    Polynomial x = new Polynomial(new Variable(), 3.0);
    Polynomial x2 = new Polynomial(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)), 3.0);
    Polynomial x3 = new Polynomial(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)), 3.0);
    Polynomial x4 = new Polynomial(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)), 13.0);
    Polynomial x5 = new Polynomial(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)), 5.0);
    Polynomial x6 = new Polynomial(new Exp(new Number(5.0)), 6.0);
    Polynomial x7 = new Polynomial(new Log(new Number(10.0)), 9.0);
    Polynomial x8 = new Polynomial(new Sin(new Number(5.0)), 4.0);
    Polynomial x9 = new Polynomial(new Cos(new Number(15.0)), 2.0);
    Polynomial x10 = new Polynomial(new Polynomial(new Number(5.0), 5.0), 3.0);
    //No BinaryOp
    assertEquals(1000.0, x.value(10.0), 0.001);
    //With BinaryOp PLUS with param
    assertEquals(3375.0, x2.value(10.0), 0.001);
    //BinaryOp SUB
    assertEquals(0.0, x3.value(), 0.001);
    //BinaryOp MULT
    assertEquals(1.4901161193847657E18, x4.value(), 0.001);
    //BinaryOp DIV
    assertEquals(1.0, x5.value(), 0.001);
    //Exp
    assertEquals(1.068647458152446E13, x6.value(), 0.001);
    //Log
    assertEquals(1819.4544952004333, x7.value(), 0.001);
    //Sin
    assertEquals(0.8455460222649002, x8.value(), 0.001);
    //Cos
    assertEquals(0.5771257249437921, x9.value(), 0.001);
    //Nested Polynomial
    assertEquals(3.0517578125E10, x10.value(), 0.001);
  }
  
  
  @Test
  public void testUnsupportedOperationException() {
    //With normal Polynomial
    try {
      Polynomial x = new Polynomial(new Variable(), 3.0);
      x.value();
      fail("Expected an exception to be thrown");
    } 
    catch (UnsupportedOperationException e) {
    }
    
    //More complicated Polynomial
    try{
      Polynomial x5 = new Polynomial(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Variable()), 5.0);
      x5.value();
      fail("Expected an exception to be thrown");
    }
    catch (UnsupportedOperationException e){ 
    }         
  }    
}

