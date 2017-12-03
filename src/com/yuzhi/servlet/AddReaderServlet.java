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
 * Servlet implementation class AddReaderServlet
 */
@WebServlet("/AddReaderServlet")
public class AddReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddReaderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 增加一个用户
		// 从页面获取用户的信息
		String rName = request.getParameter("rName");
		String rSex = request.getParameter("rsex");
		String rage = request.getParameter("rage");
		String rClass = request.getParameter("rClass");
		String rNo = request.getParameter("rNo");
		String rSort = request.getParameter("rSort");
		String rPhoneNum = request.getParameter("rPhoneNum");
		// 封装到Reader对象中
		Reader reader = new Reader();
		reader.setrName(rName);
		reader.setrClass(rClass);
		reader.setrSex(rSex);
		reader.setrAge(Integer.parseInt(rage));
		reader.setrNo(rNo);
		reader.setrSort(rSort);
		reader.setrPhoneNum(rPhoneNum);
		// 调用dao层的方法进行插入
		ReaderDao readerDao = new ReaderDaoImpl();
		boolean insertReader = readerDao.insertReader(reader);
		if (insertReader) {
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
