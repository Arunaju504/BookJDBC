package com.servlet.first;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BookService;
import com.jdbc.JdbcManager;
import com.main.Book;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BookService service;
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		service =new BookService();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url =request.getServletPath();
		switch (url) {
		case "/":
			homePage(request,response);
			break;
		case "/view":
			try {
				viewPage(request,response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/show":
			try {
				showPage(request,response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

	private void showPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		//List<Book> bookList = service.findAll();
		List<Book> bookList =JdbcManager.show();
	request.setAttribute("book",bookList );
	RequestDispatcher dispatcher =request.getRequestDispatcher("/view.jsp");
	dispatcher.forward(request, response);
		
	}

	private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
		
	}

	private void viewPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {

		String strbookId =request.getParameter("bookId");
		int bookId =Integer.parseInt(strbookId);
		String bookName =request.getParameter("bookName");
		String authorName =request.getParameter("authorName");
		String strbookPrice =request.getParameter("price");
		double price =Double.parseDouble(strbookPrice);
		Book strbookAd =new Book(bookId,bookName,authorName,price);
		
		int flag=JdbcManager.insert(strbookAd);
		if(flag >0) {
			System.out.println("added");
		}else {
			System.out.println("no added");
		}
		
		Book entity = service.add(strbookAd);
		request.setAttribute("books",entity );
		RequestDispatcher dispatcher =request.getRequestDispatcher("/bookadd.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private void addPage(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
