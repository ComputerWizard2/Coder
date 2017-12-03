package com.yuzhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuzhi.daoimpl.BookDaoImpl;
import com.yuzi.dao.BookDao;

/**
 * Servlet implementation class removeBookServlet
 */
@WebServlet("/removeBookServlet")
public class removeBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public removeBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rmbookName = request.getParameter("rmbookName");
		String barCode = request.getParameter("barCode");
		// 调用dao层的命令进行删除
		BookDao bookDao = new BookDaoImpl();
		boolean b = bookDao.deleteBook(barCode);
		if (b) {
			response.sendRedirect("AllBookInfo");
		} else {
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
