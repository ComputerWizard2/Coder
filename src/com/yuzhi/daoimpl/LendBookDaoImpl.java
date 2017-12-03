package com.yuzhi.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuzhi.bean.LendBooks;
import com.yuzhi.util.JDBCPoolUtil;
import com.yuzi.dao.lendBooksDao;

public class LendBookDaoImpl implements lendBooksDao {
	private static Connection connection = null;
	private static PreparedStatement preparedstatement = null;
	private static ResultSet resultset = null;

	@Override
	public List<LendBooks> findAllLendBook() {

		List<LendBooks> list = null;
		try {
			connection = JDBCPoolUtil.getConnection();
			preparedstatement = connection.prepareStatement("select * from lendbooks ");

			resultset = preparedstatement.executeQuery();

			list = new ArrayList<>();
			while (resultset.next()) {
				LendBooks lendBooks = new LendBooks();
				lendBooks.setId(resultset.getInt(1));
				lendBooks.setrNo(resultset.getString(2));
				lendBooks.setLendBook(resultset.getString(3));
				lendBooks.setBarCode(resultset.getString(4));
				lendBooks.setBorrower(resultset.getString(5));

				list.add(lendBooks);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedstatement, resultset);
		}

		return list;
	}

	@Override
	public boolean insertLendBook(LendBooks lendBooks) {
		try {
			connection = JDBCPoolUtil.getConnection();
			preparedstatement = connection
					.prepareStatement("insert into lendbooks(rno,lendbook,barCode,borrower)values(?,?,?,?)");
			preparedstatement.setString(1, lendBooks.getrNo());
			preparedstatement.setString(2, lendBooks.getLendBook());
			preparedstatement.setString(3, lendBooks.getBarCode());
			preparedstatement.setString(4, lendBooks.getBorrower());
			int i = preparedstatement.executeUpdate();
			if (i > 0) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedstatement, resultset);
		}

		return false;
	}

}
