/**
 * JUnit
 * @author Izaiah Caston
 */
import org.junit.*;
import static org.junit.Assert.*;
public class ExpTester{
  
  @Test
  public void testExp(){
    Exp x = new Exp(new Variable());
    Exp x2 = new Exp(new Number(5.0));
    Exp x3 = new Exp(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Exp x4 = new Exp(new Polynomial(new Variable(), 3.0));
    Exp x5 = new Exp(new Log(new Variable()));
    Exp x6 = new Exp(new Exp(new Variable()));
    Exp x7 = new Exp(new Sin(new Variable()));
    Exp x8 = new Exp(new Cos(new Variable()));
    Exp x9 = new Exp(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Exp x10 = new Exp(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Exp x11 = new Exp(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //Variable instance
    assertEquals("Exp[x]", x.toString());
    //Number instance
    assertEquals("Exp[5.0]", x2.toString());
    //BinaryOp instance PLUS
    assertEquals("Exp[x + 5.0]", x3.toString());
    //BinaryOp instance SUB
    assertEquals("Exp[5.0 - 5.0]", x9.toString());
    //BinaryOp instance MULT
    assertEquals("Exp[5.0 * 5.0]", x10.toString());
    //BinaryOp instance DIV
    assertEquals("Exp[5.0 / 5.0]", x11.toString());
    //Polynomial instance
    assertEquals("Exp[x^3.0]", x4.toString());
    //Log instance
    assertEquals("Exp[Log[x]]", x5.toString());
    //Exp instance
    assertEquals("Exp[Exp[x]]", x6.toString());
    //Sin instance
    assertEquals("Exp[Sin[x]]", x7.toString());
    //Cos instance
    assertEquals("Exp[Cos[x]]", x8.toString()); 
  }
  
  @Test
  public void testGetOperand(){
    Exp x = new Exp(new Variable()); 
    Exp x2 = new Exp(new Sin(new Variable()));
    //Testing with Variable instance
    assertEquals("x" , x.getOperand().toString());
    //Testing with Sin instance
    assertEquals("Sin[x]", x2.getOperand().toString());
  }
  
  @Test
  public void testToString(){
    Exp x = new Exp(new Variable());
    Exp x2 = new Exp(new Number(5.0));
    Exp x3 = new Exp(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Exp x4 = new Exp(new Polynomial(new Variable(), 3.0));
    Exp x5 = new Exp(new Log(new Variable()));
    Exp x6 = new Exp(new Exp(new Variable()));
    Exp x7 = new Exp(new Sin(new Variable()));
    Exp x8 = new Exp(new Cos(new Variable()));
    Exp x9 = new Exp(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Exp x10 = new Exp(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Exp x11 = new Exp(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //Variable instance
    assertEquals("Exp[x]", x.toString());
    //Number instance
    assertEquals("Exp[5.0]", x2.toString());
    //BinaryOp instance PLUS
    assertEquals("Exp[x + 5.0]", x3.toString());
    //BinaryOp instance SUB
    assertEquals("Exp[5.0 - 5.0]", x9.toString());
    //BinaryOp instance MULT
    assertEquals("Exp[5.0 * 5.0]", x10.toString());
    //BinaryOp instance DIV
    assertEquals("Exp[5.0 / 5.0]", x11.toString());
    //Polynomial instance
    assertEquals("Exp[x^3.0]", x4.toString());
    //Log instance
    assertEquals("Exp[Log[x]]", x5.toString());
    //Exp instance
    assertEquals("Exp[Exp[x]]", x6.toString());
    //Sin instance
    assertEquals("Exp[Sin[x]]", x7.toString());
    //Cos instance
    assertEquals("Exp[Cos[x]]", x8.toString()); 
  }
  
  @Test
  public void testEquals(){
    Exp x = new Exp(new Sin(new Variable()));
    Exp x2 = new Exp(new Sin(new Variable()));
    Exp x3 = new Exp(new Number(5.0));
    Variable test = new Variable();
    //Same operand
    assertTrue(x.equals(x2));
    //Different operand both Exp
    assertFalse(x.equals(x3));
    //Different Instance same operand
    assertFalse(x.equals(test));
    //Different instance different operand
    assertFalse(x3.equals(test));
  }
  
  @Test
  public void testValue(){
    Exp x = new Exp(new Variable());
    Exp x2 = new Exp(new Number(5.0));
    Exp x3 = new Exp(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Exp x4 = new Exp(new Polynomial(new Variable(), 3.0));
    Exp x5 = new Exp(new Log(new Variable()));
    Exp x6 = new Exp(new Exp(new Variable()));
    Exp x7 = new Exp(new Sin(new Variable()));
    Exp x8 = new Exp(new Cos(new Variable()));
    Exp x9 = new Exp(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Exp x10 = new Exp(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Exp x11 = new Exp(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //With variable and param
    assertEquals(148.4131591025766, x.value(5.0), 0.001);
    //With Number
    assertEquals(148.4131591025766, x2.value(), 0.001);
    //With BinaryOp PLUS and param
    assertEquals(2980.9579870417283, x3.value(3.0), 0.001);
    //With BinaryOp SUB
    assertEquals(1.0, x9.value(), 0.001);
    //With BinaryOp MULT
    assertEquals(7.200489933738588E10, x10.value(), 0.001);
    //With BinaryOp DIV
    assertEquals(2.718281828459045, x11.value(), 0.001);
    //With Polynomial and param
    assertEquals(2.718281828459045, x4.value(1.0), 0.001);
    //With Log and param
    assertEquals(6.0, x5.value(6.0), 0.001);
    //With Exp and param
    assertEquals(1.6102705667793523E175, x6.value(6.0), 0.001);
    //With Sin and param
    assertEquals(0.7562256275428552, x7.value(6.0), 0.001);
    //With Cos and param
    assertEquals(2.61214124833589, x8.value(6.0), 0.001);
  }
  
  @Test
  public void testDerivative(){
    Exp x = new Exp(new Variable());
    Exp x2 = new Exp(new Number(5.0));
    Exp x3 = new Exp(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Exp x4 = new Exp(new Polynomial(new Variable(), 3.0));
    Exp x5 = new Exp(new Log(new Variable()));
    Exp x6 = new Exp(new Exp(new Variable()));
    Exp x7 = new Exp(new Sin(new Variable()));
    Exp x8 = new Exp(new Cos(new Variable()));
    Exp x9 = new Exp(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Exp x10 = new Exp(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Exp x11 = new Exp(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //With Variable
    assertEquals("1.0 * Exp[x]", x.derivative().toString());
    //With Number
    assertEquals("0.0 * Exp[5.0]", x2.derivative().toString());
    //With BinaryOp PLUS
    assertEquals("(1.0 + 0.0) * Exp[x + 5.0]", x3.derivative().toString());
    //With BinaryOp SUB
    assertEquals("(0.0 - 0.0) * Exp[5.0 - 5.0]", x9.derivative().toString());
    //With BinaryOp MULT
    assertEquals("((5.0 * 0.0) + (0.0 * 5.0)) * Exp[5.0 * 5.0]", x10.derivative().toString());
    //With BinaryOp DIV
    assertEquals("(((5.0 * 0.0) - (5.0 * 0.0)) / (5.0 * 5.0)) * Exp[5.0 / 5.0]", x11.derivative().toString());
    //With Polynomial
    assertEquals("(3.0 * x^2.0) * Exp[x^3.0]", x4.derivative().toString());
    //With Log
    assertEquals("(1.0 / x) * Exp[Log[x]]", x5.derivative().toString());
    //With Exp
    assertEquals("(1.0 * Exp[x]) * Exp[Exp[x]]", x6.derivative().toString());
    //With Sin
    assertEquals("(1.0 * Cos[x]) * Exp[Sin[x]]", x7.derivative().toString());
    //With Cos
    assertEquals("((1.0 * Sin[x]) * -1.0) * Exp[Cos[x]]", x8.derivative().toString()); 
  }
  
  @Test
  public void testUnsupportedOperationException() {
    //BinaryOp case with variable
    try {
      Exp x3 = new Exp(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
      x3.value();
      fail("Expected an exception to be thrown");
    } 
    catch (UnsupportedOperationException e) {
    }
    
    //Cos case with variable
    try{
      Exp x8 = new Exp(new Cos(new Variable()));
      x8.value();
      fail("Expected an exception to be thrown");
    }
    catch (UnsupportedOperationException e){ 
    }         
  }  
}