
package servlet;

 

import java.io.IOException;

import java.io.PrintWriter;

 

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

import DAO.BooksDao;

import DAO.BooksDaoImpl;

 

public class BooksDeleteServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		doPost(request,response);

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		String id=request.getParameter("id");

		int bookId=Integer.parseInt(id);

		

		BooksDao bd=new BooksDaoImpl();

		if(bd.delete(bookId)){

			request.setAttribute("xiaoxi","É¾³ý³É¹¦");

			request.getRequestDispatcher("/BookesAllSearchServlet").forward(request, response);

		}else{

			response.sendRedirect("fail.html");

		}

	}

}
