package com.yuzhi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuzhi.bean.BookSort;
import com.yuzhi.daoimpl.BookSortDaoImpl;
import com.yuzi.dao.BookSortDao;

/**
 * Servlet implementation class BookSortInfoServlet
 */
@WebServlet("/BookSortInfoServlet")
public class BookSortInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookSortInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用dao层的方法

		// 查找数据库中所有的类型

		BookSortDao bookSortDao = new BookSortDaoImpl();
		List<BookSort> list = bookSortDao.findAllBookSort();
		if (list.size() > 0 && list != null) {

			request.setAttribute("bslist2", list);
			request.getRequestDispatcher("booksort.jsp").forward(request, response);

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
