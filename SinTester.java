/**
 * JUnit
 * @author Izaiah Caston
 */
import org.junit.*;
import static org.junit.Assert.*;
public class SinTester{
  
  @Test
  public void testSin(){
    Sin x = new Sin(new Variable());
    Sin x2 = new Sin(new Number(5.0));
    Sin x3 = new Sin(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Sin x4 = new Sin(new Polynomial(new Variable(), 3.0));
    Sin x5 = new Sin(new Log(new Variable()));
    Sin x6 = new Sin(new Exp(new Variable()));
    Sin x7 = new Sin(new Sin(new Variable()));
    Sin x8 = new Sin(new Cos(new Variable()));
    Sin x9 = new Sin(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Sin x10 = new Sin(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Sin x11 = new Sin(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //Variable instance
    assertEquals("Sin[x]", x.toString());
    //Number instance
    assertEquals("Sin[5.0]", x2.toString());
    //BinaryOp instance PLUS
    assertEquals("Sin[x + 5.0]", x3.toString());
    //BinaryOp instance SUB
    assertEquals("Sin[5.0 - 5.0]",x9.toString());
    //BinaryOp instance MULT
    assertEquals("Sin[5.0 * 5.0]", x10.toString());
    //BinaryOp instance DIV
    assertEquals("Sin[5.0 / 5.0]", x11.toString());
    //Polynomial instance
    assertEquals("Sin[x^3.0]", x4.toString());
    //Log instance
    assertEquals("Sin[Log[x]]", x5.toString());
    //Exp instance
    assertEquals("Sin[Exp[x]]", x6.toString());
    //Sin instance
    assertEquals("Sin[Sin[x]]", x7.toString());
    //Cos instance
    assertEquals("Sin[Cos[x]]", x8.toString()); 
  }
  
  @Test
  public void testGetOperand(){
    Sin x5 = new Sin(new Log(new Variable()));
    Sin x4 = new Sin(new Polynomial(new Variable(), 3.0));
    //With Log instance
    assertEquals("Log[x]", x5.getOperand().toString());
    //With Polynomial instance
    assertEquals("x^3.0", x4.getOperand().toString());
  }
  
  @Test
  public void testToString(){
    Sin x = new Sin(new Variable());
    Sin x2 = new Sin(new Number(5.0));
    Sin x3 = new Sin(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Sin x4 = new Sin(new Polynomial(new Variable(), 3.0));
    Sin x5 = new Sin(new Log(new Variable()));
    Sin x6 = new Sin(new Exp(new Variable()));
    Sin x7 = new Sin(new Sin(new Variable()));
    Sin x8 = new Sin(new Cos(new Variable()));
    Sin x9 = new Sin(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Sin x10 = new Sin(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Sin x11 = new Sin(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //Variable instance
    assertEquals("Sin[x]", x.toString());
    //Number instance
    assertEquals("Sin[5.0]", x2.toString());
    //BinaryOp instance PLUS
    assertEquals("Sin[x + 5.0]", x3.toString());
    //BinaryOp instance SUB
    assertEquals("Sin[5.0 - 5.0]",x9.toString());
    //BinaryOp instance MULT
    assertEquals("Sin[5.0 * 5.0]", x10.toString());
    //BinaryOp instance DIV
    assertEquals("Sin[5.0 / 5.0]", x11.toString());
    //Polynomial instance
    assertEquals("Sin[x^3.0]", x4.toString());
    //Log instance
    assertEquals("Sin[Log[x]]", x5.toString());
    //Exp instance
    assertEquals("Sin[Exp[x]]", x6.toString());
    //Sin instance
    assertEquals("Sin[Sin[x]]", x7.toString());
    //Cos instance
    assertEquals("Sin[Cos[x]]", x8.toString());
  }
  
  @Test
  public void testEquals(){
    Sin x = new Sin(new Log(new Number(10.0)));
    Sin x2 = new Sin(new Log(new Number(10.0)));
    Sin x3 = new Sin(new Number(5.0));
    Variable test = new Variable();
    //Same Operand same Instance
    assertTrue(x.equals(x2));
    //Same instance different operand
    assertFalse(x.equals(x3));
    //Different instance different Operand
    assertFalse(x.equals(test));
    //Different Instance same Operand
    assertFalse(x3.equals(test));
  }
  
  @Test
  public void testValue(){
    Sin x = new Sin(new Variable());
    Sin x2 = new Sin(new Number(5.0));
    Sin x3 = new Sin(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Sin x4 = new Sin(new Polynomial(new Variable(), 3.0));
    Sin x5 = new Sin(new Log(new Variable()));
    Sin x6 = new Sin(new Exp(new Variable()));
    Sin x7 = new Sin(new Sin(new Variable()));
    Sin x8 = new Sin(new Cos(new Variable()));
    Sin x9 = new Sin(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Sin x10 = new Sin(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Sin x11 = new Sin(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //With Variable instance and param
    assertEquals(-0.9589242746631385, x.value(5.0), 0.001);
    //With Log instance and param
    assertEquals(0.9992535068234805, x5.value(5.0), 0.001);
    //With Number instance
    assertEquals(-0.9589242746631385, x2.value(), 0.001);
    //With BinaryOp PLUS instance and param
    assertEquals(-0.5440211108893698, x3.value(5.0), 0.001);
    //With BinaryOp SUB instance 
    assertEquals(0.0, x9.value(), 0.001);
    //With BinaryOp MULT instance
    assertEquals(-0.13235175009777303, x10.value(), 0.001);
    //With BinaryOp DIV instance
    assertEquals(0.8414709848078965, x11.value(), 0.001);
    //With Polynomial instance and param
    assertEquals(0.956375928404503, x4.value(3.0), 0.001);
    //With Log instance and param
    assertEquals(0.8905770416677471, x5.value(3.0), 0.001);
    //With Exp instance and param
    assertEquals(0.9444710089262849, x6.value(3.0), 0.001);
    //With Sin instance and param
    assertEquals(-0.8185741444617193, x7.value(5.0), 0.001);
    //With Cos instance and param
    assertEquals(0.2798733507685274, x8.value(5.0), 0.001);
  }
  
  @Test
  public void testDerivative(){
    Sin x = new Sin(new Variable());
    Sin x2 = new Sin(new Number(5.0));
    Sin x3 = new Sin(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Sin x4 = new Sin(new Polynomial(new Variable(), 3.0));
    Sin x5 = new Sin(new Log(new Variable()));
    Sin x6 = new Sin(new Exp(new Variable()));
    Sin x7 = new Sin(new Sin(new Variable()));
    Sin x8 = new Sin(new Cos(new Variable()));
    Sin x9 = new Sin(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Sin x10 = new Sin(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Sin x11 = new Sin(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //With Variable instance
    assertEquals("1.0 * Cos[x]", x.derivative().toString());
    //With Log instance
    assertEquals("(1.0 / x) * Cos[Log[x]]", x5.derivative().toString());
    //With Number instance
    assertEquals("0.0 * Cos[5.0]", x2.derivative().toString());
    //With BinaryOp PLUS instance
    assertEquals("(1.0 + 0.0) * Cos[x + 5.0]", x3.derivative().toString());
    //With BinaryOp SUB instance
    assertEquals("(0.0 - 0.0) * Cos[5.0 - 5.0]", x9.derivative().toString());
    //With BinaryOp MULT instance
    assertEquals("((5.0 * 0.0) + (0.0 * 5.0)) * Cos[5.0 * 5.0]", x10.derivative().toString());
    //With BinaryOp DIV instance
    assertEquals("(((5.0 * 0.0) - (5.0 * 0.0)) / (5.0 * 5.0)) * Cos[5.0 / 5.0]", x11.derivative().toString());
    //With Polynomial instance
    assertEquals("(3.0 * x^2.0) * Cos[x^3.0]", x4.derivative().toString());
    //With Log instance
    assertEquals("(1.0 / x) * Cos[Log[x]]", x5.derivative().toString());
    //With Exp instance
    assertEquals("(1.0 * Exp[x]) * Cos[Exp[x]]", x6.derivative().toString());
    //With Sin instance
    assertEquals("(1.0 * Cos[x]) * Cos[Sin[x]]", x7.derivative().toString());
    //With Cos instance
    assertEquals("((1.0 * Sin[x]) * -1.0) * Cos[Cos[x]]", x8.derivative().toString());
  }
  
  @Test
  public void testUnsupportedOperationException() {
    //BinaryOp case with variable
    try {
      Sin x3 = new Sin(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
      x3.value();
      fail("Expected an exception to be thrown");
    } 
    catch (UnsupportedOperationException e) {
    }
    
    //Sin case with variable
    try{
      Sin x8 = new Sin(new Cos(new Variable()));
      x8.value();
      fail("Expected an exception to be thrown");
    }
    catch (UnsupportedOperationException e){ 
    }         
  }
}









