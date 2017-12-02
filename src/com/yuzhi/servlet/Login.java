package com.yuzhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuzhi.bean.Reader;
import com.yuzhi.daoimpl.ReaderDaoImpl;
import com.yuzi.dao.ReaderDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取用户信息
		String utype = request.getParameter("utype");

		String uname = request.getParameter("username");
		String password = request.getParameter("pwd");
		// 将现有的数据封装到Reader的实体类中
		Reader reader = new Reader();
		reader.setrSort(utype);
		reader.setrName(uname);
		reader.setPassWord(password);

		// 调用dao层的命令是否能够在数据库里查找到
		boolean user = isUser(reader);

		if (user) {
			if ("管理员".equals(utype)) {
				// 向管理员的页面跳转
				response.sendRedirect("M_HomePage.jsp");

			} else {

				// 向用户端跳转
				response.sendRedirect("R_Homepage.jsp");

			}

		} else {
			// 密码错误,向客户端发送信息
			request.setAttribute("mess", "密码错误，请重新输入人。。");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	private static boolean isUser(Reader reader) {
		// 开始调用dao层的方法

		ReaderDao readerDao = new ReaderDaoImpl();
		boolean b = readerDao.findUser(reader);
		System.out.println("--------------------------------------------" + b);

		if (b) {
			return true;

		}

		return false;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
