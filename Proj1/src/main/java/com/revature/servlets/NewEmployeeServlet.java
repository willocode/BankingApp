package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

/**
 * Servlet implementation class NewEmployeeServlet
 */
public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO edao = new EmployeeDAOImpl(getServletContext());
		Employee currentUser = (Employee) request.getSession().getAttribute("username");
		
		String euser = request.getParameter("user");
		String epass = request.getParameter("pass");
		String etitle = request.getParameter("title");
		String eman = request.getParameter("manager");

		Employee emp = new Employee();
		
		if (currentUser == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
			return;
		}
		
		emp.setUsername(euser);
		emp.setPassword(epass);
		emp.setTitle(etitle);
		emp.setManagerId(Integer.parseInt(eman));


		edao.newEmployee(emp);
		response.sendRedirect("manager");
	}

}
