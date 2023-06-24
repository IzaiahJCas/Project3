/**
 * JUnit
 * @author Izaiah Caston
 */
import org.junit.*;
import static org.junit.Assert.*;
public class BinaryOpTester{
  
  @Test
  public void testBinaryOp(){
    BinaryOp x = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0));
    BinaryOp x2 = new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Number(5.0));
    BinaryOp x3 = new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0));
    BinaryOp x4 = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0));
    BinaryOp y = new BinaryOp(BinaryOp.Op.PLUS, new Polynomial(new Variable(), 3.0), new Number(5.0));
    BinaryOp y2 = new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Exp(new Number(5.0)));
    BinaryOp y3 = new BinaryOp(BinaryOp.Op.MULT, new Log(new Variable()), new Number(5.0));
    BinaryOp y4 = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Sin(new Number(5.0)));
    BinaryOp y5 = new BinaryOp(BinaryOp.Op.MULT, new Cos(new Variable()), new Number(5.0));
    BinaryOp y6 = new BinaryOp(BinaryOp.Op.PLUS, new BinaryOp(BinaryOp.Op.MULT, new Log(new Variable()), new Number(5.0)), new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Sin(new Number(5.0))));
    //Displays with the + symbol
    assertEquals("x + 5.0", x.toString());                          
    //Displays with the - symbol
    assertEquals("x - 5.0", x2.toString());  
    //Displays with the * symbol
    assertEquals("x * 5.0", x3.toString());  
    //Displays with the / symbol
    assertEquals("x / 5.0", x4.toString());  
    //Displays with Polynomial
    assertEquals("x^3.0 + 5.0", y.toString());
    //Displays with Exp
    assertEquals("x - Exp[5.0]", y2.toString());
    //Displays with Log
    assertEquals("Log[x] * 5.0", y3.toString());
    //Displays with Sin
    assertEquals("x / Sin[5.0]", y4.toString());
    //Displays with Cos
    assertEquals("Cos[x] * 5.0", y5.toString()); 
    //Complicated BinaryOp
    assertEquals("(Log[x] * 5.0) + (x / Sin[5.0])", y6.toString());
  }
  
  @Test
  public void testGetOperator(){
    BinaryOp x = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0));
    BinaryOp x2 = new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Number(5.0));
    BinaryOp x3 = new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0));
    BinaryOp x4 = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0));
    //Checks for PLUS
    assertEquals("PLUS" , x.getOperator().toString());
    //Checks for SUB
    assertEquals("SUB" , x2.getOperator().toString());
    //Checks for MULT
    assertEquals("MULT" , x3.getOperator().toString());
    //Checks for DIV
    assertEquals("DIV" , x4.getOperator().toString());
  }
  
  @Test
  public void testGetLeftOperand(){
    BinaryOp x = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0));
    BinaryOp x2 = new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Variable());
    BinaryOp y3 = new BinaryOp(BinaryOp.Op.MULT, new Log(new Variable()), new Number(5.0));
    BinaryOp y4 = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Sin(new Number(5.0)));
    //Checks for "x" being the Left Operand / PLUS operand
    assertEquals("x", x.getLeftOperand().toString());
    //Checks for "5.0" being the left Operand / SUB operand
    assertEquals("5.0", x2.getLeftOperand().toString());
    //MULt operand
    assertEquals("Log[x] * 5.0", y3.toString());
    //DIV operand
    assertEquals("x / Sin[5.0]", y4.toString());
    
  }
  
  @Test
  public void testGetRightOperand(){
    BinaryOp x = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0));
    BinaryOp x2 = new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Variable());
    BinaryOp y3 = new BinaryOp(BinaryOp.Op.MULT, new Log(new Variable()), new Number(5.0));
    BinaryOp y4 = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Sin(new Number(5.0)));
    //Checks for "5.0" being the Right Operand /PLUS
    assertEquals("5.0", x.getRightOperand().toString());
    //Checks for "x" being the Right Operand /SUB
    assertEquals("x", x2.getRightOperand().toString());
    //MULT
    assertEquals("Log[x] * 5.0", y3.toString());
    //DIV
    assertEquals("x / Sin[5.0]", y4.toString());
  }
  
  @Test
  public void testValue(){
    BinaryOp x = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0));
    BinaryOp x2 = new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Number(5.0));
    BinaryOp x3 = new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0));
    BinaryOp x4 = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0));
    BinaryOp y = new BinaryOp(BinaryOp.Op.PLUS, new Polynomial(new Number(5.0), 3.0), new Number(5.0));
    BinaryOp y2 = new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Exp(new Number(5.0)));
    BinaryOp y3 = new BinaryOp(BinaryOp.Op.MULT, new Log(new Number(10.0)), new Number(5.0));
    BinaryOp y4 = new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Sin(new Number(5.0)));
    BinaryOp y5 = new BinaryOp(BinaryOp.Op.MULT, new Cos(new Number(15.0)), new Number(5.0));
    BinaryOp y6 = new BinaryOp(BinaryOp.Op.PLUS, new BinaryOp(BinaryOp.Op.MULT, new Log(new Number(15.0)), new Number(5.0)), new BinaryOp(BinaryOp.Op.DIV, new Number(50.0), new Sin(new Number(5.0))));
    //Calculation for PLUS
    assertEquals(10.0, x.value(5.0), 0.001);
    //Calculation for SUB
    assertEquals(0.0, x2.value(5.0), 0.001);
    //Calculation for MULT
    assertEquals(25.0, x3.value(5.0), 0.001);
    //Calculation for DIV
    assertEquals(1.0, x4.value(5.0), 0.001);
    //Polynomial no parameter PLUS
    assertEquals(130.0, y.value(), 0.001);
    //Exp no param SUB
    assertEquals(-143.4131591025766, y2.value(), 0.001); 
    //Log no param MULT
    assertEquals(11.51292546497023, y3.value(), 0.001);
    //Sin no param DIV
    assertEquals(-5.214176063857029,  y4.value(), 0.001);
    //Cos no param MULT
    assertEquals(-3.7984395642941067, y5.value(), 0.001);
    //Complex no param PLUS
    assertEquals(-38.60150963305924, y6.value(), 0.001);
  }
  
  @Test(expected = UnsupportedOperationException.class)
  //tests exception thrown
    public void testUnsupportedOperationException() {
    BinaryOp x = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0));
    BinaryOp x2 = new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Number(5.0));
    BinaryOp x3 = new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0));
    BinaryOp x4 = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0));
    BinaryOp y6 = new BinaryOp(BinaryOp.Op.PLUS, new BinaryOp(BinaryOp.Op.MULT, new Log(new Number(15.0)), new Number(5.0)), new BinaryOp(BinaryOp.Op.DIV, new Number(50.0), new Sin(new Variable()))); 
    //PLUS
    x.value();
    //SUB
    x2.value();
    //MULT
    x3.value();
    //DIV
    x4.value();
    //Complicated BinaryOp
    y6.value();
  }
  
  @Test
  public void testDerivative(){
    BinaryOp x = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0));
    BinaryOp x2 = new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Number(5.0));
    BinaryOp x3 = new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0));
    BinaryOp x4 = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0));
    BinaryOp y = new BinaryOp(BinaryOp.Op.PLUS, new Polynomial(new Number(5.0), 3.0), new Number(5.0));
    BinaryOp y2 = new BinaryOp(BinaryOp.Op.SUB, new Number(5.0), new Exp(new Number(5.0)));
    BinaryOp y3 = new BinaryOp(BinaryOp.Op.MULT, new Log(new Number(10.0)), new Number(5.0));
    BinaryOp y4 = new BinaryOp(BinaryOp.Op.DIV, new Number(5.0), new Sin(new Number(5.0)));
    BinaryOp y5 = new BinaryOp(BinaryOp.Op.MULT, new Cos(new Number(15.0)), new Number(5.0));
    BinaryOp y6 = new BinaryOp(BinaryOp.Op.PLUS, new BinaryOp(BinaryOp.Op.MULT, new Log(new Number(15.0)), new Number(5.0)), new BinaryOp(BinaryOp.Op.DIV, new Number(50.0), new Sin(new Number(5.0))));
    //Derivative for a plus operation
    assertEquals("1.0 + 0.0", x.derivative().toString());
    //Derivative for sub operation
    assertEquals("1.0 - 0.0", x2.derivative().toString());
    //Derivative for Mult operation using product rule
    assertEquals("(x * 0.0) + (1.0 * 5.0)", x3.derivative().toString());
    //Derivative for Div operations using quotient rule
    assertEquals("((5.0 * 1.0) - (x * 0.0)) / (5.0 * 5.0)" , x4.derivative().toString());
    //Derivative PLUS Polynomial
    assertEquals("(3.0 * 5.0^2.0) + 0.0", y.derivative().toString());
    //Derivative SUB Exp
    assertEquals("0.0 - (0.0 * Exp[5.0])", y2.derivative().toString());
    //Derivative MULT Log
    assertEquals("(Log[10.0] * 0.0) + ((0.0 / 10.0) * 5.0)", y3.derivative().toString());
    //Derivative DIV Sin
    assertEquals("((Sin[5.0] * 0.0) - (5.0 * 0.0 * Cos[5.0])) / (Sin[5.0] * Sin[5.0])", y4.derivative().toString());
    //Derivative MULT Cos
    assertEquals("(Cos[15.0] * 0.0) + (((0.0 * Sin[15.0]) * -1.0) * 5.0)", y5.derivative().toString());
    //Complicated BinaryOp both Operands
    assertEquals("((Log[15.0] * 0.0) + ((0.0 / 15.0) * 5.0)) + (((Sin[5.0] * 0.0) - (50.0 * 0.0 * Cos[5.0])) / (Sin[5.0] * Sin[5.0]))", y6.derivative().toString());
  }
  
  @Test
  public void testEquals(){
    BinaryOp x = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0));
    BinaryOp x2 = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0));
    BinaryOp x3 = new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Number(5.0));
    BinaryOp x4 = new BinaryOp(BinaryOp.Op.PLUS, new Number(10.0), new Number(5.0));
    BinaryOp x5 = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(50.0));
    //Same everything
    assertTrue(x.equals(x2));
    //Different operation
    assertFalse(x.equals(x3));
    //Different left operand
    assertFalse(x.equals(x4));
    //Different right operand
    assertFalse(x.equals(x5));
  }
  
  @Test
  public void testToString(){
    BinaryOp x = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0));
    BinaryOp x2 = new BinaryOp(BinaryOp.Op.PLUS, new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)), new Number(5.0));
    BinaryOp x3 = new BinaryOp(BinaryOp.Op.PLUS, new Variable(),  new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    BinaryOp x4 = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Number(5.0)));
    BinaryOp s = new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Number(5.0));
    BinaryOp s2 = new BinaryOp(BinaryOp.Op.SUB,  new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Number(5.0)), new Number(5.0));
    BinaryOp s3 = new BinaryOp(BinaryOp.Op.SUB, new Variable(), new BinaryOp(BinaryOp.Op.SUB, new Variable(), new Number(5.0)));
    BinaryOp s4 = new BinaryOp(BinaryOp.Op.SUB, new Variable(), new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0)));
    BinaryOp m = new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0));
    BinaryOp m2 = new BinaryOp(BinaryOp.Op.MULT, new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0)), new Number(5.0));
    BinaryOp m3 = new BinaryOp(BinaryOp.Op.MULT, new Variable(), new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0)));
    BinaryOp m4 = new BinaryOp(BinaryOp.Op.MULT, new Variable(), new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0)));
    BinaryOp d = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0));
    BinaryOp d2 = new BinaryOp(BinaryOp.Op.DIV, new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0)), new Number(5.0));
    BinaryOp d3 = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0)));
    BinaryOp d4 = new BinaryOp(BinaryOp.Op.DIV, new Variable(), new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(5.0)));
    BinaryOp fin = new BinaryOp(BinaryOp.Op.PLUS,  new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0)), new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0)));
    BinaryOp fin2 = new BinaryOp(BinaryOp.Op.SUB,  new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0)), new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0)));
    BinaryOp fin3 = new BinaryOp(BinaryOp.Op.MULT,  new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0)), new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0)));
    BinaryOp fin4 = new BinaryOp(BinaryOp.Op.DIV,  new BinaryOp(BinaryOp.Op.MULT, new Variable(), new Number(5.0)), new BinaryOp(BinaryOp.Op.DIV, new Variable(), new Number(5.0)));
    /** PLUS */
    //No BinaryOp
    assertEquals("x + 5.0", x.toString());
    //Left BinaryOp
    assertEquals("(x + 5.0) + 5.0", x2.toString());
    //Right BinaryOp same Operator
    assertEquals("x + x + 5.0", x3.toString());
    //Right BinaryOp different Operator
    assertEquals("x + (x - 5.0)", x4.toString());
    /** SUB */
    //No BinaryOp
    assertEquals("x - 5.0", s.toString());
    //Left BinaryOp
    assertEquals("(x - 5.0) - 5.0", s2.toString());
    //Right BinaryOp same Operator
    assertEquals("x - x - 5.0", s3.toString());
    //Right BinaryOp different Operator
    assertEquals("x - (x * 5.0)", s4.toString());
    /** MULT */
    //No BinaryOp
    assertEquals("x * 5.0", m.toString());
    //Left BinaryOp
    assertEquals("(x * 5.0) * 5.0", m2.toString());
    //Right BinaryOp same Operator
    assertEquals("x * x * 5.0", m3.toString());
    //Right BinaryOp different Operator
    assertEquals("x * (x / 5.0)", m4.toString());
    /** DIV */
    //No BinaryOp
    assertEquals("x / 5.0", d.toString());
    //Left BinaryOp
    assertEquals("(x / 5.0) / 5.0", d2.toString());
    //Right BinaryOp same Operator
    assertEquals("x / x / 5.0", d3.toString());
    //Right BinaryOp different Operator
    assertEquals("x / (x + 5.0)", d4.toString());
    //Both BinaryOp PLUS
    assertEquals("(x * 5.0) + (x / 5.0)", fin.toString());
    //Both BinaryOp SUB
    assertEquals("(x * 5.0) - (x / 5.0)", fin2.toString());
    //Both BinaryOp MULT
    assertEquals("(x * 5.0) * (x / 5.0)", fin3.toString());
    //Both BinaryOp DIV
    assertEquals("(x * 5.0) / (x / 5.0)", fin4.toString());
  }
}