/**
 * This class represents the Cosine function
 * @author Izaiah Caston
 */
public class Cos extends Function{
  
  /** the operand that goes into the function*/
  private Function operand;
  
  /**
   * Creates a new instance of Sin
   */
  public Cos(Function operand){
    this.operand = operand; 
  }
  
  /**
   * gives the operand of the function
   * @return the operand of the function
   */
  public Function getOperand(){
    return operand; 
  }
  
  /**
   * Gives the string representation of the created instance
   * @return the string of the instance
   */
  @Override
  public String toString(){
    return "Cos" + "[" + getOperand() + "]"; 
  }
  
  /**
   * checks if two objects have the same operand
   * @param the object being compared
   * @return true or false
   */
  @Override
  public boolean equals(Object x){
    if(x instanceof Cos){
      Cos n = (Cos)x;
      return this.getOperand().equals(n.getOperand()); 
    }
    return false;
  }
  
  /**
   * throws an exception when trying to use value with no parameter with a variable in the function
   * computes the value if there are no variables
   * @return UnsupportedOperationException
   */
  @Override
  public double value(){
    return Math.cos(getOperand().value());  
  }
  /**
   * Calculates the values of the given function
   * @param the value for the variable in the operand
   * @return the double value of the function
   */
  @Override
  public double value(double x){
    return Math.cos(getOperand().value(x)); 
  }
  
  /**
   * Does the derivative of the function
   * @return the value of the function
   */
  @Override
  public Function derivative(){
    return new BinaryOp(BinaryOp.Op.MULT, new BinaryOp(BinaryOp.Op.MULT, getOperand().derivative(), new Sin(getOperand())), new Number(-1));
  } 
}