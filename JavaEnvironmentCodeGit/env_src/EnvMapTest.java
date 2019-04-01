import junit.framework.TestCase;
/**
 * 
 *
 * @author
*/
 
class envMapTest extends TestCase {

    protected void setUp() {
	  
       String [] TestArguments = {"LOGNAME", "LANG" ,"USER", "ANT_HOME"};   
    }

    public void testgetUserEnv() {
        EnvMap A = new EnvMap();
        
        System.out.println( A("USER"));
 //       assertEquals(4,A.getCharInstances());
	
       }
/*
    public void testgetCharInstancesOne() {
	
    	TestString = ( "'");   
        StringCleaner2 A = new StringCleaner2(TestString);
        int COUNT = A.getCharInstances();
        System.out.println("Instances = " + COUNT);
        assertEquals(1,A.getCharInstances());
	
       }

    public void testgetCharInstancesNone() {
    	
    	TestString = ( "I don`t liike this.....");   
        StringCleaner2 A = new StringCleaner2(TestString);
        int COUNT = A.getCharInstances();
        System.out.println("Instances = " + COUNT);
        assertEquals(0,A.getCharInstances());
        	
       }
  

    public void testForException() { 
          try { 
               TestString = null;   
               StringCleaner2 A = new StringCleaner2(TestString); 
               fail("Should raise an NullPointerException");
          } 
          catch (NullPointerException success) {
        	  System.out.println("Exception: " + success.getMessage());
          } 
     } 
   
    protected void tearDown() { 
        TestString = null; 
   } 
*/
}

