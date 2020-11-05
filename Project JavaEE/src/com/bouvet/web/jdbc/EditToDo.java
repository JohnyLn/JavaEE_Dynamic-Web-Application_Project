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
 * Servlet implementation class EditToDo
 */
@WebServlet("/EditToDo")
public class EditToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private registerDButil registerDButil;
	@Resource(name="jdbc/Identification")
	private DataSource dataSource;
	int id;

	@Override
	public void init() throws ServletException {
		super.init();
		registerDButil = new registerDButil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id=Integer.parseInt(request.getParameter("todoId"));
		Todo todo = registerDButil.fetchTodo(id);
		request.setAttribute("Todo", todo);
		request.getRequestDispatcher("/EditToDo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String descrip= request.getParameter("descripupdate");
		Todo todo = new Todo(id,descrip);
		registerDButil.updateTodo(todo);
		
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
