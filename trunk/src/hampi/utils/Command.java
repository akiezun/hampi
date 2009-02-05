/*******************************************************************************
 * The MIT License
 * 
 * Copyright (c) 2008 Shay Artzi, Adam Kiezun, Noam Shomron.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 ******************************************************************************/
package hampi.utils;

import java.io.*;
import java.util.concurrent.CountDownLatch;

/**
 * The important method in this class is <code>exec(String[])</code>. It
 * executes its argument and pipes both stdout and stderr to System.out. Each
 * line in the piped output from stdout is prefixed with "OUT>" and the output
 * from stderr is prefixed with "ERR>"
 * 
 * <p>
 * Credit: Producer code modified (and augmented) from Michael Daconta's "Java
 * Traps" column ("When Runtime.exec() won't"), found at
 * http://www.javaworld.com/javaworld/jw-12-2000/jw-1229-traps.html
 */
public class Command{

  public static void runCommand(String[] command, String prompt, boolean verbose, String nonVerboseMessage, boolean gobbleChars){

    runCommand(command, prompt, verbose, nonVerboseMessage, false, gobbleChars);
  }

  public static void runCommandOKToFail(String[] command, String prompt, boolean verbose, String nonVerboseMessage, boolean gobbleChars){

    runCommand(command, prompt, verbose, nonVerboseMessage, true, gobbleChars);
  }

  public static void runCommand(String[] command, String prompt, boolean verbose, String nonVerboseMessage, boolean okToFail, boolean gobbleChars){

    System.out.println(nonVerboseMessage);

    ByteArrayOutputStream out = null;
    int exitFlag = 0;

    if (verbose){
      exitFlag = Command.exec(command, System.out, prompt, gobbleChars);
    }else{
      out = new ByteArrayOutputStream();
      exitFlag = Command.exec(command, new PrintStream(out), prompt, gobbleChars);
    }

    if (!okToFail && exitFlag != 0)
      throw new Error("Non-zero exit flag when running command " + java.util.Arrays.toString(command) + "\n" + (verbose ? "" // already
      // output
          // to
          // System.out
          : " output: " + String.valueOf(out)));
  }

  /**
   * Helper class for Command. A StreamGobbler thread is Responsible for
   * redirecting an InputStream, prefixing its redirected output with a
   * user-specified String (see construtors for more details).
   * 
   */
  public static class StreamGobbler extends Thread{
    InputStream    is;

    String         type;

    OutputStream   os;

    PrintStream    out;

    boolean        gobbleChars;

    CountDownLatch doneSignal;

    /**
     * Redirects `is' to out, prefixing each line with the String `type'.
     * 
     * @param doneSignal
     */
    StreamGobbler(InputStream is, String type, PrintStream out, CountDownLatch doneSignal, boolean gobbleChars){
      this(is, type, null, out, doneSignal, gobbleChars);
    }

    /*
     * Redirects `is' to out and also to `redirect' (that is, the input from
     * `is' is duplicated to both streams), prefixing each line with the String
     * `type'.
     */
    StreamGobbler(InputStream is, String type, OutputStream redirect, PrintStream out, CountDownLatch done, boolean gobbleChars){
      this.is = is;
      this.type = type;
      this.os = redirect;
      this.out = out;
      this.doneSignal = done;
      this.gobbleChars = gobbleChars;
    }

    @Override
    public void run(){
      try{
        PrintWriter pw = null;
        if (os != null){
          pw = new PrintWriter(os, true);
        }

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        try{
          if (gobbleChars){
            char[] oneChar = new char[1];
            while (br.read(oneChar, 0, 1) != -1){
              char c = oneChar[0];
              if (pw != null){
                pw.print(c);
              }
              out.print(oneChar[0]);
            }
          }else{
            String line = null;
            while ((line = br.readLine()) != null){
              if (pw != null){
                pw.println(line);
              }
              out.println(type + line);
            }
          }
          if (pw != null){
            pw.flush();
          }
        }finally{
          doneSignal.countDown();
          br.close();
        }
      }catch (IOException ioe){
        ioe.printStackTrace();
      }
    }
  }

  public static String[] tokenize(String s){
    if (s.length() == 0)
      throw new IllegalArgumentException("Empty command");
    return s.split(" ");
  }

  /**
   * Runs cmd.
   */
  public static int exec(String cmd, PrintStream out){
    return exec(tokenize(cmd), out);
  }

  /**
   * Runs cmd, redirecting stdout and stderr to System.out.
   */
  public static int exec(String cmd){
    return exec(tokenize(cmd), System.out);
  }

  /**
   * Runs cmd, redirecting stdout and stderr to System.out.
   */
  public static int exec(String[] cmd){
    return exec(cmd, System.out);
  }

  /**
   * Runs cmd, redirecting stdout and stderr to `out' and prefixing the output
   * from stout with "OUT>" and the output from stderr with "ERR>".
   * 
   * Returns whatever exit number is returned by the subprocess invoking the
   * command.
   */
  // public static int exec(String cmd, PrintStream out) {
  // return exec(cmd, out, new File(System.getProperty("user.dir")));
  // }
  public static int exec(String[] cmd, PrintStream out){
    return exec(cmd, out, "");
  }

  public static int exec(String[] cmd, PrintStream out, String prompt){
    return exec(cmd, out, prompt, false);
  }

  public static int exec(String[] cmd, PrintStream out, String[] env){
    return exec(cmd, out, "", env);
  }

  private static int exec(String[] cmd, PrintStream out, String prompt, String[] env){
    return exec(cmd, out, prompt, false, env);
  }

  public static int exec(String[] cmd, PrintStream out, String prompt, boolean gobbleChars){
    return exec(cmd, out, prompt, gobbleChars, new String[0]);
  }

  public static int exec(String[] cmd, PrintStream out, Reader stdin){
    int exitVal;
    try{
      Runtime rt = Runtime.getRuntime();
      Process proc = rt.exec(cmd);

      OutputStream outputStream = proc.getOutputStream();
      int c = stdin.read();
      while (c != -1){
        outputStream.write(c);
        c = stdin.read();
      }
      outputStream.close();

      CountDownLatch doneSignal = new CountDownLatch(2);

      // any error message?
      StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "", out, doneSignal, false);

      // any output?
      StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "", out, doneSignal, false);

      // kick them off
      errorGobbler.start();
      outputGobbler.start();

      doneSignal.await();
      exitVal = proc.waitFor();
      out.flush();
    }catch (Throwable t){
      throw new RuntimeException(t); // CP improve
    }
    return exitVal;
  }

  public static int exec(String[] cmd, PrintStream out, String prompt, boolean gobbleChars, String[] env){
    int exitVal;
    try{
      Runtime rt = Runtime.getRuntime();
      Process proc = rt.exec(cmd, env);

      CountDownLatch doneSignal = new CountDownLatch(2);
      if (out != null){
        // any error message?
        StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), prompt, out, doneSignal, gobbleChars);

        // any output?
        StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), prompt, out, doneSignal, gobbleChars);

        // kick them off
        errorGobbler.start();
        outputGobbler.start();
      }else{
        doneSignal.countDown();
        doneSignal.countDown();
      }
      exitVal = proc.waitFor();
      doneSignal.await();
    }catch (Throwable t){
      throw new RuntimeException(t); // CP improve
    }
    return exitVal;
  }

}
