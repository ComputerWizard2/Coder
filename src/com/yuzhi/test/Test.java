package com.yuzhi.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yuzhi.util.JDBCPoolUtil;

public class Test {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JDBCPoolUtil.getConnection();
			preparedStatement = connection.prepareStatement("insert into books(barCode,bname,writer) values(?,?,?)");
			preparedStatement.setInt(1, 10000);
			preparedStatement.setString(2, "白夜行");
			preparedStatement.setString(3, "马克思");
			int executeUpdate = preparedStatement.executeUpdate();
			if (executeUpdate > 0) {
				System.out.println("插入成功。。");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedStatement, null);
		}

	}

}
