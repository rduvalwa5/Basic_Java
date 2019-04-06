/*
 * https://docs.oracle.com/javase/tutorial/essential/environment/env.html
 */


import java.util.Map;

public  class EnvGet {
//    public static void main (String[] args) {
	public String getEnv(String inp) {
    		String envName = inp;
    		String output;
//    		System.out.println("inp " + inp);
        Map<String, String> env = System.getenv();
        try {
        	String result = env.get(inp);
//        	System.out.println("result "+ result);
        	output = inp.concat("=").concat(result);
//        System.out.println("output " + output);
        }
        catch (java.lang.NullPointerException exception) {
        	output = inp.concat("=").concat("java.lang.NullPointerException");
        }
        return output;
	}
	
	
//For test    
public static void main(String[] args)
    {   
		String envVar = "PATH";
		String envVar2 = "user";
		EnvGet env = new EnvGet();
		String resultEnvar = env.getEnv(envVar);
		System.out.println(resultEnvar);
		String resultEnvar2 = env.getEnv(envVar2);
		System.out.println(resultEnvar2);	    
    }}
/*
    USER=rduvalwa2
	user=java.lang.NullPointerException
 */


