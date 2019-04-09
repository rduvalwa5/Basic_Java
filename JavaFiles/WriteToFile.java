package Files;

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile { 
  public static void main(String[] args) { 
	  File myObj = new File("/Users/rduvalwa2/java-workspace/JavaFiles/src/Files/filename.txt");
    try { 
      FileWriter myWriter = new FileWriter(myObj);
      myWriter.write("Files in Java might be tricky, but it is fun enough!");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  } 
}