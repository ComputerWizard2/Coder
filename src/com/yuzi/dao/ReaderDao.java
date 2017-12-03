package com.yuzi.dao;

import java.util.List;

import com.yuzhi.bean.Reader;

public interface ReaderDao {

	// 根据user的密码用户名查对象
	public boolean findUser(Reader reader);

	// 新增一个用户
	public boolean insertReader(Reader reader);

	// 删除一个用户
	public boolean deleteReader(int rno);

	// 根据用户的rno的查找对象，返回对象
	public Reader findOne(String rName);

	// 查找所有的用户
	public List<Reader> findAllReader();

	// 查找用户通过名字
	public Reader findReaderByName(String name);

	// 更新用户的数据的信息
	public boolean updateReaderInfo(Reader reader);

	// 更新用户的部分信息
	public boolean updateReaderPartInfo(Reader reader);

}
