package hampi.tests.parser;

import hampi.parser.*;
import junit.framework.TestCase;

public class HampiWellFormednessTests extends TestCase{
  private static final String P = HampiParsingTests.HAMPI_EXAMPLE_DIR;

  private void checkFail(String path, String reason) throws Exception{
    HProgram ast = HProgramParser.parse(P + path);
    assertNotNull(ast);
    String checkWellFormedness = HProgramParser.checkWellFormedness(ast);
    if (checkWellFormedness == null){
      fail("expected to fail well-formedness test " + reason + "  " + path);
    }
  }

  private void checkPass(String path) throws Exception{
    HProgram ast = HProgramParser.parse(P + path);
    assertNotNull(ast);
    HProgramParser.checkWellFormedness(ast);
  }

  public void testZeroVars() throws Exception{
    checkFail("testVar0.txt", "zero variables");
  }

  public void testTwoVars() throws Exception{
    checkFail("testVar2.txt", "two variables");
  }

  public void testNoAsserts() throws Exception{
    checkFail("testNoAsserts.txt", "no asserts");
  }

  public void testNamesDefined1() throws Exception{
    checkFail("testNamesDefined1.txt", "all nonterminals defined");
  }

  public void testNamesDefined2() throws Exception{
    checkFail("testNamesDefined2.txt", "all names defined");
  }

  public void testNamesDefined3() throws Exception{
    checkFail("testNamesDefined3.txt", "all names defined");
  }

  public void testNamesDefined4() throws Exception{
    checkFail("testNamesDefined4.txt", "all names defined");
  }

  public void testNamesDefined5() throws Exception{
    checkFail("testNamesDefined5.txt", "all names defined");
  }

  public void testNonterminalsDefinedOnce() throws Exception{
    checkFail("testNonterminalsDefinedOnce.txt", "all nonterminals defined once");
  }

  public void testNonterminals() throws Exception{
    checkFail("testNonterminals.txt", "cfg rules use only noterminals");
  }

  public void testTypecheck() throws Exception{
    checkFail("testTypecheck.txt", "not cfg used in fix");
  }

  public void testTypecheck1() throws Exception{
    checkFail("testTypecheck1.txt", "not reg used in 'in'");
  }

  public void testTypecheckFul() throws Exception{
    checkPass("exampleFull.text");
  }

  public void testTypecheck2() throws Exception{
    checkPass("testTypecheck2.txt");
  }

  public void testTypecheck3() throws Exception{
    checkPass("testTypecheck3.txt");
  }

  public void testTypecheck4() throws Exception{
    checkPass("testTypecheck4.text");
  }

}
