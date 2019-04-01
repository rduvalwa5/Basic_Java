//java EnvParm3 BASE_DIR SEARCH_DIR
//javac -deprecation EnvParm3.java
// this code is for java 1.4.2_x
// getProperty method is restricted to the java property variables
// java version 6 gets system environment properties


import java.util.Map;
import java.util.*;

public class EnvParm3
{
 public static void main (String[] args)
 {
     System.out.println(args[0]);       
     System.out.println(args[1]);
     System.setProperty(args[2],args[0]);
     System.setProperty(args[3],args[1]);
     System.out.println("args length is " + args.length);  
     for(int i = 2; i < args.length; i++)      
     {
	 System.out.println("i is " + i);
//FindDir = ("C:\\Music Test\\" + Genre + "\\" +Artist + "\\" + Album);
	 String env = (args[i]);
	 System.out.println("env is " + env);  
       String value = System.getProperty(env);
       System.out.println("value is " + value);  
	 System.out.println("args[" + i + "]" + " is " + args[i]);  
	 if (value != null)
	  {
	   System.out.println(env + " = " + value);
	   i++;
	  }
	  else
          {
		System.out.println(env + " is not assigned.");
		i++;
          }
      }
  }
}



/*
$ java EnvParm3 "$BASE_DIR" "$SEARCH_DIR" BASE_DIR SEARCH_DIR
C:\Music Test
H:\Music Test
args length is 4
i is 2
env is BASE_DIR
value is C:\Music Test
args[2] is BASE_DIR
BASE_DIR = C:\Music Test

*/