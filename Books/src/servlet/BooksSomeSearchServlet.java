
package servlet;

 

import java.io.IOException;

import java.io.PrintWriter;

import java.util.List;

 

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

import DAO.BooksDaoImpl;

 

import DAO.BooksDao;

import enity.Books;

 

 

public class BooksSomeSearchServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		doPost(request,response);

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		BooksDao bd=new BooksDaoImpl();

		String num=request.getParameter("num");

		List<Books> bookSome=bd.getBooksSome(num);

		

		request.setAttribute("bookSome", bookSome);

		request.getRequestDispatcher("/BooksSomeShow.jsp").forward(request, response);

	}

}
