package Admin.Service;

import java.sql.SQLException;
import java.util.List;

import Admin.DAO.LibraryDAO;
import Admin.Model.Library;

public class LibraryService {
     private LibraryDAO librarydao;
 
   public LibraryService() {
	   this.librarydao=new LibraryDAO();
   } 
   
   public void addBook(Library library) throws SQLException {
	   
	   librarydao.insertBook(library);
   }
   
   public void updatebook(Library library) throws SQLException
   {
	 librarydao.updateBook(library);  
   }
   
   public void findbytitle(String title) throws SQLException
   {
	   librarydao.findByTitle(title);
   }
   
   public void deletedbyauthor(String author)throws SQLException 
   {
	   librarydao.deleteBook(author);
   }
    
   public void findbyid(int id) throws SQLException 
   {
	   librarydao.findById(id);
   }
   
   public void displaybookbytype(String bookType) throws SQLException
   {
	   librarydao.displayBooksByType(bookType);
   }
   
   public void viewduebooks(String returndate) throws SQLException
   {
	   librarydao.viewDueBooks(returndate);
   }
   
   public List<Library> fetchallbooks() throws SQLException
   {
	   return librarydao.getAllBooks();
   }
    


}
