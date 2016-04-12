package Utils;
import java.io.*;

public class IOfile
{

   public static BufferedReader readFile(String filename)
   {
      try{
	FileReader fileIn = new FileReader(filename);
	BufferedReader in = new BufferedReader(fileIn);
	return in;
      }catch(IOException e)
      {
	System.err.println(e.getMessage());
      }
      return null;
   }

   public static BufferedWriter writeFile(String filename)
   {
      try{
	FileWriter fileOut = new FileWriter(filename);
	BufferedWriter bufOut = new BufferedWriter(fileOut);
	return bufOut;
      }catch(IOException e)
      {
	System.err.println(e.getMessage());
      }
      return null;
   }
}
