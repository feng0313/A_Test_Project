
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

 

 

public class BooksBianjiServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		doPost(request,response);

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		int start=0;

		int count=5;

		

		try{

			start=Integer.parseInt(request.getParameter("start"));

		}catch(NumberFormatException e){

			

		}

		int next=start+count;

		int pre=start-count;

		

		int total=new BooksDaoImpl().getTotal();

		int last;

		if(0==total%count)

			last=total-count;

		else

			last=total-total%count;

		

		pre=pre<0 ? 0:pre;

		next=next>last ? last :next;

		

		request.setAttribute("pre", pre);

		request.setAttribute("next", next);

		request.setAttribute("last", last);

		List<Books> bookAll=new BooksDaoImpl().list(start, count);

 

		request.setAttribute("bookAll", bookAll);

		request.getRequestDispatcher("/BooksUpdate.jsp").forward(request, response);

	}

}
