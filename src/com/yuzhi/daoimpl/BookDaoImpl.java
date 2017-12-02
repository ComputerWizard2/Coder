package com.yuzhi.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuzhi.bean.Books;
import com.yuzhi.util.JDBCPoolUtil;
import com.yuzi.dao.BookDao;

public class BookDaoImpl implements BookDao {
	private static Connection connection = null;
	private static PreparedStatement preparedstatement = null;
	private static ResultSet resultset = null;

	@Override
	public List<Books> findBookByName(String name) {

		List<Books> list = null;
		try {
			connection = JDBCPoolUtil.getConnection();
			preparedstatement = connection.prepareStatement("select * from books where bname= ? ");
			preparedstatement.setString(1, name);

			resultset = preparedstatement.executeQuery();
			boolean r = resultset.next();
			list = new ArrayList<>();
			while (r) {
				Books books = new Books();
				books.setbName(resultset.getString("bName"));
				System.out.println(resultset.getString("bName"));
				books.setWriter(resultset.getString("writer"));
				books.setPress(resultset.getString("press"));
				books.setPresstime(resultset.getString("presstime"));
				books.setPrice(resultset.getDouble("price"));
				books.setSort(resultset.getString("sort"));
				books.setPageNum(resultset.getInt("pageNum"));
				books.setState(resultset.getString("state"));
				list.add(books);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedstatement, resultset);
		}

		return list;
	}

	@Override
	public List<Books> findBookByCatgroy(String name) {
		List<Books> list = null;
		try {
			connection = JDBCPoolUtil.getConnection();
			preparedstatement = connection.prepareStatement("select * from books where sort =?");
			preparedstatement.setString(1, name);
			resultset = preparedstatement.executeQuery();
			list = new ArrayList<>();
			while (resultset.next()) {
				Books books = new Books();
				books.setbName(resultset.getString("bName"));
				books.setWriter(resultset.getString("writer"));
				books.setPress(resultset.getString("press"));
				books.setPresstime(resultset.getString("presstime"));
				books.setPrice(resultset.getDouble("price"));
				books.setSort(resultset.getString("sort"));
				books.setPageNum(resultset.getInt("pageNum"));
				books.setState(resultset.getString("state"));
				list.add(books);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Books> findBookByStrip(String name) {
		List<Books> list = null;
		try {
			connection = JDBCPoolUtil.getConnection();
			preparedstatement = connection.prepareStatement("select * from books where barcode =?");
			preparedstatement.setString(1, name);
			resultset = preparedstatement.executeQuery();
			list = new ArrayList<>();
			while (resultset.next()) {
				Books books = new Books();
				books.setbName(resultset.getString("bName"));
				books.setWriter(resultset.getString("writer"));
				books.setPress(resultset.getString("press"));
				books.setPresstime(resultset.getString("presstime"));
				books.setPrice(resultset.getDouble("price"));
				books.setSort(resultset.getString("sort"));
				books.setPageNum(resultset.getInt("pageNum"));
				books.setState(resultset.getString("state"));
				list.add(books);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Books> mfindBookByName(String name) {
		List<Books> list = null;
		try {
			connection = JDBCPoolUtil.getConnection();
			preparedstatement = connection.prepareStatement("select * from books where bname like ? ");
			preparedstatement.setString(1, "%" + name + "%");
			resultset = preparedstatement.executeQuery();
			list = new ArrayList<>();
			while (resultset.next()) {
				Books books = new Books();
				books.setbName(resultset.getString("bName"));
				books.setWriter(resultset.getString("writer"));
				books.setPress(resultset.getString("press"));
				books.setPresstime(resultset.getString("presstime"));
				books.setPrice(resultset.getDouble("price"));
				books.setSort(resultset.getString("sort"));
				books.setPageNum(resultset.getInt("pageNum"));
				books.setState(resultset.getString("state"));
				list.add(books);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedstatement, resultset);
		}

		return list;
	}

	@Override
	public List<Books> mfindBookByCatgroy(String name) {
		List<Books> list = null;
		try {
			connection = JDBCPoolUtil.getConnection();
			preparedstatement = connection.prepareStatement("select * from books where sort =?");
			preparedstatement.setString(1, "%" + name + "%");
			resultset = preparedstatement.executeQuery();
			list = new ArrayList<>();
			while (resultset.next()) {
				Books books = new Books();
				books.setbName(resultset.getString("bName"));
				books.setWriter(resultset.getString("writer"));
				books.setPress(resultset.getString("press"));
				books.setPresstime(resultset.getString("presstime"));
				books.setPrice(resultset.getDouble("price"));
				books.setSort(resultset.getString("sort"));
				books.setPageNum(resultset.getInt("pageNum"));
				books.setState(resultset.getString("state"));
				list.add(books);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Books> mfindBookByStrip(String name) {
		List<Books> list = null;
		try {
			connection = JDBCPoolUtil.getConnection();
			preparedstatement = connection.prepareStatement("select * from books where barcode =?");
			preparedstatement.setString(1, "%" + name + "%");
			resultset = preparedstatement.executeQuery();
			list = new ArrayList<>();
			while (resultset.next()) {
				Books books = new Books();
				books.setbName(resultset.getString("bName"));
				books.setWriter(resultset.getString("writer"));
				books.setPress(resultset.getString("press"));
				books.setPresstime(resultset.getString("presstime"));
				books.setPrice(resultset.getDouble("price"));
				books.setSort(resultset.getString("sort"));
				books.setPageNum(resultset.getInt("pageNum"));
				books.setState(resultset.getString("state"));
				list.add(books);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
