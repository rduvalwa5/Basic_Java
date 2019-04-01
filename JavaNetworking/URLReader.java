package Network;
/**
 * @author rduvalwa2
 * This application reads in a html document and prints it out  
 *
 */
import java.net.*;
import java.io.*;


public class URLReader {
    public static void main(String[] args) throws Exception {
//    URL yahoo = new URL("http://randydlx:8080/paymentinstrument/CreditCard");
	URL yahoo = new URL("http://www.yahoo.com/");
	BufferedReader in = new BufferedReader(
				new InputStreamReader(
				yahoo.openStream()));

	String inputLine;

	while ((inputLine = in.readLine()) != null)
	    System.out.println(inputLine);

	in.close();
    }
}

