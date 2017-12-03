package com.yuzhi.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuzhi.bean.BookSort;
import com.yuzhi.util.JDBCPoolUtil;
import com.yuzi.dao.BookSortDao;

public class BookSortDaoImpl implements BookSortDao {
	private static Connection Connection = null;
	private static PreparedStatement prepareStatement = null;
	private static ResultSet resultSet = null;

	@Override
	public List<BookSort> findAllBookSort() {
		List<BookSort> list = null;

		try {
			Connection = JDBCPoolUtil.getConnection();
			prepareStatement = Connection.prepareStatement("select distinct bsort from booksort");
			resultSet = prepareStatement.executeQuery();
			list = new ArrayList<>();

			while (resultSet.next()) {
				BookSort bookSort = new BookSort();
				bookSort.setbSort(resultSet.getString("bSort"));
				System.out.println(resultSet.getString("bSort"));
				list.add(bookSort);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(Connection, prepareStatement, resultSet);
		}

		return list;
	}

	@Override
	public boolean insertBookSort(BookSort bookSort) {
		try {
			Connection = JDBCPoolUtil.getConnection();
			prepareStatement = Connection.prepareStatement("insert into bookSort(bsort) values(?)");
			prepareStatement.setString(1, bookSort.getbSort());
			int i = prepareStatement.executeUpdate();
			if (i > 0) {
				return true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(Connection, prepareStatement, null);
		}

		return false;
	}

	@Override
	public boolean deleteBookSort(BookSort bookSort) {
		try {
			Connection = JDBCPoolUtil.getConnection();
			prepareStatement = Connection.prepareStatement("delete from bookSort where bsort=?");
			prepareStatement.setString(1, bookSort.getbSort());
			int i = prepareStatement.executeUpdate();
			if (i > 0) {
				return true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(Connection, prepareStatement, null);
		}

		return false;
	}

}
