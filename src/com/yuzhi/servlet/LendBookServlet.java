package com.yuzhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yuzhi.bean.Books;
import com.yuzhi.bean.LendBooks;
import com.yuzhi.bean.Reader;
import com.yuzhi.daoimpl.BookDaoImpl;
import com.yuzhi.daoimpl.LendBookDaoImpl;
import com.yuzhi.daoimpl.ReaderDaoImpl;
import com.yuzi.dao.ReaderDao;
import com.yuzi.dao.lendBooksDao;

/**
 * Servlet implementation class LendBookServlet
 */
@WebServlet("/LendBookServlet")
public class LendBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LendBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String barCode = request.getParameter("barCode");

		boolean flag = true;
		boolean flag2 = true;
		// 1.Reader 表里的lendnum+1 和 canlendnum -1
		HttpSession session = request.getSession();

		ReaderDao readerDao = new ReaderDaoImpl();
		// 获取当前用户
		Reader reader = (Reader) session.getAttribute("user");
		System.out.println("----->" + reader);
		int r = reader.getLendNum();
		reader.setLendNum(r + 1);
		if (reader.getCanLendNum() > 1) {

			reader.setCanLendNum(reader.getCanLendNum() - 1);

			boolean b = readerDao.updateReaderPartInfo(reader);
		} else {
			flag = false;
		}

		// 2. lendbooks 要新插入一条数据
		// 获取数据封装成lendBooks对象
		LendBooks lendBooks = new LendBooks();
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		// 获取当前书籍
		Books book = bookDaoImpl.findBookByCodeBar(barCode);
		lendBooks.setBarCode(barCode);
		lendBooks.setBorrower(reader.getrName());
		lendBooks.setLendBook(book.getbName());
		lendBooks.setrNo(reader.getrNo());
		// 调用dao曾方法进行插入
		lendBooksDao lendBooksDao = new LendBookDaoImpl();
		boolean insertLendBook = lendBooksDao.insertLendBook(lendBooks);

		// 3 books 表里的state 标记为已接，lendNum -1,borrower标记借的人
		book.setState("已借");
		if (book.getLengNum() < 1) {
			flag2 = false;

		}
		book.setLengNum(book.getLengNum() - 1);
		book.setBorrower(reader.getrName());
		book.setBarCode(barCode);
		// 调用dao层的方法进行更新数据
		boolean insertBook = bookDaoImpl.updataBook(book);
		if (insertBook && flag && flag2 && insertLendBook) {
			request.setAttribute("success", "借阅成功了");
			request.getRequestDispatcher("LendBooks.jsp");
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
