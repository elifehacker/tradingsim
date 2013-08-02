import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Dbconnect {

	/**
	 * @param args
	 */
	String userName;
	String password;
	String dbms;
	String dbName;
	
	public Dbconnect(String u, String p, String ms, String name){
		userName = u;
		password = p;
		dbms = ms;
		dbName = name;
	}
	
	
	public Connection getConnection() throws SQLException {

	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);

        conn = DriverManager.getConnection(
                   "jdbc:" + this.dbms +
                   this.dbName +
                   ";create=true",
                   connectionProps);

        System.out.println("Connected to database");
	    return conn;
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Dbconnect dc = new Dbconnect("user", "123", "derby:C:\\Users\\Pei Wang\\workspace\\TradingSimulator\\", "tradingDB");
		Connection conn = dc.getConnection();
		
	}
}
