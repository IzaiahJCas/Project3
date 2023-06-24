/**
 * JUnit
 * @author Izaiah Caston
 */
import org.junit.*;
import static org.junit.Assert.*;
public class CosTester{
  
  @Test
  public void testCos(){
    Cos x = new Cos(new Variable());
    Cos x2 = new Cos(new Number(5.0));
    Cos x3 = new Cos(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Cos x4 = new Cos(new Polynomial(new Variable(), 3.0));
    Cos x5 = new Cos(new Log(new Variable()));
    Cos x6 = new Cos(new Exp(new Variable()));
    Cos x7 = new Cos(new Sin(new Variable()));
    Cos x8 = new Cos(new Cos(new Variable()));
    Cos x9 = new Cos(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Cos x10 = new Cos(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Cos x11 = new Cos(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //Variable instance
    assertEquals("Cos[x]", x.toString());
    //Number instance
    assertEquals("Cos[5.0]", x2.toString());
    //BinaryOp instance PLUS
    assertEquals("Cos[x + 5.0]", x3.toString());
    //BinaryOp instance SUB
    assertEquals("Cos[5.0 - 5.0]",x9.toString());
    //BinaryOp instance MULT
    assertEquals("Cos[5.0 * 5.0]", x10.toString());
    //BinaryOp instance DIV
    assertEquals("Cos[5.0 / 5.0]", x11.toString());
    //Polynomial instance
    assertEquals("Cos[x^3.0]", x4.toString());
    //Log instance
    assertEquals("Cos[Log[x]]", x5.toString());
    //Exp instance
    assertEquals("Cos[Exp[x]]", x6.toString());
    //Sin instance
    assertEquals("Cos[Sin[x]]", x7.toString());
    //Cos instance
    assertEquals("Cos[Cos[x]]", x8.toString()); 
  }
  
  
  @Test
  public void testGetOperand(){
    Cos x5 = new Cos(new Log(new Variable()));
    Cos x4 = new Cos(new Polynomial(new Variable(), 3.0));
    //With Log instance
    assertEquals("Log[x]", x5.getOperand().toString());
    //With Polynomial instance
    assertEquals("x^3.0", x4.getOperand().toString());
  }
  
  @Test
  public void testToString(){
    Cos x = new Cos(new Variable());
    Cos x2 = new Cos(new Number(5.0));
    Cos x3 = new Cos(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Cos x4 = new Cos(new Polynomial(new Variable(), 3.0));
    Cos x5 = new Cos(new Log(new Variable()));
    Cos x6 = new Cos(new Exp(new Variable()));
    Cos x7 = new Cos(new Sin(new Variable()));
    Cos x8 = new Cos(new Cos(new Variable()));
    Cos x9 = new Cos(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Cos x10 = new Cos(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Cos x11 = new Cos(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //Variable instance
    assertEquals("Cos[x]", x.toString());
    //Number instance
    assertEquals("Cos[5.0]", x2.toString());
    //BinaryOp instance PLUS
    assertEquals("Cos[x + 5.0]", x3.toString());
    //BinaryOp instance SUB
    assertEquals("Cos[5.0 - 5.0]",x9.toString());
    //BinaryOp instance MULT
    assertEquals("Cos[5.0 * 5.0]", x10.toString());
    //BinaryOp instance DIV
    assertEquals("Cos[5.0 / 5.0]", x11.toString());
    //Polynomial instance
    assertEquals("Cos[x^3.0]", x4.toString());
    //Log instance
    assertEquals("Cos[Log[x]]", x5.toString());
    //Exp instance
    assertEquals("Cos[Exp[x]]", x6.toString());
    //Sin instance
    assertEquals("Cos[Sin[x]]", x7.toString());
    //Cos instance
    assertEquals("Cos[Cos[x]]", x8.toString()); 
  }
  
  
  @Test
  public void testEquals(){
    Cos x = new Cos(new Exp(new Number(5.0)));
    Cos x2 = new Cos(new Exp(new Number(5.0)));
    Cos x3 = new Cos(new Number(5.0));
    Variable test = new Variable();
    //Same Operand same Instance
    assertTrue(x.equals(x2));
    //Same instance different operand
    assertFalse(x.equals(x3));
    //Different instnace dfferent Operand
    assertFalse(x.equals(test));
    //Different Instance same Operand
    assertFalse(x3.equals(test));
  }
  
  @Test
  public void testValue(){
     Cos x = new Cos(new Variable());
    Cos x2 = new Cos(new Number(5.0));
    Cos x3 = new Cos(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Cos x4 = new Cos(new Polynomial(new Variable(), 3.0));
    Cos x5 = new Cos(new Log(new Variable()));
    Cos x6 = new Cos(new Exp(new Variable()));
    Cos x7 = new Cos(new Sin(new Variable()));
    Cos x8 = new Cos(new Cos(new Variable()));
    Cos x9 = new Cos(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Cos x10 = new Cos(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Cos x11 = new Cos(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //With Variable instance and param
    assertEquals(0.28366218546322625, x.value(5.0), 0.001);
    //With Log instance and param
    assertEquals(-0.038631969933935334, x5.value(5.0), 0.001);
    //With Number instance
    assertEquals(0.28366218546322625, x2.value(), 0.001);
    //With BinaryOp PLUS instance and param
    assertEquals(-0.8390715290764524, x3.value(5.0), 0.001);
    //With BinaryOp SUB instance 
    assertEquals(1.0, x9.value(), 0.001);
    //With BinaryOp MULT instance
    assertEquals(0.9912028118634736, x10.value(), 0.001);
    //With BinaryOp DIV instance
    assertEquals(0.5403023058681398, x11.value(), 0.001);
    //With Polynomial instance and param
    assertEquals(-0.2921388087338362, x4.value(3.0), 0.001);
    //With Exp instance and param
    assertEquals(0.3285947554325321, x6.value(3.0), 0.001);
    //With Sin instance and param
    assertEquals(0.574400879193934, x7.value(5.0), 0.001);
    //With Cos instance and param
    assertEquals(0.9600369302946615, x8.value(5.0), 0.001);
  }
  
  @Test
  public void testDerivative(){
    Cos x = new Cos(new Variable());
    Cos x2 = new Cos(new Number(5.0));
    Cos x3 = new Cos(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    Cos x4 = new Cos(new Polynomial(new Variable(), 3.0));
    Cos x5 = new Cos(new Log(new Variable()));
    Cos x6 = new Cos(new Exp(new Variable()));
    Cos x7 = new Cos(new Sin(new Variable()));
    Cos x8 = new Cos(new Cos(new Variable()));
    Cos x9 = new Cos(new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Number(5.0)));
    Cos x10 = new Cos(new BinaryOp(BinaryOp.Op.MULT, new Number(5.0), new Number(5.0)));
    Cos x11 = new Cos(new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Number(5.0)));
    //With Variable instance
    assertEquals("(1.0 * Sin[x]) * -1.0", x.derivative().toString());
    //With Log instance
    assertEquals("((1.0 / x) * Sin[Log[x]]) * -1.0", x5.derivative().toString());
    //With Number instance
    assertEquals("(0.0 * Sin[5.0]) * -1.0", x2.derivative().toString());
    //With BinaryOp PLUS instance
    assertEquals("((1.0 + 0.0) * Sin[x + 5.0]) * -1.0", x3.derivative().toString());
    //With BinaryOp SUB instance
    assertEquals("((0.0 - 0.0) * Sin[5.0 - 5.0]) * -1.0", x9.derivative().toString());
    //With BinaryOp MULT instance
    assertEquals("(((5.0 * 0.0) + (0.0 * 5.0)) * Sin[5.0 * 5.0]) * -1.0", x10.derivative().toString());
    //With BinaryOp DIV instance
    assertEquals("((((5.0 * 0.0) - (5.0 * 0.0)) / (5.0 * 5.0)) * Sin[5.0 / 5.0]) * -1.0", x11.derivative().toString());
    //With Polynomial instance
    assertEquals("((3.0 * x^2.0) * Sin[x^3.0]) * -1.0", x4.derivative().toString());
    //With Exp instance
    assertEquals("((1.0 * Exp[x]) * Sin[Exp[x]]) * -1.0", x6.derivative().toString());
    //With Sin instance
    assertEquals("((1.0 * Cos[x]) * Sin[Sin[x]]) * -1.0", x7.derivative().toString());
    //With Cos instance
    assertEquals("(((1.0 * Sin[x]) * -1.0) * Sin[Cos[x]]) * -1.0", x8.derivative().toString());
  }

  @Test
  public void testUnsupportedOperationException() {
    //BinaryOp case with variable
    try {
      Cos x3 = new Cos(new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
      x3.value();
      fail("Expected an exception to be thrown");
    } 
    catch (UnsupportedOperationException e) {
    }
    
    //Exp case with variable
    try{
     Cos x6 = new Cos(new Exp(new Variable()));
      x6.value();
      fail("Expected an exception to be thrown");
    }
    catch (UnsupportedOperationException e){ 
    }         
  }
}
  
  