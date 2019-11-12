package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBUtils 
{
	public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException
	{
		PreparedStatement ps = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bookstore";
		String user = "root";
		String pass = "Barcelona2108";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		ps = con.prepareStatement(sql);
	
		return ps;
	}
	
	//Check connection
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		getPreparedStatement("select * from Books");
	}
	

}
