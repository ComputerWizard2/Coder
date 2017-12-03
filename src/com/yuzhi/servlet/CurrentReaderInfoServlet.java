package com.yuzhi.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class CurrentReaderInfoServlet
 */
@WebServlet("/CurrentReaderInfoServlet")
public class CurrentReaderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CurrentReaderInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rName = request.getParameter("rName");

		ReaderDao readerDao = new ReaderDaoImpl();
		Reader reader = readerDao.findReaderByName(rName);

		// 查询所有的借阅图书
		lendBooksDao lendBooksDao = new LendBookDaoImpl();
		List<LendBooks> lendBook = lendBooksDao.findAllLendBook();
		List<Reader> list = new ArrayList<>();
		System.out.println("---reader===>" + reader);
		list.add(reader);

		if (list != null && list.size() > 0 && lendBook.size() > 0 && lendBook != null) {

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
