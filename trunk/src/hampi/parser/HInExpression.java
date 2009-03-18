package hampi.parser;

import hampi.HampiException;
import hampi.parser.HProgramParser.HTypeEnvironment;

public final class HInExpression extends HBooleanExpression{

  private final String  id1;
  private final String  id2;
  private final boolean in;

  public HInExpression(String id1, String id2, boolean in){
    super(HGrammarElementKind.BEXPR_IN);
    this.id1 = id1;
    this.id2 = id2;
    this.in = in;
  }

  public String getVarName(){
    return id1;
  }

  public String getRegVarName(){
    return id2;
  }

  public boolean isIn(){
    return in;
  }

  @Override
  public String unparse(){
    return id1 + (in ? "" : " not") + " in " + id2;
  }

  @Override
  public void typeCheck(HTypeEnvironment tenv){
    if (tenv.getType(id1) != HType.STRING_TYPE)
      throw new HampiException("extected string type on left in 'in' : " + tenv.getType(id1));
    if (tenv.getType(id2) != HType.REG_TYPE)
      throw new HampiException("extected reg type on left in 'in' : " + tenv.getType(id2));
  }

  @Override
  public void accept(HGrammarVisitor v){
    v.visitInExpression(this);
  }
}
