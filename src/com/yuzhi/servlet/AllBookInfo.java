package com.yuzhi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yuzhi.bean.Books;
import com.yuzhi.daoimpl.BookDaoImpl;
import com.yuzi.dao.BookDao;

/**
 * Servlet implementation class AllBookInfo
 */
@WebServlet("/AllBookInfo")
public class AllBookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllBookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取所有图书信息
		BookDao bookDao = new BookDaoImpl();
		List<Books> list2 = bookDao.findAllBooks();
		HttpSession session = request.getSession();
		if (list2 != null && list2.size() > 0) {

			session.setAttribute("list", list2);
			response.sendRedirect("AllBookInfo.jsp");
		} else {
			session.setAttribute("mess", "未查到该书籍的信息");
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
