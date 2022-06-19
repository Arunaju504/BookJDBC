
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudrepository.CrudRepository;
import com.main.Book;

public class JdbcManager  {

	public static int insert(Book b) throws ClassNotFoundException, SQLException {
		int flag=0;
		Connection con=SqlConnection.getConnection();
		PreparedStatement st=con.prepareStatement("insert into book values (?,?,?,?)");
		st.setInt(1, b.getBookId());
		st.setString(2, b.getBookName());
		st.setString(3, b.getAuthorName());
		st.setDouble(4, b.getPrice());
		flag=st.executeUpdate();
		st.close();
		con.close();
		return flag;
		
	}
	public static List<Book> show() throws ClassNotFoundException, SQLException {
		Connection con=SqlConnection.getConnection();
		PreparedStatement st=con.prepareStatement("select * from book");
		ResultSet rs=st.executeQuery();
		
		List<Book> bookList =new ArrayList<>();
		while(rs.next()) {
			int id =rs.getInt(1);
			String name=rs.getString(2);
			String author=rs.getString(3);
			double price=rs.getDouble(4);
			Book book =new Book(id,name,author,price);
			bookList.add(book);
			
			
			
			
		}
		st.close();
		con.close();
		return bookList ;
		
	}
}
