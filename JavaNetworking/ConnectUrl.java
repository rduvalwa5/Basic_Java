package Network;
import java.net.*;
import java.io.*;


public class ConnectUrl {
    public static void main(String[] args) throws Exception {
    	String site = "http://www.bbc.com";
  	
        URL acs = new URL(site);
        BufferedReader input = new BufferedReader(new InputStreamReader(acs.openStream()));
        
        String line;
        while ((line = input.readLine()) != null)
        {
        	if (line.contains("href"))
        	{
        		System.out.println(line);
        	}
        }
        input.close();
    }
}