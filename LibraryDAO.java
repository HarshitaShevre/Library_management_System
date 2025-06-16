package Admin.DAO;

import java.sql.Connection;
import Admin.Main.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Admin.Model.Library;

public class LibraryDAO {
 
	private static final String URL="jdbc:mysql://localhost:3306/librarymanagement ";
	  private static final String USER="root";
	  private static final String PASSWORD="root";
	  
	  private Connection getConnection() throws SQLException {
	      return DriverManager.getConnection(URL, USER, PASSWORD);
	  }
	  
	 public void insertBook (Library library) throws SQLException
	 {
		String sql="insert into book_library (bookid,book_name,book_title,book_type,book_author,book_Quan,issue_date,return_date) values(?,?,?,?,?,?,?,?)";
		Connection con=getConnection();
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,library.getBookId());
		pstmt.setString(2, library.getBookName());
		pstmt.setString(3, library.getBookTitle());
		pstmt.setString(4, library.getBookType());
		pstmt.setString(5, library.getBookAuthor());
		pstmt.setInt(6, library.getBookQuantity());
		pstmt.setString(7, library.getIssueDate());
        pstmt.setString(8, library.getReceiveDate());
        pstmt.executeUpdate();
        System.out.println("Done ✅");
	 }
	public void updateBook (Library library) throws SQLException
	{
		String sql="update book_library Set book_name=?,book_title=?,book_type=?,book_author=?,book_Quan=? where bookid=?";
		Connection con=getConnection();
		try (PreparedStatement pstmt=con.prepareStatement(sql)){
		pstmt.setString(1, library.getBookName());
		pstmt.setString(2, library.getBookTitle());
		pstmt.setString(3, library.getBookType());
		pstmt.setString(4, library.getBookAuthor());
		pstmt.setInt(5, library.getBookQuantity());
		pstmt.setInt(6, library.getBookId());
        pstmt.executeUpdate();
        System.out.println("Done ✅");
		
	} 	
	  catch(SQLException e)
		{
		  System.out.println("Error Updating Book :"+e.getMessage());
		  throw e;
		}

	
	}
	
	public void findByTitle(String title) throws SQLException
	{
		String sql="SELECT * FROM book_library WHERE book_title='"+title+"' ";
		Connection con = getConnection();
		PreparedStatement pst=con.prepareStatement(sql);
		//pst.setString(1,title);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			System.out.println("BookId :"+rs.getInt(1));
			System.out.println("Book Name :"+rs.getString(2));
			System.out.println("Book Title :"+rs.getString(3));
			System.out.println("Book Type :"+rs.getString(4));
			System.out.println("Book Author:"+rs.getString(5));
			System.out.println("Book Quantity :"+rs.getString(6));
			System.out.println("Book Issuedate :"+rs.getString(7));
			System.out.println("Book Recievedate:"+rs.getString(8));
		}
		rs.close();
		pst.close();
		con.close();
	}
	public void deleteBook(String author) throws SQLException
	{
		String sql="delete from book_library where book_author='"+author+"'";
		try (Connection con =getConnection()){
	    PreparedStatement pst=con.prepareStatement(sql);
	    int rowsaffected=pst.executeUpdate();
	    if(rowsaffected>0)
	    {
	      System.out.println("Books by " + author + " deleted successfully ✅");	
	    }
	    else
	    {
	      System.out.println(" ❎ No books found by this author.");
	    }	
      }
		
  }
	public void findById(int id) throws SQLException
	{
		 String sql = "SELECT * FROM book_library WHERE bookid=?";
	        try (Connection con = getConnection(); 
	        	PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                System.out.println("BookId: " + rs.getInt(1));
	                System.out.println("Book Name: " + rs.getString(2));
	                System.out.println("Book Title: " + rs.getString(3));
	                System.out.println("Book Type: " + rs.getString(4));
	                System.out.println("Book Author: " + rs.getString(5));
	                System.out.println("Book Quantity: " + rs.getInt(6));
	                System.out.println("Book Issue Date: " + rs.getString(7));
	                System.out.println("Book Receive Date: " + rs.getString(8));
	            } else {
	                System.out.println("Book not found.");
	            }
	        }

	}
	public void displayBooksByType(String bookType) throws SQLException
	{
		String sql="SELECT * FROM book_library WHERE book_type = ? ORDER BY book_name";
		try (Connection con = getConnection(); 
		         PreparedStatement pstmt = con.prepareStatement(sql)){ 
		        pstmt.setString(1, bookType);  
		        ResultSet rs = pstmt.executeQuery();
		        System.out.printf("%-30s %-30s\n", "Book Name", "Book Author");
		        System.out.println("===========================================================");
		        boolean found=false;
		        while(rs.next())
		        {
		          found=true;
		          String bookName = rs.getString("book_name");
		          String bookAuthor = rs.getString("book_author");
		          System.out.printf("%-30s %-30s\n", bookName, bookAuthor);
		          System.out.println();
	              System.out.println("Done ✅");
		        }
		        if (!found) {
		            System.out.println("No books found for the type: "+ bookType);}
		        else {
		        	
		        }
		}   
		
	}
	 public void viewDueBooks(String returndate) throws SQLException {
	        String sql = "SELECT * FROM book_library WHERE return_date='"+returndate+"'";
	        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
	            ResultSet rs = pstmt.executeQuery();
	            System.out.printf("%-30s %-30s %-10s\n", "Book Title", "Book Author", "Book Quantity");
	            System.out.println("----------------------------------------------------------------------------------");
	            while (rs.next()) {
	            	String bookTitle = rs.getString("book_title");
	                String bookAuthor = rs.getString("book_author");
	                int bookQuantity = rs.getInt("book_Quan");
	                System.out.printf("%-30s %-30s %-10d\n", bookTitle, bookAuthor, bookQuantity); 
	            }
	        }
	    }
	 public List<Library> getAllBooks()throws SQLException
	 {
		 List<Library> lib=new ArrayList<>();
		 String sql="select * from book_library";
		 Connection con=getConnection();
		 Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery(sql);
		 while(rs.next())
		 {
			 int bookid=rs.getInt(1);
			 String bookname=rs.getString(2);
			 String booktitle=rs.getString(3);
			 String booktype=rs.getString(4);
			 String bookauthor=rs.getString(5);
			 int bookquantity=rs.getInt(6);
			 String issuedate=rs.getString(7);
			 String returndate=rs.getString(8);
			 Library library=new Library(bookid,bookname,booktitle,booktype,bookauthor,bookquantity,issuedate,returndate);
			 lib.add(library);
		 }
		 return lib;
	 }
  

	 
	
	
	
	
	
	
	
	
	
}
