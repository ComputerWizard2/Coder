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

/**
 * Servlet implementation class BookInfoServlet
 */
@WebServlet("/BookInfoServlet")
public class BookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 将页面上获取的信息封装成类
		// 主要含有两个消息：一个是查询的条件，另一个是查询方式
		String seek = request.getParameter("seek");
		String select = request.getParameter("select");
		String name = request.getParameter("name");
		// 根据选择的方式来选择相应的方式来调用dao层的命令
		switch (seek) {
		case "模糊查询":
			switch (select) {
			case "书名":
				// 根据书名进行查找
				List<Books> findBookByBname = mfindBookByBname(name);

				HttpSession session = request.getSession();
				if (findBookByBname != null && findBookByBname.size() > 0) {

					session.setAttribute("mess", findBookByBname);
					response.sendRedirect("showBook.jsp");

				} else {
					session.setAttribute("mess", "未查到该书籍的信息");
					response.sendRedirect("erro.jsp");
				}
				break;
			case "类别":
				// 根据类别查找
				List<Books> list = mfindBookByCatgory(name);
				session = request.getSession();
				if (list != null && list.size() > 0) {

					session.setAttribute("mess", list);
					response.sendRedirect("showBook.jsp");
				} else {
					session.setAttribute("mess", "未查到该书籍的信息");
					response.sendRedirect("erro.jsp");
				}

				break;
			case "条形码":

				List<Books> list2 = mfindBookByStrip(name);
				session = request.getSession();
				if (list2 != null && list2.size() > 0) {

					session.setAttribute("mess", list2);
					response.sendRedirect("showBook.jsp");
				} else {
					session.setAttribute("mess", "未查到该书籍的信息");
					response.sendRedirect("erro.jsp");
				}

				break;

			}

			break;

		case "精确查询":

			switch (select) {
			case "书名":
				List<Books> findBookByBname = findBookByBname(name);
				System.out.println("------------->" + findBookByBname);
				HttpSession session = request.getSession();
				if (findBookByBname != null && findBookByBname.size() > 0) {

					session.setAttribute("mess", findBookByBname);
					response.sendRedirect("showBook.jsp");
				} else {
					session.setAttribute("mess", "未查到该书籍的信息");
					response.sendRedirect("erro.jsp");
				}
				break;
			case "类别":

				List<Books> list = findBookByCatgory(name);
				session = request.getSession();
				if (list != null && list.size() > 0) {

					session.setAttribute("mess", list);
					response.sendRedirect("showBook.jsp");
				} else {
					session.setAttribute("mess", "未查到该书籍的信息");
					response.sendRedirect("erro.jsp");
				}

				break;
			case "条形码":

				List<Books> list2 = findBookByStrip(name);
				session = request.getSession();
				if (list2 != null && list2.size() > 0) {

					session.setAttribute("mess", list2);
					response.sendRedirect("showBook.jsp");
				} else {
					session.setAttribute("mess", "未查到该书籍的信息");
					response.sendRedirect("erro.jsp");
				}

				break;

			}

			break;
		}

	}

	private List<Books> mfindBookByStrip(String name) {
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		List<Books> list = bookDaoImpl.mfindBookByStrip(name);
		return list;
	}

	private List<Books> mfindBookByCatgory(String name) {
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		List<Books> list = bookDaoImpl.mfindBookByCatgroy(name);

		return list;
	}

	private List<Books> mfindBookByBname(String name) {
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		List<Books> list = bookDaoImpl.mfindBookByName(name);

		return list;
	}

	private List<Books> findBookByStrip(String name) {

		// 调用dao的方法
		BookDaoImpl daoImpl = new BookDaoImpl();
		List<Books> list = daoImpl.findBookByStrip(name);

		return list;
	}

	private List<Books> findBookByCatgory(String name) {

		// 调用dao层命令对数据库进行遍历，依据类别
		BookDaoImpl daoImpl = new BookDaoImpl();
		List<Books> list = daoImpl.findBookByCatgroy(name);

		return list;

	}

	private List<Books> findBookByBname(String name) {
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		List<Books> list = bookDaoImpl.findBookByName(name);

		return list;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
