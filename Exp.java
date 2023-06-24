/**
 * This class represents the natural exponential function
 * @author Izaiah Caston
 */
public class Exp extends Function{
  
  /** the operand that goes into the function */
  private Function operand;
  
  /**
   * Creates a new instance of the Exp function
   * @param the operand that goes inside of the function
   */
  public Exp(Function operand){
    this.operand = operand; 
  }
  
  /**
   * Gives the operand in the Exp instance
   * @return the operand in the function
   */
  public Function getOperand(){
    return operand; 
  }
  
  /**
   * returns the string representation of the Exp
   * @return the string "Exp[operand]"
   */
  @Override
  public String toString(){
    return "Exp" + "[" + getOperand() + "]"; 
  }
  
  /**
   * compares if the two objects are both Exp instances
   * @param the object that is being compared
   * @return true or false
   */
  @Override
  public boolean equals(Object x){
    if(x instanceof Exp){
      Exp n = (Exp)x;
      return this.getOperand().equals(n.getOperand());
    }
    return false;
  }
  
  /**
   * throws an exception when trying to use value with no parameter with variables in the function
   * computes the value if there are no variables
   * @return UnsupportedOperationException
   */
  @Override
  public double value(){    
    return Math.exp(getOperand().value());
  }
  
  /**
   * calculates the value of the function with given variable value
   * @param the value of the variable
   * @return the value that is calculated
   */
  @Override
  public double value(double x){
    return Math.exp(getOperand().value(x)); 
  }
  
  /**
   * does the derivative of the function 
   * @return gives a representation of the derivative of the function
   */
  @Override
  public Function derivative(){
    return new BinaryOp(BinaryOp.Op.MULT, getOperand().derivative(), new Exp(getOperand())); 
  } 
}