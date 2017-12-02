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

}
