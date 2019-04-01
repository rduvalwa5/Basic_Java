package Network;
import java.net.*;
import java.io.*;


public class URIReader {
	
	public URIReader() {
		// TODO Auto-generated constructor stub
	}	

	public static void main(String[] args) throws URISyntaxException {
 //   public static void main(String[] args) throws Exception {
    String str = "http://randydlx:8080/paymentinstrument/CreditCard";
    URI CC = new URI(str);
//    CC.create(str);
	
//    URI CC = new URI("http://randydlx:8080/paymentinstrument/CreditCard");
	
	System.out.println(CC.getHost());
	System.out.println(CC.toASCIIString());
	
		}
}