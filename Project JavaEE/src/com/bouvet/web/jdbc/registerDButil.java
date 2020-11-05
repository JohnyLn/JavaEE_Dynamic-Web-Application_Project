package com.bouvet.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

public class registerDButil {
	private DataSource dataSource;
	public registerDButil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public int login (String id,String mdp) {
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		int status=-1;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select status from register where identifiant=\"" + id + "\" and password=\""+mdp+ "\"";
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
				status = myRs.getInt("status");
			}			
			return status;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return status;
		} finally{
			close(myConn,myStmt,myRs);
		}
	}
	public ArrayList<Todo> getRegister() throws Exception {
		ArrayList<Todo> todo= new ArrayList<Todo>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from todo order by id";
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
				int id = myRs.getInt("id");
				String descrip=myRs.getString("descrip");
				Todo tempTodo= new Todo(id,descrip);
				todo.add(tempTodo);
			}
			return todo;
		} finally{
			close(myConn,myStmt,myRs);
		}
	}
	public Todo fetchTodo(int id) {
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		Todo todo=null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from todo where id="+id;
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
				String descrip=myRs.getString("descrip");
				todo = new Todo(id,descrip);
			}
			return todo;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		} finally{
			close(myConn,myStmt,myRs);
		}
	}
	public void updateTodo(Todo todo) {
		Connection myConn=null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "update todo set descrip=? where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1,todo.getDescrip());
			myStmt.setInt(2,todo.getId());
			myStmt.execute();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			close(myConn,myStmt,null);
		}
	}
	public void deleteTodo(int id) {
		// TODO Auto-generated method stub
		Connection myConn=null;
		Statement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "delete from todo where id="+id;
			myStmt.execute(sql);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{ close(myConn,myStmt,null); }
	}

	public String recover() {

		Connection myConn=null;
		Statement myStmt= null;
		ResultSet myRs=null;
		String descrip="";

		try{
			myConn= dataSource.getConnection();
			//Step3: create SQL statements
			String sql = "select * from todo";
			myStmt= myConn.createStatement();
			//Step4: Execute SQL query
			myRs=myStmt.executeQuery(sql);
			//Step5: Process the ResultSet
			while(myRs.next()){
				descrip = descrip + "<br>"+ myRs.getString("descrip");
			}
			return descrip;

		}catch(Exception exc){
			System.out.println(exc.getMessage());
			return null;
		}
		finally{
			close(myConn,myStmt,myRs);
		}

	}

	public void add (String descrip ){
		//We can use also PreparedStatement !!
		//-> 		myStmt.setString(1, descrip);
		Connection myConn=null;
		Statement myStmt = null;	
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql = "INSERT INTO todo (descrip) VALUE (\'"+ descrip +"\')";	

			myStmt.execute(sql);
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
		finally{
			close(myConn,myStmt,null);
		}
	}




	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try{
			if(myStmt!=null)
				myStmt.close();
			if(myRs!=null)
				myRs.close();
			if(myConn!=null)
				myConn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}