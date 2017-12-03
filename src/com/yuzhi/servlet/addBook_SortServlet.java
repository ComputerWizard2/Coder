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
 * Servlet implementation class addBook_SortServlet
 */
@WebServlet("/addBook_SortServlet")
public class addBook_SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addBook_SortServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取当前当前的书籍的种类
		// 直接掉用dao层的命令即可
		BookSortDao bookSortDao = new BookSortDaoImpl();
		List<BookSort> list = bookSortDao.findAllBookSort();
		System.out.println(list);
		if (list.size() > 0 && list != null) {
			request.setAttribute("bslist", list);

			request.getRequestDispatcher("AddBook.jsp").forward(request, response);

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
