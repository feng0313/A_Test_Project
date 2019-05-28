package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import DAO.BooksDao;
import DAO.BooksDaoImpl;
import enity.Books;

public class BooksUpdateServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		doPost(request,response);

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		String id=request.getParameter("id");

		int bookId=Integer.parseInt(id);

		

		String num=request.getParameter("num");

		String bookname=request.getParameter("bookname");

		String publish=request.getParameter("publish");

		String author=request.getParameter("author");

		String status=request.getParameter("status");

		

		BooksDao bd=new BooksDaoImpl();

		if(bd.update(bookId,num,bookname,publish,author,status)){

			request.setAttribute("xiaoxi", "更新成功");

			request.getRequestDispatcher("/BookesAllSearchServlet").forward(request, response);

		}else{

			response.sendRedirect("fail.html");

		}

	}

}
