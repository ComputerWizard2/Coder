package com.yuzhi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yuzhi.bean.BookSort;
import com.yuzhi.daoimpl.BookSortDaoImpl;
import com.yuzi.dao.BookSortDao;

/**
 * Servlet implementation class addBookSortServlet
 */
@WebServlet("/addBookSortServlet")
public class addBookSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addBookSortServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取来自浏览器的名称
		String bSort = request.getParameter("bsort");
		BookSort bookSort = new BookSort();
		bookSort.setbSort(bSort);
		// 调用dao层的方法进行插入
		BookSortDao bookSortDao = new BookSortDaoImpl();
		List<BookSort> list = bookSortDao.findAllBookSort();
		boolean b = bookSortDao.insertBookSort(bookSort);
		HttpSession session = request.getSession();
		if (b) {
			session.setAttribute("bslist2", list);
			response.sendRedirect("booksort.jsp");
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
