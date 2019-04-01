package system_src;

import static org.junit.Assert.*;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class TestSystemProperties {
	@Test
	public void testCopyArray() {
		system_properties_examples sys = new system_properties_examples();
		String arrayString [] = {"one","two","three","four"};
		String arrayString2 [] = {"five","six","seven","eight"};
		int ar1Int = 2;
		int ar2Int = 1;
		int numElements = 2;
		String [] expected = {"five","three","four","eight"}; //"fivethreefoureight";
		String [] actual = sys.copy_array(arrayString,ar1Int, arrayString2, ar2Int, numElements);
		assertArrayEquals(expected,actual);		
	}

	@Test
	public void testGetSysProperties() {
		system_properties_examples sys = new system_properties_examples();
		Map<String,String> mProps = sys.get_sys_properties();
		int expected = 55;
		int actual = mProps.size();
		assertEquals("get sys properties failed", expected, actual);
	}
	
	@Test
	public void testGetSysProperty() {
		system_properties_examples sys = new system_properties_examples();
		String expected = "user.name=rduvalwa2";
		String actual = sys.get_sys_property("user.name");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetSystemProperty() {
		system_properties_examples sys = new system_properties_examples();
		sys.set_sys_property("me", "reddog");
		String expected = "me=reddog";
		String actual = sys.get_sys_property("me");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testClearSystemProperty() {
		system_properties_examples sys = new system_properties_examples();
		sys.clear_property("me");
		String expected = "me=java.lang.NullPointerException";
		String actual = sys.get_sys_property("me");
		assertEquals(expected, actual);
	}
}
