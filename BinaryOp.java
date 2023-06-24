/** 
 * this class represents a function with simple binary operations
 * @author Izaiah Caston
 */
public class BinaryOp extends Function{
  
  /**variable to hold right operand*/
  private Function rightOp;
  
  /**variable to hold the left operand*/
  private Function leftOp;
  
  /**variable to hold symbol*/
  private Op symbol;
  
   /**
   * creates an instance of BinaryOp with operands and operator symbol
   * @param the operator symbol 
   * @param the left operand 
   * @param the right operand
   */
  public BinaryOp(Op symbol, Function leftOp, Function rightOp){
    this.symbol = symbol;
    this.leftOp = leftOp;
    this.rightOp = rightOp;
  }
  
  /**
   * This enum represents mathematical operations such as addition, subtraction, multiplication, and division.
   */ 
  enum Op{
    PLUS("+"), SUB("-"), MULT("*"), DIV("/"); 
    
    /** the operand that is in the equation */
    private final String oper;
    
    /** 
     * the operator in the function
     * @param the operator in a string
     */
    private Op(String oper){
      this.oper = oper;
    }
    
    /**
     * The operator being used
     * @return the operator being used
     */
    public String getOper(){
      return oper; 
    }
  }
  
  /**
   * returns the operator symbol
   * @return the operator symbol
   */
  public Op getOperator(){
    return symbol;
  }
  
  /**
   * gives the left operand in the function
   * @return the left operand in the function
   */
  public Function getLeftOperand(){
    return leftOp; 
  }
  
  /**
   * gives the right operand in the function
   * @return the right operand in the function
   */
  public Function getRightOperand(){
    return rightOp; 
  }
  
  /**
   * changes the variable value in the function to the input param, and returns the completed expression
   * @param double value for the variable
   * @return the value that the expression would give after the math
   */
  @Override
  public double value(double x){  
    if(getOperator() == Op.PLUS){
      return getLeftOperand().value(x) + getRightOperand().value(x);
    }
    else if(getOperator() == Op.SUB){
      return getLeftOperand().value(x) - getRightOperand().value(x); 
    }
    else if(getOperator() == Op.MULT){
      return getLeftOperand().value(x) * getRightOperand().value(x); 
    }
    else{
      return getLeftOperand().value(x) / getRightOperand().value(x); 
    }
  }
  
  /**
   * does the derivative of the function that is inputed
   * @return gives the string representation of the derivative
   */
  @Override
  public Function derivative(){ 
    if(getOperator() == Op.PLUS){
      return new BinaryOp(BinaryOp.Op.PLUS, getLeftOperand().derivative() , getRightOperand().derivative());
    }
    else if(getOperator() == Op.SUB){
      return new BinaryOp(BinaryOp.Op.SUB, getLeftOperand().derivative() , getRightOperand().derivative());
    }
    else if(getOperator() == Op.MULT){
      return new BinaryOp(BinaryOp.Op.PLUS, 
                          new BinaryOp(BinaryOp.Op.MULT, getLeftOperand(), getRightOperand().derivative()), 
                          new BinaryOp(BinaryOp.Op.MULT, getLeftOperand().derivative(), getRightOperand()));
    }
    else if(getOperator() == Op.DIV){
      return new BinaryOp(BinaryOp.Op.DIV, 
                          new BinaryOp(BinaryOp.Op.SUB, new BinaryOp(BinaryOp.Op.MULT, getRightOperand(), getLeftOperand().derivative()), 
                                       new BinaryOp(BinaryOp.Op.MULT, getLeftOperand(), getRightOperand().derivative())), 
                          new BinaryOp(BinaryOp.Op.MULT, getRightOperand(), getRightOperand()));
    }
    return null;  
  }

