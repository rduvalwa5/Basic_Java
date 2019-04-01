package env_get;
//java EnvParm2 BASE_DIR SEARCH_DIR
//javac EnvParm2.java

import java.util.Map;

public class EnvParm2 {
    public static void main (String[] args) {
      int i = 0;
	for (String env: args) {
        String value = System.getenv(env);
	  System.out.println("Arument " + i + " is " + args[i]);  
	  if (value != null) {
	   System.out.format("%s=%s%n", env, value);
	   i++;
	    }
	   else {
		System.out.format("%s is not assigned.%n", env);
		i++;
          }
        }
    }
}
