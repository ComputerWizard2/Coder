package com.yuzhi.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		try {
			connection = JDBCPoolUtil.getConnection();
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(
					"insert into reader(rname,rno,rsex,rage,rclass,rsort,rphoneNum) values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, reader.getrName());

			preparedStatement.setString(2, reader.getrNo());
			preparedStatement.setString(3, reader.getrSex());
			preparedStatement.setInt(4, reader.getrAge());
			preparedStatement.setString(5, reader.getrClass());
			preparedStatement.setString(6, reader.getrSort());
			preparedStatement.setString(7, reader.getrPhoneNum());
			int i = preparedStatement.executeUpdate();

			if (i > 0) {

				return true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedStatement, null);
		}
		return false;
	}

	@Override
	public boolean deleteReader(int rno) {

		try {
			connection = JDBCPoolUtil.getConnection();
			System.out.println(connection);
			preparedStatement = connection.prepareStatement("delete from reader where rno = ?");
			preparedStatement.setInt(1, rno);

			int i = preparedStatement.executeUpdate();

			if (i > 0) {

				return true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedStatement, null);
		}
		return false;

	}

	@Override
	public Reader findOne(String rName) {
		try {
			connection = JDBCPoolUtil.getConnection();

			preparedStatement = connection.prepareStatement("select * from reader where rname=? ");
			preparedStatement.setString(1, rName);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Reader reader = new Reader();
				reader.setrNo(resultSet.getString(1));
				reader.setrName(resultSet.getString(2));
				reader.setrSex(resultSet.getString(3));
				reader.setrAge(resultSet.getInt(4));
				reader.setrClass(resultSet.getString(5));
				reader.setrSort(resultSet.getString(6));
				reader.setrPhoneNum(resultSet.getString(7));
				reader.setPassWord(resultSet.getString(8));
				reader.setLendNum(resultSet.getInt(9));
				reader.setCanLendNum(resultSet.getInt(10));
				return reader;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedStatement, null);
		}

		return null;
	}

	@Override
	public List<Reader> findAllReader() {
		List<Reader> list = null;
		try {
			connection = JDBCPoolUtil.getConnection();
			System.out.println(connection);
			preparedStatement = connection.prepareStatement("select * from reader ");

			resultSet = preparedStatement.executeQuery();
			list = new ArrayList<>();
			while (resultSet.next()) {
				Reader reader = new Reader();
				reader.setrNo(resultSet.getString(1));
				reader.setrName(resultSet.getString(2));
				reader.setrSex(resultSet.getString(3));
				reader.setrAge(resultSet.getInt(4));
				reader.setrClass(resultSet.getString(5));
				reader.setrSort(resultSet.getString(6));
				reader.setrPhoneNum(resultSet.getString(7));
				reader.setPassWord(resultSet.getString(8));
				reader.setLendNum(resultSet.getInt(9));
				reader.setCanLendNum(resultSet.getInt(10));
				list.add(reader);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public Reader findReaderByName(String name) {

		Reader reader = new Reader();
		try {
			connection = JDBCPoolUtil.getConnection();

			preparedStatement = connection.prepareStatement("select * from reader where rname=?");
			preparedStatement.setString(1, name.trim());
			resultSet = preparedStatement.executeQuery();
			boolean res = resultSet.next();
			System.out.println(res);

			if (res) {

				reader.setrNo(resultSet.getString(1));
				reader.setrName(resultSet.getString(2));
				reader.setrSex(resultSet.getString(3));
				reader.setrAge(resultSet.getInt(4));
				reader.setrClass(resultSet.getString(5));
				reader.setrSort(resultSet.getString(6));
				reader.setrPhoneNum(resultSet.getString(7));
				reader.setPassWord(resultSet.getString(8));
				reader.setLendNum(resultSet.getInt(9));
				reader.setCanLendNum(resultSet.getInt(10));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedStatement, resultSet);
		}

		return reader;
	}

	@Override
	public boolean updateReaderInfo(Reader reader) {
		try {
			connection = JDBCPoolUtil.getConnection();
			System.out.println(reader);
			preparedStatement = connection
					.prepareStatement("update reader set password=? ,rage=? ,rClass=? ,rPhoneNum=? where rname =? ");

			preparedStatement.setString(1, reader.getPassWord());
			preparedStatement.setInt(2, reader.getrAge());
			preparedStatement.setString(3, reader.getrClass());
			preparedStatement.setString(4, reader.getrPhoneNum());
			preparedStatement.setString(5, reader.getrName());
			int i = preparedStatement.executeUpdate();
			System.out.println("-----------i--------" + i);
			if (i > 0) {
				return true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateReaderPartInfo(Reader reader) {
		try {
			connection = JDBCPoolUtil.getConnection();

			preparedStatement = connection
					.prepareStatement("update reader set lendNum=? ,canLendNum=?  where rname =? ");

			preparedStatement.setInt(1, reader.getLendNum());
			preparedStatement.setInt(2, reader.getCanLendNum());
			preparedStatement.setString(3, reader.getrName());

			int i = preparedStatement.executeUpdate();

			if (i > 0) {
				return true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
