package Admin.Main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import Admin.Model.Library;
import Admin.Service.LibraryService;

public class LibraryMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
      Scanner sc=new Scanner(System.in);
      LibraryService libService=new LibraryService();
      System.out.println("📚 WELCOME TO THE LIBRARY MANAGEMENT SYSTEM 📖");
      System.out.println("=============================================================================================");
      System.out.println("👨‍💼👩‍💼 Are you an Admin or User? Please enter 'admin' or 'user' 🔑🔒:");
      String ch=sc.nextLine();
      if(ch.equals("admin"))
      {
       System.out.println("Which Operation Do You Want to perform :");
      while(true)
      {
    	  System.out.println("\n 1.Insert Books \n 2.Update Books \n 3.Find By Title \n 4.Delete books \n 5.Find By Id \n 6.View List Of Book By Type \n 7.View List Of Due Books \n 8.View All Records \n 9.Exit"
    	  		);
    	  System.out.println("Enter Your Choice");
    	  int choice=Integer.parseInt(sc.nextLine());
    	  switch(choice)
    	  {
    	  case 1:
    		  System.out.println("Enter Book ID");
    		  int id=Integer.parseInt(sc.nextLine());
//    		  int id=sc.nextInt();
//    		  sc.nextLine();
    		  System.out.println("Enter Book Name");
    		  String bookname=sc.nextLine();
    		  System.out.println("Enter Book Title");
    		  String booktitle=sc.nextLine();
    		  System.out.println("Enter Book Type");
    		  String booktype=sc.nextLine();
    		  System.out.println("Enter Author's Name");
    		  String authorname=sc.nextLine();
    		  System.out.println("Enter Quantity Of Book");
    		  int bookquant=Integer.parseInt(sc.nextLine());
    		  System.out.println("Enter Book Issue Date");
    		  String issuedate=sc.nextLine();
    		  System.out.println("Enter Receive Date");
    		  String recievedate=sc.nextLine();
    		  Library library=new Library(id,bookname,booktitle,booktype,authorname,bookquant,issuedate,recievedate);
    		  libService.addBook(library);
    		  System.out.println("Book Details Added Successfully");
    		  break;
    		  
    	  case 2:
    		  
    		  System.out.println("Enter Book Id for Update Details");
    		  
    		  int id1=Integer.parseInt(sc.nextLine());
//    		  sc.nextLine();
    		  System.out.println("Enter Updated Book name");
    		  String bookname1=sc.nextLine();
    		  System.out.println("Enter Updated Book Title");
              String booktitle1=sc.nextLine();
              System.out.println("Enter Book Updated Type");
              String booktype1=sc.nextLine();
              System.out.println("Enter Updated Book Author's Name");
              String authorname1=sc.nextLine();
              System.out.println("Enter Quantity of Updated Book");
              int quantity=Integer.parseInt(sc.nextLine());
              Library libraryy=new Library(id1,bookname1,booktitle1,booktype1,authorname1,quantity);
              libService.updatebook(libraryy);
              System.out.println("Books Updated Successfully");
              break;
              
    	  case 3:
    		  System.out.println("Enter Title for search Book Details ");
    		  String title=sc.nextLine();
    		  libService.findbytitle(title);
    		 break;
              
    	  case 4:
    		  System.out.println("Enter Author name for remove book");
    		  String author=sc.nextLine();
    		  libService.deletedbyauthor(author);
    		  break;
    	  case 5:
    		  System.out.println("Enter Id For Find Book ");
    		  int id2=Integer.parseInt(sc.nextLine());
    		  libService.findbyid(id2);
    	  case 6:
    		  System.out.println("Enter Book Type For View Book List Only you Want");
    		  String booktype2=sc.nextLine();
    		  libService.displaybookbytype(booktype2);
    		  break;
    	  case 7:
    		  
    		  System.out.println("Enter return date");
    		  String returndate=sc.nextLine();
    		  libService.viewduebooks(returndate);
    	  case 8:
    		  List<Library> library1=libService.fetchallbooks();
    		  System.out.println(" Book List");
    		  System.out.printf("%-10s %-30s %-30s %-15s %-30s %-10s %-15s %-15s\n",
                      "Book ID", "Book Name", "Book Title", "Book Type", "Book Author", "Quantity", "Issue Date", "Receive Date");
    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    		  for(Library l:library1)
    		  {
    			  System.out.printf("%-10d %-30s %-30s %-15s %-30s %-10d %-15s %-15s\n",
                          l.getBookId(), l.getBookName(), l.getBookTitle(), l.getBookType(),
                          l.getBookAuthor(), l.getBookQuantity(), l.getIssueDate(), l.getReceiveDate());
    		  }
    		  break;
    	  case 9:
    		  System.out.println("Exiting.....");
     		  sc.close();
     		  System.exit(0); 
    	  }  
        }
		
     }	
      else if(ch.equals("user"))
      {
    	  System.out.println("Which Operation Do You Want To Perform");
    	  
      }
		
		
		
	}
}


