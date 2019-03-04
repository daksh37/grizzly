package com.cts.grizzlystoreadminweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.grizzlystoreadminweb.bean.Login;
//import com.cts.grizzlystoreadminweb.dao.AddCategoryDAOImpl;
import com.cts.grizzlystoreadminweb.service.LoginService;
import com.cts.grizzlystoreadminweb.service.LoginServiceImpl;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		LoginService loginService = LoginServiceImpl.getInstance();
		String UserId = request.getParameter("userId");
		String password = request.getParameter("password");
		System.out.print(UserId+" "+password);
		/*AddCategoryDAOImpl addCategoryDAOImpl = new AddCategoryDAOImpl();
		System.out.print(addCategoryDAOImpl.getCategory());*/
		RequestDispatcher requestDispatcher = null;
		if(loginService.authenticate(UserId, password)!=null){
			//response.sendRedirect("admin.html");
			Login login = loginService.authenticate(UserId, password);
			int userstatus = loginService.getUserStatus(UserId);
			String authorization = loginService.authorization(UserId);
			if("A".equals(authorization)){
				if ( userstatus == 0){
					HttpSession session = request.getSession();
					session.setAttribute("userName", UserId);
					session.setAttribute("Name", login.getName());
					session.setAttribute("contactn", login.getContactno());
					session.setAttribute("address", login.getAddress());
					session.setAttribute("id", login.getId());
					session.setAttribute("designation", login.getDesignation());
					requestDispatcher = request.getRequestDispatcher("adminhome.jsp");
					requestDispatcher.forward(request, response);
				}
				else if( userstatus == 1){
					requestDispatcher = request.getRequestDispatcher("alogin.jsp");
					requestDispatcher.forward(request, response);
				}
				else if ( userstatus == 2){
					requestDispatcher = request.getRequestDispatcher("deact.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			
			else if("V".equals(authorization)){
				if ( userstatus == 0){
					HttpSession session = request.getSession();
					session.setAttribute("userName", UserId);
					requestDispatcher = request.getRequestDispatcher("venderhome.jsp");
					requestDispatcher.forward(request, response);
				}
				else if( userstatus == 1){
					requestDispatcher = request.getRequestDispatcher("alogin.jsp");
					requestDispatcher.forward(request, response);
				}
				else if ( userstatus == 2){
					requestDispatcher = request.getRequestDispatcher("deact.jsp");
					requestDispatcher.forward(request, response);
				}
			}
		}
		else{
			requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
