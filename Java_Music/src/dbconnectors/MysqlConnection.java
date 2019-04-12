package dbconnectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.CommunicationException;

public class MysqlConnection {

    private static String port = "3306";
    private static String server = "localhost"; // c1246895-osx2
						// //c1246895-osx2.ftrdhcpuser.net
    private static String database = "Music";
    private static String dba = "rduval"; // "rduval";
    private static String pwd = "blu4jazz"; // "root";

    public void setPort(String iPort) {
	port = iPort;
    }

    public String getPort() {
	return port;
    }

    public void setServer(String iServer) {
	server = iServer;
    }

    public String getServer() {
	return server;
    }

    public void setDatabase(String iDatabase) {
	database = iDatabase;
    }

    public String getDatabase() {
	return database;
    }

    public void setDba(String iDba) {
	dba = iDba;
    }

    public String getDba() {
	return dba;
    }

    public void setPwd(String iPwd) {
	pwd = iPwd;
    }

    public String getPwd() {
	return pwd;
    }
    
    /*
     * Two different implementations
	*/
    public Connection getConnection(){
	Connection conn = null;
	try {
	    // String url = "jdbc:mysql://localhost/mysql";
	    String url = "jdbc:mysql://" + server + ":" + port + "/" + database;
	    System.err.println("URL is " + url);
	    // String url = "jdbc:mysql://" + server + "/" + database;
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    conn = DriverManager.getConnection(url, dba, pwd);
	    System.out.println("Database connection established");
	} catch (Exception e) {
	    System.err.println("Cannot connect to database server");
	    System.err.println(e.getMessage());
	    System.err.println(e.toString());
	}
	return conn;
    }

    public static Connection getMysqlJDBCConnection(){
	Connection conn = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	} catch (java.lang.ClassNotFoundException e) {
	    System.err.print("Exception: ");
	    System.err.println(e.getMessage());
	}
	try {
	    String url = "jdbc:mysql://" + server + "/" + database;
	    conn = DriverManager.getConnection(url, dba, pwd);

	} catch (SQLException ex) {
	    System.err.println("SQLException: " + ex.getMessage());
	}
	return conn;
    }

    public static void main(String[] argv) {
    	 
        System.out.println("-------- MySQL JDBC  ------------");
        MysqlConnection xconn = new MysqlConnection();
        System.out.println(xconn.getClass());
        System.out.println(xconn.getConnection());
        System.out.println(xconn.getMysqlJDBCConnection());   
        System.out.println(xconn.server + " " + xconn.getDatabase());
        System.out.println(xconn.getDba());
        
}}
