package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import enity.Books;
import util.DBconn;

public class BooksDaoImpl implements BooksDao {
	public boolean register(Books book){          //新建图书
		boolean flag=false;
		DBconn.init();
		int i=DBconn.addUpdDel("insert into book"
				+ "s(num,bookname,publish,author,status)"+"values('"+book.getNum()+"','"+book.getBookname()+"','"+book.getPublish()+"','"+book.getAuthor()+"','"+book.getStatus()+"')");
		if(i>0){
			flag=true;
		}
		DBconn.closeConn();
		return flag;
	}
	
	public boolean delete(int id){         //根据id删除图书
		boolean flag=false;
		DBconn.init();
		String sql="delete from books where id="+id;
		int i=DBconn.addUpdDel(sql);
		if(i>0){
			flag=true;
		}
		DBconn.closeConn();
		return flag;
	}
	
	public boolean update(int id,String num,String bookname,String publish,String author,String status){  //更新图书
		boolean flag=false;
		DBconn.init();
		String sql="update books set num='"+num+"',bookname='"+bookname+"',publish='"+publish+"',author='"+author+"',status='"+status+"' where id="+id;
		int i=DBconn.addUpdDel(sql);
		if(i>0){
			flag=true;
		}
		DBconn.closeConn();
		return flag;
	}
	
	public List<Books> getBooksAll(){   //显示所有图书信息
		List<Books> list=new ArrayList<Books>();
		try{
			DBconn.init();
			ResultSet rs=DBconn.selectsql("select * from books");
			while(rs.next()){
				Books book=new Books();
				book.setId(rs.getInt("id"));
				book.setNum(rs.getString("num"));
				book.setBookname(rs.getString("bookname"));
				book.setPublish(rs.getString("publish"));
				book.setAuthor(rs.getString("author"));
				book.setStatus(rs.getString("status"));
				list.add(book);
			}
			DBconn.closeConn();
			return list;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Books> getBooksSome(String num){
		List<Books> list=new ArrayList<Books>();
		try{
			DBconn.init();
			ResultSet rs=DBconn.selectsql("select * from books where num='"+num+"'");
			while(rs.next()){
				Books book=new Books();
				book.setId(rs.getInt("id"));
				book.setNum(rs.getString("num"));
				book.setBookname(rs.getString("bookname"));
				book.setPublish(rs.getString("publish"));
				book.setAuthor(rs.getString("author"));
				book.setStatus(rs.getString("status"));
				list.add(book);
			}
			DBconn.closeConn();
			return list;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Books> list(){
		return list(0,Short.MAX_VALUE);
	}
	
	public List<Books> list(int start,int count){
		List<Books> books=new ArrayList<Books>();
		try{
			DBconn.init();
			//String sql="select * from books order by id desc limit ?,?";
			ResultSet rs=DBconn.selectsql("select * from books order by id asc limit "+start+","+count);
			while(rs.next()){
				Books book=new Books();
				book.setId(rs.getInt("id"));
				book.setNum(rs.getString("num"));
				book.setBookname(rs.getString("bookname"));
				book.setPublish(rs.getString("publish"));
				book.setAuthor(rs.getString("author"));
				book.setStatus(rs.getString("status"));
				books.add(book);
			}
			DBconn.closeConn();
			return books;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
 
	public int getTotal(){
		int total=0;
		try{
			DBconn.init();
			ResultSet rs=DBconn.selectsql("select count(*) from books");
			while(rs.next()){
				total=rs.getInt(1);
			}
			DBconn.closeConn();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return total;
	}
}
