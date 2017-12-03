package com.yuzhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuzhi.bean.Books;
import com.yuzhi.daoimpl.BookDaoImpl;
import com.yuzi.dao.BookDao;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取浏览器的信息
		String rName = request.getParameter("bName");
		String press = request.getParameter("press");
		String writer = request.getParameter("writer");
		String pressTime = request.getParameter("presstime");
		String pageNum = request.getParameter("pageNum");
		String sort = request.getParameter("sort");
		String barCode = request.getParameter("barCode");
		String price = request.getParameter("price");

		// 封装成对象
		Books books = new Books();
		books.setbName(rName);
		books.setWriter(writer);
		books.setPress(press);
		books.setPresstime(pressTime);

		books.setPageNum(Integer.parseInt(pageNum));
		books.setBarCode(barCode);
		books.setSort(sort);
		books.setPrice(Double.parseDouble(price));
		// 调用dao层的命令进行插入对象
		BookDao bookDao = new BookDaoImpl();
		boolean insertBook = bookDao.insertBook(books);
		if (insertBook) {
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
