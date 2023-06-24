/** 
 * this class represents the number within the function
 * @author Izaiah Caston
 */
public class Number extends Function{
  
  /** the number that is held */
  private double num;
  
  /**
   * Creates a new Number instance with the number value
   * @param the number value that is wanted
   */
  public Number(double num){
    this.num = num;
  }
  
  /**
   * Gets the value of the number instance
   * @return the value of the number instance
   */
  public double getNumber(){
    return num;
  }
  
  /**
   * Changes the number value of the number instance
   * @param the double value that is being set
   */
  public void setNumber(double num){
    this.num = num; 
  }
  
  /**
   * Represents the number as a string
   * @return give the number value as a string
   */
  @Override
  public String toString(){
    return "" + getNumber();
  }
  
  /**
   * Compares two objects to see if they're both Nnumber instances
   * @param the object that is being compared
   * @return if the two objects are both Number instances
   */
  @Override
  public boolean equals(Object x){
    if(x instanceof Number){
      Number n = (Number)x;
      return this.getNumber() == n.getNumber();
    }
    else{
      return false; 
    }
  }
  
  /**
   * Returns the value of the number instnace
   * @param the value of the variable
   * @return the double value of the number instance
   */
  @Override
  public double value(double x){  
    return getNumber();
  }
  
  /**
   * returns the value of the number
   * @return UnsupportedOperationException
   */
  @Override
  public double value(){
    return getNumber();
  }
  
  /**
   * computes the derivative of the number
   * @return gives the value of 0.0
   */
  @Override
  public Function derivative(){ 
    Number n = new Number(0.0);
    return n;
  }
}