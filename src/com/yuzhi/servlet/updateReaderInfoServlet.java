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
 * Servlet implementation class updateReaderInfoServlet
 */
@WebServlet("/updateReaderInfoServlet")
public class updateReaderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateReaderInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从浏览器获取数据
		String newPassWord = request.getParameter("newPassword");
		String newRage = request.getParameter("newrage");
		String newClass = request.getParameter("newrClass");
		String newPhoneNum = request.getParameter("newrPhoneNum");
		String uname = request.getParameter("uname");
		// 封装成reader对象
		Reader reader = new Reader();
		reader.setPassWord(newPassWord);
		reader.setrAge(Integer.parseInt(newRage));
		reader.setrClass(newClass);
		reader.setrPhoneNum(newPhoneNum);
		reader.setrName(uname);

		// 调用dao层的方法进行更改数据
		ReaderDao readerDao = new ReaderDaoImpl();
		boolean b = readerDao.updateReaderInfo(reader);
		if (b) {
			// 成功跳转到总页面
			response.sendRedirect("ReaderInfoServlet");

		} else {

			// 失败跳转到错误页面
			response.sendRedirect("erro.jsp");
		}

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
