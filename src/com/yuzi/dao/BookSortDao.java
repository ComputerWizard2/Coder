package com.yuzi.dao;

import java.util.List;

import com.yuzhi.bean.BookSort;

public interface BookSortDao {
	// 查找所有的种类
	public List<BookSort> findAllBookSort();
	// 查找数据库中所有的类型

	// 添加所有的类型
	public boolean insertBookSort(BookSort bookSort);

	// 删除图书的类别
	public boolean deleteBookSort(BookSort bookSort);

}
