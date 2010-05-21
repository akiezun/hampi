package hampi;

import hampi.constraints.*;

import java.util.Set;

/**
 * Common class for solver implementations.
 */
public abstract class AbstractSolver{

  private final String name;
  public boolean verbose = false;

  public AbstractSolver(String name){
    this.name = name;
  }

  /**
   * Find and return the solution. size is the size of the variable (in
   * characters).
   */
  public abstract Solution solve(Constraint c, int size);

  /**
   * Solve simple cases without using any encoding.
   */
  protected Solution trySimpleCases(Constraint c){
    for (Constraint conjunct : c.getConjuncts()){
      if (conjunct.getKind() == ElementKind.REGEXP_CONSTRAINT){
        RegexpConstraint reg = (RegexpConstraint) conjunct;
        if (reg.isMembership()){
          Expression expr = reg.getExpression();
          Regexp regexp = reg.getRegexp();
          //if the expression is necessarily longer than the regexp, stop right here
          if (expr.getSizeLowerBound() > regexp.getSizeUpperBound())
            return Solution.createUNSAT();
          //if the expression is necessarily shorter than the regexp, stop right here
          if (expr.getSizeUpperBound() < regexp.getSizeLowerBound())
            return Solution.createUNSAT();
        }
      }
    }
    return null;
  }

  /**
   * Check that no subsequence result should be outside the length of the solution
  Should not happen when using the Hampi parser, but can happen when creating the constaints
  using the Java API.
   *
   */
  protected boolean isValidSubsequencesLength(Constraint c, int size){
    for (Constraint conjunct : c.getConjuncts()){
      Set<SubsequenceExpression> subsequences = conjunct.getSubsequenceVals();
      for (SubsequenceExpression sub : subsequences){
        if (!sub.isValid(size))
          return false;
      }
    }
    return true;
  }

  /**
   * Returns the name of the solver.
   */
  public final String getName(){
    return name;
  }

  @Override
  public String toString(){
    return getName();
  }
}
