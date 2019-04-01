package env_get;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGetEnv {

	@Test
	public void testGetEnvUSER() {
		EnvGet A = new EnvGet();
        System.out.println( A.getEnv("USER"));
        assertEquals("USER=rduvalwa2",A.getEnv("USER"));
	
	}

	@Test
	public void testGetEnvNullPointer() {
		EnvGet A = new EnvGet();
        System.out.println( A.getEnv("user"));
        assertEquals("user=java.lang.NullPointerException",A.getEnv("user"));
	
	}
}
