package com.yuzhi.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yuzhi.bean.Reader;
import com.yuzhi.util.JDBCPoolUtil;
import com.yuzi.dao.ReaderDao;

public class ReaderDaoImpl implements ReaderDao {
	/**
	 * 查找数据库中是否存在该用户
	 */
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	@Override
	public boolean findUser(Reader reader) {
		try {
			connection = JDBCPoolUtil.getConnection();
			System.out.println(connection);
			preparedStatement = connection.prepareStatement("select * from reader where rname=? and password= ?");
			preparedStatement.setString(1, reader.getrName());
			preparedStatement.setString(2, reader.getPassWord());
			// preparedStatement.setString(3, reader.getrSort());
			resultSet = preparedStatement.executeQuery();
			boolean next = resultSet.next();
			if (next) {

				return true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedStatement, resultSet);
		}
		return false;
	}

	@Override
	public boolean insertReader(Reader reader) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReader(int rno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reader findOne(int rno) {
		// TODO Auto-generated method stub
		return null;
	}

}