  /**
   * throws an exception when trying to use value with no parameter
   * Computes the value of the function if there are no variables
   * @return UnsupportedOperationException
   */
  @Override
  public double value() {
    if (getOperator() == Op.PLUS) {
      return getLeftOperand().value() + getRightOperand().value();
    } else if (getOperator() == Op.SUB) {
      return getLeftOperand().value() - getRightOperand().value();
    } else if (getOperator() == Op.MULT) {
      return getLeftOperand().value() * getRightOperand().value();
    } else if (getOperator() == Op.DIV) {
      return getLeftOperand().value() / getRightOperand().value();
    } else {
      throw new UnsupportedOperationException("This operation is not supported");
    }
  }
 
  /**
   * compares whether or not two objects are both BinaryOp instances
   * @param the object being compared
   * @return true or false
   */
  @Override
  public boolean equals(Object x){
    if(x instanceof BinaryOp){
      BinaryOp n = (BinaryOp)x;
      return this.getOperator().equals(n.getOperator()) && this.getLeftOperand().equals(n.getLeftOperand()) 
        && this.getRightOperand().equals(n.getRightOperand());
    }
    else{
      return false;
    }
  }
  
  /**
   * returns the BinaryOp function as a string representations
   * @return gives the string representation of the BinaryOp instance
   */
  @Override
  public String toString(){
    //Branch for PLUS operations
    if(getOperator() == Op.PLUS){
      if(getLeftOperand() instanceof BinaryOp && getRightOperand() instanceof BinaryOp){
        return "(" + getLeftOperand() + ")" + " + " + "(" + getRightOperand() + ")";
      }
      else if(getRightOperand() instanceof BinaryOp && !getRightOperand().toString().contains("+")){
        return getLeftOperand() + " + " + "(" + getRightOperand() + ")"; 
      }
      else if(getLeftOperand() instanceof BinaryOp){
        return "("+ getLeftOperand() +")" + " + " + getRightOperand(); 
      }
      else{
        return getLeftOperand() + " + " +  getRightOperand(); 
      }
    }
    //Branch for SUB operations
    else if(getOperator() == Op.SUB){
      if(getLeftOperand() instanceof BinaryOp && getRightOperand() instanceof BinaryOp){
        return "(" + getLeftOperand() + ")" + " - " + "(" + getRightOperand() + ")";
      } 
      else if(getRightOperand() instanceof BinaryOp && !getRightOperand().toString().contains("-")){
        return getLeftOperand() + " - " + "(" + getRightOperand() + ")"; 
      }
      else if(getLeftOperand() instanceof BinaryOp){
        return "("+ getLeftOperand() +")" + " - " + getRightOperand(); 
      } 
      else{
        return getLeftOperand() + " - " +  getRightOperand(); 
      }
    }
    //Branch for MULT operations
    else if(getOperator() == Op.MULT){
      if(getLeftOperand() instanceof BinaryOp && getRightOperand() instanceof BinaryOp){
        return "(" + getLeftOperand() + ")" + " * " + "(" + getRightOperand() + ")";
      }
      else if(getRightOperand() instanceof BinaryOp && !getRightOperand().toString().contains("*")){
        return getLeftOperand() + " * " + "(" + getRightOperand() + ")"; 
      }
      else if(getLeftOperand() instanceof BinaryOp){
        return "("+ getLeftOperand() +")" + " * " + getRightOperand(); 
      }
      else{
        return getLeftOperand() + " * " +  getRightOperand(); 
      }
    }
    //Branch for DIV operations
    else if(getOperator() == Op.DIV){
      if(getLeftOperand() instanceof BinaryOp && getRightOperand() instanceof BinaryOp){
        return "(" + getLeftOperand() + ")" + " / " + "(" + getRightOperand() + ")";
      }
      else if(getRightOperand() instanceof BinaryOp && !getRightOperand().toString().contains("/")){
        return getLeftOperand() + " / " + "(" + getRightOperand() + ")"; 
      }
      else if(getLeftOperand() instanceof BinaryOp){
        return "("+ getLeftOperand() +")" + " / " + getRightOperand(); 
      }
      else{
        return getLeftOperand() + " / " +  getRightOperand(); 
      }
    }    
    return null;
  }  
}










