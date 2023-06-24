/**
 * This class represents the natural Log function in a calculator
 * @author Izaiah Caston
 */
public class Log extends Function{
  
  /** the operand in the function*/
  private Function operand;
  
  /**
   * Creates a new instance of Log
   * @param the operand that goes into Log
   */
  public Log(Function operand){
    this.operand = operand; 
  }
  
  /**
   * gives the operand in the function
   */
  public Function getOperand(){
    return operand; 
  }
  
  /**
   * returns the string representation of the log
   * @return the string "Log[operand]"
   */
  @Override
  public String toString(){
    return "Log" + "[" + getOperand() + "]"; 
  }
  
  /**
   * checks if two objects have the same operand
   * @param the object being compared
   * @return true or false
   */
  @Override
  public boolean equals(Object x){
    if(x instanceof Log){
      Log n = (Log)x;
      return this.getOperand().equals(n.getOperand()); 
    }
    return false;
  }
  
  /**
   * throws an exception when trying to use value with no parameter if there are variable
   * computers the natural log if there are no variables
   * @return UnsupportedOperationException
   */
  @Override
  public double value(){
    return Math.log(getOperand().value());
  }
  
  /**
   * does the log of the given operand
   * @param the value that is put into the variable
   * @return the value of the operand after being in log
   */
  @Override
  public double value(double x){
    return Math.log(getOperand().value(x));
  }
  
  /**
   * does the derivative of the operand
   * @return the derivative of the operand
   */
  @Override
  public Function derivative(){
    return new BinaryOp(BinaryOp.Op.DIV, getOperand().derivative(), getOperand());
  } 
}


