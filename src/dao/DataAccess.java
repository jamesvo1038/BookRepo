package dao;

import db.DBUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Book;

public class DataAccess {

	public void addBook(Book b) throws ClassNotFoundException, SQLException
	{
		PreparedStatement ps = DBUtils.getPreparedStatement("insert into Books values(?,?,?,?,?)");
		ps.setString(1,b.getTitle());
		ps.setString(2,b.getDate());
		ps.setString(3,b.getDescription());
		ps.setString(4,b.getDetail());
		ps.setString(5,b.getCategory());
		ps.setString(6,b.getImage());
		
		ps.executeUpdate();
	}
	
	public static List<Book> getAll() throws ClassNotFoundException, SQLException
	{
		java.util.List<Book> ls = new LinkedList<>();
		ResultSet rs = DBUtils.getPreparedStatement("select * from Book").executeQuery();
		while(rs.next())
		{
			Book b = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
		}
	
		return ls;
		
		
				
	}
}
