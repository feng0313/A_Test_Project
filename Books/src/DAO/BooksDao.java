package DAO;

import java.util.List;
 
import enity.Books;

public interface BooksDao {
	public boolean register(Books book);  //新建图书
	public boolean delete(int id);  //删除图书
	public boolean update(int id,String num,String bookname,String publish,String author,String status);  //更新图书
	public List<Books> getBooksAll();  //查询所有图书信息
	public List<Books> getBooksSome(String num);  //查询一部分图书信息
	public List<Books> list();
	public List<Books> list(int start,int count);
	public int getTotal();
}
