package com.yuzhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuzhi.daoimpl.ReaderDaoImpl;
import com.yuzi.dao.ReaderDao;

/**
 * Servlet implementation class removeReaderServlet
 */
@WebServlet("/removeReaderServlet")
public class removeReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public removeReaderServlet() {
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
		String rName = request.getParameter("rmreaderName");
		String rNo = request.getParameter("rNo");
		// 封装成对象
		/*
		 * Reader reader = new Reader(); reader.setrName(rName);
		 * reader.setrNo(rNo);
		 */
		// 调用dao层的方法
		ReaderDao readerDao = new ReaderDaoImpl();
		boolean b = readerDao.deleteReader(Integer.parseInt(rNo));
		if (b) {
			response.sendRedirect("ReaderInfoServlet");

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
