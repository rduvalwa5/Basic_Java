
public class JArrayExamples
{
//	private String[] toppings;
	private String[] toppings = new String[20];
//    private String[10] toppings = {"Cheese", "Pepperoni", "Black Olives"};
	

    
    
    private int[] nums = {1,2,3,4,5,6,7,8,9};

 
    /*
     * old `for` loop
     */
    public void JavaStringArray()
    {
    		    toppings[0] = "Cheese";
    		    toppings[1] =  "Pepperoni";
    		    toppings[2] =  "Black Olives";
    		    toppings[4] = "Mushroom";
    		    toppings[5] =  "Garlic";
    		    toppings[6] =  "Sassage";
    		    toppings[7] = "Tomatoes";
    		    toppings[8] =  "Anchovies";
    		    toppings[19] =  "Frogs";
    		
        int size = toppings.length;
        for (int i=0; i<size; i++)
        {
            System.out.println("Number " + i + "  topping " + toppings[i]);
        }
    }
    /*
     * Java 5 way to iterate
     */
    public void JavaIntArray()
    {
        for (int i: nums)
        {
          System.out.print(i);
        }
    }

// main kicks everything off.
// create a new instance of our class here.
    public static void main(String[] args)
    {
    	JArrayExamples a = new JArrayExamples();
    	a.JavaStringArray();
    	a.JavaIntArray();
        
    } 
}
