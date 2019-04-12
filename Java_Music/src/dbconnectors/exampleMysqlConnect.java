/*
 * https://howtodoinjava.com/java/jdbc/jdbc-mysql-database-connection-example/
 * https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html#connector-j-examples-connection-drivermanager
 * 
 *  mysql-connector-java-5.1.17-bin.jar
 * 	-------- MySQL JDBC Connection Demo ------------
 *	MySQL JDBC Driver Registered!
 *	SQL Connection to database established!
 *	Connection closed !!
 *
 * https://repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.45/
 * 		-------- MySQL JDBC Connection Demo ------------
 *		MySQL JDBC Driver Registered!
 *		Thu Apr 11 20:33:32 PDT 2019 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
 *		SQL Connection to database established!
 *		Connection closed !!
 */

package dbconnectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class exampleMysqlConnect {
    public static void main(String[] argv) {
 
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/Music", "rduval", "blu4jazz");
            System.out.println("SQL Connection to database established!");
 
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            return;
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}