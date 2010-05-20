package hampi.constraints;

import hampi.Solution;

import java.util.Set;

public class SubsequenceExpression extends Expression{
  private final Expression expr;
  private final int fromIndex;
  private final int len;

  public SubsequenceExpression(Expression expr, int fromIndex, int len){
    super(ElementKind.SUBSEQUENCE_EXPRESSION);
    this.expr = expr;
    this.fromIndex = fromIndex;
    this.len = len;
  }

  @Override
  public boolean equals(Object obj){
    if (!(obj instanceof SubsequenceExpression))
      return false;
    SubsequenceExpression that = (SubsequenceExpression) obj;
    return that.expr.equals(this.expr) && that.fromIndex == this.fromIndex && that.len == this.len;
  }

  @Override
  public int getSizeLowerBound(){
    return getSizeUpperBound();
  }

  @Override
  public int getSizeUpperBound(){
    return len;
  }

  @Override
  public String getValue(Solution solution){
    return expr.getValue(solution).substring(fromIndex, fromIndex + len);
  }

  @Override
  public Set<VariableExpression> getVariables(){
    return expr.getVariables();
  }

  @Override
  public int hashCode(){
    return expr.hashCode() + 7 * (fromIndex + len);
  }

  @Override
  public String toJavaCode(String hampiVar){
    return hampiVar + ".subsequenceExpr(\"" + expr.toJavaCode(hampiVar) + "," + fromIndex + "," + len + "\")";
  }

  @Override
  public String toString(){
    return expr.toString() + "[" + fromIndex + "," + len + "]";
  }

  @Override
  public void accept(ConstraintGrammarVisitor visitor){
    expr.accept(visitor);
    visitor.visitSubsequenceExpression(this);
  }

  public int getLength(){
    return len;
  }

  public int getStartIndex(){
    return fromIndex;
  }

}
