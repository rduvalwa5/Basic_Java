package DbConnectors.test;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DbConnectors.MysqlConnection;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class MysqlConnectionTest {

    private static String defaultPort = "3306";
    private static String defaultServer = "localhost"; // c1246895-osx2
						       // c1246895-osx2.ftrdhcpuser.net
    private static String defaultDatabase = "mysql";
    private static String defaultDba = "root"; // "rduval";
    private static String defaultPwd = "reddog"; // "root";

    private static String newPort = "6033";
    private static String newServer = "c1246895-osx2";
    private static String newDatabase = "mux";
    private static String newDba = "rduval";
    private static String newPwd = "root";
    private MysqlConnection myConnection;
    private static Connection connection;

    @Before
    public void setUp() {
	myConnection = new MysqlConnection();
    }

    @After
    public void tearDown() throws Exception {

	if (connection != null)
	    try {
		connection.close();
		System.out.println("Database connection terminated");
	    } catch (Exception e) {
		System.err.println(e.getMessage());
	    }
	myConnection = null;
    }

    /*
     * Test that default values are set
     */

    @Test
    public void testGetDefaultPort() {
	Assert.assertEquals(defaultPort, myConnection.getPort());
    }

    @Test
    public void testGetDefaultServer() {
	Assert.assertEquals(defaultServer, myConnection.getServer());
    }

    @Test
    public void testGetDefaultDatabase() {
	Assert.assertEquals(defaultDatabase, myConnection.getDatabase());
    }

    @Test
    public void testGetDefaultDba() {
	Assert.assertEquals(defaultDba, myConnection.getDba());
    }

    @Test
    public void testGetDefaultPwd() {
	Assert.assertEquals(defaultPwd, myConnection.getPwd());
    }

    @Test
    public void testSetPort() {
	myConnection.setPort(newPort);
	Assert.assertEquals(newPort, myConnection.getPort());
    }

    @Test
    public void testSetServer() {
	myConnection.setServer(newServer);
	Assert.assertEquals(newServer, myConnection.getServer());
    }

    @Test
    public void testSetDatabase() {
	myConnection.setDatabase(newDatabase);
	Assert.assertEquals(newDatabase, myConnection.getDatabase());
    }

    @Test
    public void testSetDba() {
	myConnection.setDba(newDba);
	Assert.assertEquals(newDba, myConnection.getDba());
    }

    @Test
    public void testSetPwd() {
	myConnection.setPwd(newPwd);
	Assert.assertEquals(newPwd, myConnection.getPwd());
    }

    @Test
    public void testGetConnection() throws CommunicationsException {
	myConnection.setDatabase("mysql");
	myConnection.setPort("3306");
	myConnection.setPwd("reddog");
	myConnection.setServer("localhost");
	myConnection.setDba("root");
	connection = myConnection.getConnection();
	Assert.assertNotNull(connection);
    }

    @Test
    public void testGetMysqlJDBCConnection() {
	myConnection.setDatabase("mysql");
	myConnection.setPort("3306");
	myConnection.setPwd("reddog");
	myConnection.setServer("localhost");
	myConnection.setDba("root");
	try {
	    connection = myConnection.getConnection();
	} catch (SQLException ex) {
	    System.err.println("SQLException: " + ex.getMessage());

	    Assert.assertNotNull(connection);
	}
    }
}
