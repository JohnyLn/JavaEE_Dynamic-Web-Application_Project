package com.bouvet.web.jdbc;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class AddToDo
 */
@WebServlet("/AddToDo")
public class AddToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private registerDButil registerDButil;
	@Resource(name="jdbc/Identification")
	private DataSource dataSource;
	@Override
	public void init() throws ServletException {
		super.init();
		registerDButil = new registerDButil(dataSource);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/AddToDo.jsp").forward(request, response);

		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String NewToDo = request.getParameter("descrip");
		System.out.print(NewToDo);

		registerDButil.add(NewToDo);
		String descrip = registerDButil.recover();
		request.setAttribute("descrip", descrip);
		
		ArrayList<Todo> todos;
		try {
			todos = registerDButil.getRegister();
			request.setAttribute("TODO_LIST", todos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/instructor-list-todo.jsp").forward(request, response);

	}

}
