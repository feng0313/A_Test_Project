
package servlet;

 

import java.io.IOException;

import java.io.PrintWriter;

 

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

import DAO.BooksDao;

import DAO.BooksDaoImpl;

import enity.Books;

 

public class BooksRegisterServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		doPost(request,response);

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		

		if("".equals(request.getParameter("num")) || "".equals(request.getParameter("bookname")) ||"".equals(request.getParameter("publish")) ||"".equals(request.getParameter("author")) ||"".equals(request.getParameter("status"))){

			request.getRequestDispatcher("/fail.html").forward(request, response);

		}else{

			String num=request.getParameter("num");

			String bookname=request.getParameter("bookname");

			String publish=request.getParameter("publish");

			String author=request.getParameter("author");

			String status=request.getParameter("status");

			

			Books book=new Books();

			book.setNum(num);

			book.setBookname(bookname);

			book.setPublish(publish);

			book.setAuthor(author);

			book.setStatus(status);

			

			BooksDao bd=new BooksDaoImpl();

			if(bd.register(book)){

				request.getRequestDispatcher("/BookesAllSearchServlet").forward(request, response);

			}

			else

			{

				request.getRequestDispatcher("/login.html").forward(request, response);

 

			}

		}

		

	}

}
