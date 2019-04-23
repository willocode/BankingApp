package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

/**
 * Servlet implementation class StatusServlet
 */
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reimbursement re = new Reimbursement();
		ReimbursementDAO rdao = new ReimbursementDAOImpl(getServletContext());
		String action = request.getParameter("action");
		int reimid = Integer.parseInt(request.getParameter("reimid"));
		if(action.equals("approve")) {
			re.setPending(0);
			re.setDenied(0);
			re.setApproved(1);
			re.setId(reimid);
			rdao.updateReimbursement(re);
		} else if(action.equals("deny")) {
			re.setPending(0);
			re.setDenied(1);
			re.setApproved(0);
			re.setId(reimid);
			rdao.updateReimbursement(re);

		}
		response.sendRedirect("manager");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
