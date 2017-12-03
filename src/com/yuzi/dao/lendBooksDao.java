package com.yuzi.dao;

import java.util.List;

import com.yuzhi.bean.LendBooks;

public interface lendBooksDao {
	// 查阅已借阅的图书
	public List<LendBooks> findAllLendBook();

	// 项数据库插入一条数据
	public boolean insertLendBook(LendBooks lendBooks);

}
