package dbconnectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysqlConnect {

    public static void main(String args[]) {
	Connection con = null;
	String database = "mux";
	String dbAdmin = "mux";
	String password = "mux";

	try {
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    con = DriverManager.getConnection("jdbc:mysql:///" + database,
		    dbAdmin, password);

	    if (!con.isClosed())
		System.out.println("Successfully connected to "
			+ "MySQL server using TCP/IP...");

	} catch (Exception e) {
	    System.err.println("Exception: " + e.getMessage());
	} finally {
	    try {
		if (con != null)
		    con.close();
	    } catch (SQLException e) {
	    }
	}
    }
}