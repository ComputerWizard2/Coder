package com.yuzi.dao;

import java.util.List;

import com.yuzhi.bean.Books;

public interface BookDao {
	// 精确查询
	public List<Books> findBookByName(String name);

	public List<Books> findBookByCatgroy(String name);

	public List<Books> findBookByStrip(String name);

	// 模糊查询
	public List<Books> mfindBookByName(String name);

	public List<Books> mfindBookByCatgroy(String name);

	public List<Books> mfindBookByStrip(String name);

	// 查找所有的图书
	public List<Books> findAllBooks();

	// 插入一条图书记录
	public boolean insertBook(Books books);

	// 删除一条图书记录
	public boolean deleteBook(String barCode);

	// 更具条形码查找对象
	public Books findBookByCodeBar(String barCode);
	// up

}
