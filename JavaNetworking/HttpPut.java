package Network;
/*
 * reference links http://kickjava.com/996.htm
 */

/*
 * For a Java program to interact with a server-side process it simply must
 * be able to write to a URL, thus providing data to the server. 
 * It can do this by following these steps: 
 * 1  Create a URL. 
 * 2 Retrieve the URLConnection object. 
 * 3 Set output capability on the URLConnection. 
 * 4 Open a connection to the resource. 
 * 5 Get an output stream from the connection. 
 * 6 Write to the output stream. 
 * 7 Close the output stream
 */



import java.net.*;
import java.io.*;

public class HttpPut
{
 public static void main(String[] args) throws Exception
 {	
	String data = "data";
		    
		   URI ui1 = new URI ( "http://www.yahoo.com" ) ;
		   URI ui0 = new URI ( "http://www.gloooooogle.com" ) ;
		   
		   URI ui2 = new URI ( "http://www.allculinaryschools.com" ) ;
		   URI ui3 = new URI ("www.allculinaryschools.com/culinary-careers/community/culinary-institute-of-arts");
		   URI ui4 = new URI ("http://www.allculinaryschools.com/culinary-degree");
		   URI ui5 = new URI ("http://www.allculinaryschools.com/culinary-degree/all-degrees/culinary-management/north-dakota/jud?search=58454");
		   //
		   
		 //  URI ui = new URI ( "http://www.allbusinessschools.com" ) ;
		   URI x[] = {ui0,ui1,ui2,ui3,ui4,ui5};
		   for (int i = 0 ; i <  x.length; i++)
		   {   
		   URL u = x[4].toURL();
		   HttpURLConnection huc =  ( HttpURLConnection ) u.openConnection ( ) ; 
		   huc.setDoOutput(true);
		   huc.setRequestMethod ( "GET" ) ; 
		   huc.connect (  ) ;
		   
/*
 * Write data is for sending data
 */
		   
//		   OutputStreamWriter ow = new OutputStreamWriter(huc.getOutputStream());
//           ow.write(data);
//           ow.close();

           
        	try {	
        		BufferedReader in = new BufferedReader(		
		   new InputStreamReader(huc.getInputStream()));  //Create Input Stream and bind it to connection input
           /* 
            * Get Response code
            */
           int responseCode = huc.getResponseCode();
           System.out.println("Code is " + responseCode);
           if(responseCode == HttpURLConnection.HTTP_OK)
           {
    		 String decodedString;
             while ((decodedString = in.readLine()) != null) 
             {
             System.out.println("InputStream is: " + decodedString);
             }
             in.close();
             
  		   	 int code = huc.getResponseCode (  ) ; 
  		     String response = huc.getResponseMessage();
  		     System.out.println("Return Code is " + code);
  		     System.out.println("Response is: " + response);
  		   
  		   int fieldNum = 0;
  		   while (huc.getHeaderField(fieldNum) != null)
  		   {
  		    System.out.println("Field Num is: " + fieldNum + " " + huc.getHeaderField(fieldNum));
  		    fieldNum ++;
  		   }
  
           }
        	   
        	}		 catch  ( IOException e )   {  
        	System.out.println("Code is " + huc.getResponseCode());
        	System.out.println("Exception is " + e.toString());
   		 }
		   
		   huc.disconnect () ; 
		  }  
         }
}
