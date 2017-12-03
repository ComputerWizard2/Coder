package com.yuzhi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuzhi.bean.LendBooks;
import com.yuzhi.bean.Reader;
import com.yuzhi.daoimpl.LendBookDaoImpl;
import com.yuzhi.daoimpl.ReaderDaoImpl;
import com.yuzi.dao.ReaderDao;
import com.yuzi.dao.lendBooksDao;

/**
 * Servlet implementation class ReaderInfoServlet
 */
@WebServlet("/ReaderInfoServlet")
public class ReaderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReaderInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询所有的用户
		ReaderDao readerDao = new ReaderDaoImpl();
		List<Reader> list = readerDao.findAllReader();
		// 查询所有的借阅图书
		lendBooksDao lendBooksDao = new LendBookDaoImpl();
		List<LendBooks> lendBook = lendBooksDao.findAllLendBook();

		if (list.size() > 0 && list != null && lendBook.size() > 0 && lendBook != null) {

			request.setAttribute("list", list);
			request.setAttribute("lendBook", lendBook);

			request.getRequestDispatcher("ReaderInfo.jsp").forward(request, response);

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
