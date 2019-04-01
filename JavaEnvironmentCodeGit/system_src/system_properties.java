package system_src;

//import System;

public class system_properties {
	
	static void copy_array() 
	/*
	 * arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
	 * five
	 * two
	 * three
	 * eight
	 */
	{
		String arrayString [] = {"one","two","three","four"};
		String arrayString2 [] = {"five","six","seven","eight"};
		int arrayInt [] = {1,2,3,4,5,6,7,8,9};
		
		java.lang.System.arraycopy(arrayString, 1, arrayString2, 1, 2);
		for(String item:arrayString2 ) {
			java.lang.System.out.println(item);
		}
		
	}



//For test    
public static void main(String[] args) {
	system_properties ex = new system_properties();
	ex.copy_array();
	
}}