package com.revature.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		
		//TODO add validations. username can't be empty or null..
		EmployeeDAO edao = new EmployeeDAOImpl(getServletContext());
		Employee empl = edao.getByUsername(username);
		
		if (empl == null) {
			System.out.println("empl is null");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
			return;
		}
		System.out.println("empl exists ");
		System.out.println("given password: " + password);
		System.out.println("users password: " + empl.getPassword());
		
		if (password.equals(empl.getPassword())) {
			request.setAttribute("successMessge", "Login Successful");
			request.getSession().setAttribute("username", empl);
			
			if(empl.getTitle().equals("manager")) {
				response.sendRedirect("manager");
			}else {
				response.sendRedirect("employee");
			}
			
		}else {
			response.sendRedirect("login");

		}
		
//		doGet(request, response);
	}

}
