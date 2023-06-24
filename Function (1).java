/**
 * this class acts as the abstract class for the heirarchy that holds value and derivative methods
 * @author Izaiah Caston
 */
public abstract class Function{
  
  /**
   * Provides a value to the variable in a given function
   */
  abstract double value(double x);
  
  /**
   * Computes the derivative of the function
   */
  abstract Function derivative();

  /**
   * Provides a value for the operation with no variables
   */
  abstract double value();

}