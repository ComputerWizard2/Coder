package com.yuzi.dao;

import com.yuzhi.bean.Reader;

public interface ReaderDao {

	// 根据user的密码用户名查对象
	public boolean findUser(Reader reader);

	// 新增一个用户
	public boolean insertReader(Reader reader);

	// 删除一个用户
	public boolean deleteReader(int rno);

	// 根据用户的rno的查找对象，返回对象
	public Reader findOne(int rno);
}
