/** 
 * A class that represents a Polynomial function
 * @author Izaiah Caston
 */
public class Polynomial extends Function{
  
  /** the power of the polynomial**/
  private double power;
  
  /** the operand in the polynomial**/
  private Function operand;
  
  /**
   * Creates a new Polynomial instance function
   * @param the operand in the function, the power of the polynomial
   */
  public Polynomial(Function operand, double power){
    this.operand = operand;
    this.power = power;
  }
  
  /**
   * gives the power of the polynomial
   * @return the value of the power
   */
  public double getPower(){
    return power; 
  }
  
  /**
   * gives the operand in the polynomial
   * @return the polynomial
   */
  public Function getOperand(){
    return operand; 
  }
  
  /**
   * gives the string representation of the polynomial
   * @return the string of the Polynomial instance
   */
  @Override
  public String toString(){
    if(getOperand() instanceof BinaryOp){
      return "(" + getOperand() + ")" + "^" + getPower(); 
    }
    else{
      return getOperand() + "^" + getPower(); 
    }
  }
  
  /**
   * compares two objects to see if both are Polynomial instances
   * @param the object that is being compared to
   * @return true or false
   */
  @Override
  public boolean equals(Object x){
    if(x instanceof Polynomial){
      Polynomial n = (Polynomial)x;
      return this.getPower() == n.getPower();
    }
    return false;
  }
  
  /**
   * throws an exception when trying to use value with no parameter if there is a variable
   * If there is no variable, simply does the calculation
   * @return UnsupportedOperationException
   */
  @Override
  public double value(){
    return Math.pow(getOperand().value() , getPower());
  }
  
  /**
   * does the derivative of the polynomial
   * @return returns the string of the derivative of the polynomial instance
   */
  @Override
  public Function derivative(){
    if(getOperand() instanceof BinaryOp){
      return new BinaryOp(BinaryOp.Op.MULT, new BinaryOp(BinaryOp.Op.MULT, new Number(getPower()), new Polynomial(getOperand() , getPower() - 1)), 
                          getOperand().derivative());
    }
    else{
      return new BinaryOp(BinaryOp.Op.MULT, new Number(getPower()), new Polynomial(getOperand(), getPower() -1)); 
    }
  }
  
  /**
   * calculates the value of the polynomial that is entered into the equations
   * @param the value of the variable in the polynomial
   * @return the double value of the polynomial
   */
  @Override 
  public double value(double x){
    return Math.pow(getOperand().value(x) , getPower());
  }  
}