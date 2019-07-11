package com.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showbookdetail extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public showbookdetail() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doDelete method of the servlet. <br>
	 *
	 * This method is called when a HTTP delete request is received.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 显示图书的详细信息
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获得id
		String id = request.getParameter("id");
		Book book = DBUtil.findbBookById(id);
		out.write("书籍的id："+book.getId()+"  书名："+book.getName()+"  书籍的价格："+book.getPrice()+"  书籍的作者："+book.getAuthor());
		// 把当前浏览过的书籍的id写回客户端
		String historyString = orgnazeId(id, request);
		Cookie ck = new Cookie("historyString", historyString);
		ck.setPath("/");
		ck.setMaxAge(Integer.MAX_VALUE);// 设置cookie的保存时间
		response.addCookie(ck);// 写回客户端
	}

	/**
	 * 客户端 showallbooks showallbookdetails
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	private String orgnazeId(String id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 得到客户端的cookie
		Cookie ck[] = request.getCookies();
		if (ck == null) {
			return id;
		}

		// 查找有没有name叫做historyString的cookie
		Cookie hisbook = null;
		for (int i = 0; i < ck.length; i++) {
			if ("historyString".equals(ck[i].getName())) {
				hisbook = ck[i];
			}
		}
		// 如果没有historyString的cookie则才返回id
		if (hisbook == null) {
			return id;
		}
		String value = hisbook.getValue();
		String[] valueStrings = value.split("-");
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(valueStrings));// 插入删除比较方便
		if (list.size() < 3) {// 1 2
			// 如果包含这本书，将该书删除，最后将该书加入集合
			if (list.contains(id)) {
				list.remove(id);
			}
		}
			else {
				if (list.contains(id)) {
					list.remove(id);
				} else {
					list.removeLast();// 说明有三本书的id，把最后一个id删除
				}
			}
		
		list.addFirst(id);// 最新的书的id添加到最前面
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i > 0) {
				sBuffer.append("-");
			}
			sBuffer.append(list.get(i));
		}
		System.out.println(sBuffer);
		return sBuffer.toString();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPut method of the servlet. <br>
	 *
	 * This method is called when a HTTP put request is received.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * Returns information about the servlet, such as author, version, and
	 * copyright.
	 *
	 * @return String information about this servlet
	 */
	public String getServletInfo() {
		return "This is my default servlet created by Eclipse";
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
