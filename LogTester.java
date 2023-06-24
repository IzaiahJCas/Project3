/**
 * JUnit
 * @author Izaiah Caston
 */
import org.junit.*;
import static org.junit.Assert.*;
public class LogTester{
  
  @Test
  public void testLog(){
    Log x = new Log(new Variable());
    Log x2 = new Log(new Number(5.0));
    Log x3 = new Log(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));             
    Log x4 = new Log(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Log x5 = new Log(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    Log x6 = new Log(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Log x7 = new Log(new Exp(new Number(5.0)));
    Log x8 = new Log(new Log(new Number(10.0)));
    Log x9 = new Log(new Polynomial(new Variable(), 3.0));   
    Log x10 = new Log(new Sin(new Number(5.0)));
    Log x11 = new Log(new Cos(new Number(15.0)));            
    //With Variable
    assertEquals("Log[x]", x.toString());
    //With Number
    assertEquals("Log[5.0]", x2.toString());
    //With PLUS
    assertEquals("Log[x + 5.0]", x3.toString());
    //With SUB
    assertEquals("Log[5.0 - 5.0]", x4.toString());
    //With DIV
    assertEquals("Log[5.0 / 5.0]", x5.toString());
    //With MULT
    assertEquals("Log[5.0 * 5.0]", x6.toString());
    //With Exp
    assertEquals("Log[Exp[5.0]]", x7.toString());
    //with Log
    assertEquals("Log[Log[10.0]]", x8.toString());
    //With Polynomial
    assertEquals("Log[x^3.0]", x9.toString());
    //With Sin
    assertEquals("Log[Sin[5.0]]", x10.toString());
    //With Cos
    assertEquals("Log[Cos[15.0]]", x11.toString());
  }
  
  @Test
  public void testGetOperand(){
    Log x = new Log(new Variable());
    Log x2 = new Log(new Number(5.0));
    Log x3 = new Log(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Log x4 = new Log(new Polynomial(new Variable(), 3.0));                
    //With Variable
    assertEquals("x", x.getOperand().toString());
    //With Number
    assertEquals("5.0", x2.getOperand().toString());
    //With BinaryOp
    assertEquals("x + 5.0", x3.getOperand().toString());
    //With Polynomial
    assertEquals("x^3.0", x4.getOperand().toString());             
  } 
  
  @Test
  public void testToString(){
   Log x = new Log(new Variable());
   Log x2 = new Log(new Number(5.0));
    Log x3 = new Log(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));             
    Log x4 = new Log(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Log x5 = new Log(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    Log x6 = new Log(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Log x7 = new Log(new Exp(new Number(5.0)));
    Log x8 = new Log(new Log(new Number(10.0)));
    Log x9 = new Log(new Polynomial(new Variable(), 3.0));   
    Log x10 = new Log(new Sin(new Number(5.0)));
    Log x11 = new Log(new Cos(new Number(15.0)));            
    //With Variable
    assertEquals("Log[x]", x.toString());
    //With Number
    assertEquals("Log[5.0]", x2.toString());
    //With PLUS
    assertEquals("Log[x + 5.0]", x3.toString());
    //With SUB
    assertEquals("Log[5.0 - 5.0]", x4.toString());
    //With DIV
    assertEquals("Log[5.0 / 5.0]", x5.toString());
    //With MULT
    assertEquals("Log[5.0 * 5.0]", x6.toString());
    //With Exp
    assertEquals("Log[Exp[5.0]]", x7.toString());
    //with Log
    assertEquals("Log[Log[10.0]]", x8.toString());
    //With Polynomial
    assertEquals("Log[x^3.0]", x9.toString());
    //With Sin
    assertEquals("Log[Sin[5.0]]", x10.toString());
    //With Cos
    assertEquals("Log[Cos[15.0]]", x11.toString());             
  }
  
  @Test
  public void testEquals(){
    Log x = new Log(new Variable());
    Log x2 = new Log(new Variable());
    Log x3 = new Log(new Number(5.0));
    Variable test = new Variable();
    //Same Operand and both Log instances
    assertTrue(x.equals(x2));
    //Not the same Operand
    assertFalse(x.equals(x3));
    //Both not Log instances
    assertFalse(x.equals(test));
  }
  
  @Test
  public void testValue(){
    Log x = new Log(new Variable());
    Log x2 = new Log(new Number(5.0));
    Log x3 = new Log(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));             
    Log x4 = new Log(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Log x5 = new Log(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    Log x6 = new Log(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Log x7 = new Log(new Exp(new Number(5.0)));
    Log x8 = new Log(new Log(new Number(10.0)));
    Log x9 = new Log(new Polynomial(new Variable(), 3.0));   
    Log x10 = new Log(new Sin(new Number(5.0)));
    Log x11 = new Log(new Cos(new Number(15.0)));            
    //With Variable instance
    assertEquals(1.6094379124341003 , x.value(5.0), 0.001);
    //With Number instance
    assertEquals(1.6094379124341003 , x2.value(5.0), 0.001);
    //With BinaryOp instance
    assertEquals(2.302585092994046, x3.value(5.0), 0.001);
    //With Polynomial instance
    assertEquals(4.8283137373023015, x9.value(5.0), 0.001);
    //With Sub
    assertTrue(Double.isInfinite(x4.value()));
    //With DIV
    assertEquals(0.0, x5.value(), 0.001);
    //With MULT
    assertEquals(3.2188758248682006, x6.value(), 0.001);
    //With Exp
    assertEquals(5.0, x7.value(), 0.001);
    //With Log
    assertEquals(0.834032445247956, x8.value(), 0.001);
    //With Sin
    assertEquals(Double.NaN, x10.value(), 0.001);
    //With Cos
    assertEquals(Double.NaN, x11.value(), 0.001);
  }
  
  @Test
  public void testDerivative(){
    Log x = new Log(new Variable());
    Log x2 = new Log(new Number(5.0));
    Log x3 = new Log(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));             
    Log x4 = new Log(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Log x5 = new Log(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    Log x6 = new Log(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Log x7 = new Log(new Exp(new Number(5.0)));
    Log x8 = new Log(new Log(new Number(10.0)));
    Log x9 = new Log(new Polynomial(new Variable(), 3.0));   
    Log x10 = new Log(new Sin(new Number(5.0)));
    Log x11 = new Log(new Cos(new Number(15.0)));            
    //With Variable instance
    assertEquals("1.0 / x", x.derivative().toString());
    //With Number instance
    assertEquals("0.0 / 5.0", x2.derivative().toString());
    //With BinaryOp instance PLUS
    assertEquals("(1.0 + 0.0) / (x + 5.0)", x3.derivative().toString());
    //With Polynomial instance
    assertEquals("(3.0 * x^2.0) / x^3.0", x9.derivative().toString());
    //With BinaryOp instance SUB
    assertEquals("(0.0 - 0.0) / (5.0 - 5.0)", x4.derivative().toString());
    //With BinaryOp instance DIV
    assertEquals("(((5.0 * 0.0) - (5.0 * 0.0)) / (5.0 * 5.0)) / (5.0 / 5.0)", x5.derivative().toString());
    //With BinaryOp instance MULT
    assertEquals("((5.0 * 0.0) + (0.0 * 5.0)) / (5.0 * 5.0)", x6.derivative().toString());
    //With Exp
    assertEquals("(0.0 * Exp[5.0]) / Exp[5.0]", x7.derivative().toString());
    //With Log
    assertEquals("(0.0 / 10.0) / Log[10.0]", x8.derivative().toString());
    //With Sin
    assertEquals("(0.0 * Cos[5.0]) / Sin[5.0]", x10.derivative().toString());
    //With Cos
    assertEquals("((0.0 * Sin[15.0]) * -1.0) / Cos[15.0]", x11.derivative().toString());
  }
  
  
  @Test
  public void testUnsupportedOperationException() {
    //With Variable
    try {
      Log x = new Log(new Variable());
      x.value();
      fail("Expected an exception to be thrown");
    } 
    catch (UnsupportedOperationException e) {
    }
    
    //With BinaryOp
    try{
      Log x3 = new Log(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
      x3.value();
      fail("Expected an exception to be thrown");
    }
    catch (UnsupportedOperationException e){ 
    }         
  } 
}