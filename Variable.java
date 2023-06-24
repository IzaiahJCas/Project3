/** 
 * this class represents a variable "x" within a function
 * @author Izaiah Caston
 */
public class Variable extends Function{
  
  /**
   * Creates a new variable instance with no input
   */
  public Variable(){
  }
  
  /**
   * Returns the value of the Variable instance as "x" always
   * @return "x"
   */
  @Override
  public String toString(){
    return "x"; 
  }
  
  /**
   * Compares whether two objects are both variables
   * @param the other object thats being compared
   * @return whether are not both objects are variables (True/False)
   */
  @Override
  public boolean equals(Object x){
    if(x instanceof Variable){
      Variable v = (Variable)x;
      return this.toString() == x.toString();
    }
    else{
      return false;  
    }
  }
  
  /**
   * Sets the value of the variable to the input
   * @param the value that we want the variable to be set to
   * @return the value that we set for x
   */
  @Override
  public double value(double x){  
    return x;
  }
  
  /** 
   * Does the derivative of the variable
   * @return gives 1.0, derivative of a variable is 1.0
   */
  @Override
  public Function derivative(){ 
    Number n = new Number(1.0);
    return n;
  }
  /**
   * Throws an exception when trying to set value with no parameter
   * @return UnsupportedOperationException
   */
  @Override
  public double value(){
    throw new UnsupportedOperationException("This operation is not supported"); 
  }  
}