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
 * Servlet implementation class removeBookSortServlet
 */
@WebServlet("/removeBookSortServlet")
public class removeBookSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public removeBookSortServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bSort = request.getParameter("bsort2");
		BookSort bookSort = new BookSort();
		bookSort.setbSort(bSort);

		BookSortDao bookSortDao = new BookSortDaoImpl();
		List<BookSort> list = bookSortDao.findAllBookSort();
		boolean b = bookSortDao.deleteBookSort(bookSort);
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
